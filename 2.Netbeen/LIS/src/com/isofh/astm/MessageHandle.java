/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.astm;

import com.isofh.HardCode;
import com.isofh.Util;
import com.isofh.connection.Client;
import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.model.MPatientHistory;
import com.isofh.hibernate.model.MRVServiceMedicaltest;
import com.isofh.hibernate.model.MServiceMedicaltest;
import com.isofh.hibernate.model.MServiceMedicaltestLine;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vanminh
 */
public class MessageHandle implements Runnable {

    private final Logger log = Logger.getLogger(MessageHandle.class.getName());
    private Client client = null;
    private boolean isResend = false;
    private Thread threadSend = null;
    private boolean isDone = false;
    private int seQ_Re = 0, SeQ_Se = 0;
    private boolean isSuccess = false;
    private String value = "";
    private int HIS_Service_MedicTestGroup_ID = 0;
    private List<Result> results = new ArrayList<Result>();

    public MessageHandle(Client client) {
        this.client = client;
        start();
    }

    public void stop() {
        isDone = true;
        if (threadSend != null) {
            threadSend = null;
        }
    }

    public void start() {
        if (threadSend == null) {
            threadSend = new Thread(this);
            threadSend.start();
        }
    }

    public boolean handle(byte[] data, int length) {
        boolean isOK = !isDone;

        if (data[0] == Message.ACK) {
            log.debug("Recieve: ACK");
            isSuccess = true;
        } else if (data[0] == Message.ENQ) { // The first
            log.debug("Recieve: ENQ");
            clear();
            if (isOK & !isDone) {
                isOK = client.sendFlag(Message.ACK);
            }
        } else if (data[0] == Message.EOT) { // The end
            log.debug("Recieve: EOT");
            if (isOK & !isDone) {
                isOK = client.sendFlag(Message.ACK);
            }
        } else if (data[0] == Message.NACK) { // The end
            log.debug("Recieve: NACK");
            isResend = true;
        } else if (length > 1) {
            String mes = Util.getMessage(data, length);
            int seQNext = Integer.parseInt(mes.substring(0, 1));
            if (seQNext != seQ_Re + 1) {
                log.error("Sequence not match! " + seQNext + " - " + seQ_Re);
                return false;
            }

            char typeMes = mes.charAt(1);
            isOK = true;
            switch (typeMes) {
                case 'H':
                    isOK = header(mes);
                    break;
                case 'R':
                    isOK = result(mes);
                    break;
                case 'P':
                    isOK = patient(mes);
                    break;
                case 'O':
                    isOK = order(mes);
                    break;
                case 'L':
                    isOK = terminator(mes);
                    break;
                default:
                    break;
            }
            if (isOK & !isDone) {
                isOK = client.sendFlag(Message.ACK);
                seQ_Re = seQNext;
            } else {
                isOK = client.sendFlag(Message.NACK);
                log.error("handle: Cant parse mes: " + mes);
            }
        }
        return isOK;
    }

    private boolean header(String mes) {
        log.debug("Recieve header: " + mes);
        return true;
    }

    private boolean terminator(String mes) {
        log.debug("Recieve terminator: " + mes);
        boolean isOK = !value.isEmpty() && HIS_Service_MedicTestGroup_ID > 0;
        if (isOK & !isDone) {
            isOK = updateResults(HIS_Service_MedicTestGroup_ID, results);
        }
        clear();
        return true;
    }

    private void clear() {
        value = "";
        HIS_Service_MedicTestGroup_ID = 0;
        results = new ArrayList<Result>();
        seQ_Re = 0;
    }

    private boolean result(String mes) {
        log.debug("Recieve result: " + mes);
        boolean isOK = !value.isEmpty() && HIS_Service_MedicTestGroup_ID > 0;
        try {
            String[] temp = mes.split("\\|");
            String value = temp[2].replaceAll("\\^", "");
            String result = temp[3];
            results.add(new Result(value, result));
            return true;
        } catch (Exception e) {
            log.equals(e.getMessage());
            return false;
        }
    }

    private boolean patient(String mes) {
        log.debug("Recieve patient: " + mes);
        try {
            String[] temp = mes.split("\\|");
            value = temp[2];
            log.debug("Recieve patient: " + value);
            return true;
        } catch (Exception e) {
            log.error("Cannot parse: " + value);
            return false;
        }
    }

    private boolean order(String mes) {
        log.debug("Recieve order: " + mes);
        String strOrderID = "";
        try {
            String[] temp = mes.split("\\|");
            strOrderID = temp[2];
            strOrderID = strOrderID.substring(0, strOrderID.length() - 2);
            HIS_Service_MedicTestGroup_ID = Integer.parseInt(strOrderID);
            log.debug("Recieve order: " + HIS_Service_MedicTestGroup_ID);
            return true;
        } catch (Exception e) {
            log.error("Cannot parse: " + strOrderID);
            return false;
        }
    }

    private boolean updateResults(int HIS_Service_MedicTestGroup_ID, List<Result> results) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            for (Result result : results) {
                MServiceMedicaltest serviceMedicaltest = MServiceMedicaltest.getByHISLISCode(result.getValue(), HIS_Service_MedicTestGroup_ID);
                if (serviceMedicaltest != null) {
                    serviceMedicaltest.setIndicatorStr(result.getResult());
                    serviceMedicaltest.setStatus(MServiceMedicaltest.Status.STATUS_HR.Status());
                    serviceMedicaltest.setUpdated(new Timestamp(System.currentTimeMillis()));
                    serviceMedicaltest.setUpdatedby(MServiceMedicaltest.AD_USER_ID_HIS_LIS);
                    session.update(serviceMedicaltest);
                    continue;
                }
                MServiceMedicaltestLine serviceMedicaltestLine = MServiceMedicaltestLine.getByHISLISCode(result.getValue(), HIS_Service_MedicTestGroup_ID);
                if (serviceMedicaltestLine != null) {
                    serviceMedicaltestLine.setIndicatorStr(result.getResult());
                    serviceMedicaltestLine.setUpdated(new Timestamp(System.currentTimeMillis()));
                    serviceMedicaltestLine.setUpdatedBy(MServiceMedicaltest.AD_USER_ID_HIS_LIS);
                    session.update(serviceMedicaltestLine);
                }

            }
            MServiceMedicaltest.updateStatus(HIS_Service_MedicTestGroup_ID, MServiceMedicaltest.Status.STATUS_HR);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean sendOrders(int groupID) {
        boolean isOK = !isDone;
        try {
            List<MRVServiceMedicaltest> services = MRVServiceMedicaltest.getByGroupMedicaltestID(groupID);
            MPatientHistory patientHistory = MPatientHistory.getByMedicaltestGroupID(groupID);
            String str1 = Message.header();
            String str2 = Message.patient(patientHistory);
            String str3 = Message.order(services);
            String str4 = Message.terminator();

            String[] listMes = new String[]{str1, str2, str3, str4};

            if (isOK & !isDone) {
                isOK = sendMessages(listMes);
            }

            if (isOK) {
                log.debug("sendOrders: Send successfully " + groupID);
                isOK = MServiceMedicaltest.updateStatus(groupID, MServiceMedicaltest.Status.STATUS_AC);
            }
        } catch (Exception e) {
            log.error(e);
            isOK = false;
        } finally {
        }
        if (!isOK & !isDone) {
            log.error("sendOrders: Cant send mes");
        }
        return isOK;
    }

    private boolean sendMessages(String[] listMes) {
        boolean isOK = !isDone;
        try {
            int send = 0;
            int seQ = -1;
            List<byte[]> listMesInBye = new ArrayList<>();
            listMesInBye.add(new byte[]{Message.ENQ});
            for (String mes : listMes) {
                listMesInBye.add(mes.getBytes("UTF-8"));
            }

            for (byte[] mes : listMesInBye) {
                isSuccess = false;
                isResend = false;
                seQ++;
                send = 0;
                log.debug("Send mes: " + new String(mes));
                isOK = client.sendMessage(seQ, seQ == listMes.length, mes);
                while (isOK & !isDone) {
                    if (isSuccess) {
                        break;
                    }

                    if (isResend) {
                        isResend = false;
                        isOK = client.sendMessage(seQ, seQ == listMes.length, mes);
                        log.debug("Resend mes: " + mes);
                        send++;
                        if (send >= HardCode.TIME_OUT / HardCode.TIME_TRY_TO_SEND) {
                            isOK = false;
                            log.debug("A lot of NACK");
                            break;
                        }
                        continue;
                    }

                    log.debug("Not Receive ACK.");
                    Thread.sleep(HardCode.TIME_TRY_TO_SEND);
                    send++;
                    if (send >= HardCode.TIME_OUT / HardCode.TIME_TRY_TO_SEND) {
                        isOK = false;
                        log.debug("Time out.");
                        break;
                    }
                }
                if (!isOK) {
                    break;
                }
            }

            if (isOK & !isDone) {
                client.sendFlag(Message.EOT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            isOK = false;
        }
        if (!isOK & !isDone) {
            log.error("sendMessages: Cant send mes");
        }
        return isOK;
    }

    @Override
    public void run() {
        while (!isDone) {
            try {
                Thread.sleep(HardCode.TIMER_SEND_DATA);
                List<Integer> allGroupMedicaltest = MRVServiceMedicaltest.getGroupMedicaltestID();
                if(allGroupMedicaltest == null){
                    continue;
                }
                for (Integer groupID : allGroupMedicaltest) {
                    sendOrders(groupID);
                    Thread.sleep(2000);
                }
                
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        log.debug("Stop thread handle message of " + client.getID());
    }
}
