/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.astm;

import com.isofh.HardCode;
import com.isofh.Util;
import com.isofh.connection.Client;
import com.isofh.hibernate.model.MRVServiceMedicaltest;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

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
    private int HIS_PatientHistory_ID = 0;
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
        boolean isOK = HIS_PatientHistory_ID > 0 && HIS_Service_MedicTestGroup_ID > 0;
        if (isOK & !isDone) {
            isOK = updateResults(HIS_PatientHistory_ID, HIS_Service_MedicTestGroup_ID, results);
        }
        clear();
        return true;
    }

    private void clear() {
        HIS_PatientHistory_ID = 0;
        HIS_Service_MedicTestGroup_ID = 0;
        results = new ArrayList<Result>();
        seQ_Re = 0;
    }

    private boolean result(String mes) {
        log.debug("Recieve result: " + mes);
        boolean isOK = HIS_PatientHistory_ID > 0 && HIS_Service_MedicTestGroup_ID > 0;
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
        String strPatientID = "";
        try {
            String[] temp = mes.split("\\|");
            strPatientID = temp[2];
            HIS_PatientHistory_ID = Integer.parseInt(strPatientID);
            log.debug("Recieve patient: " + HIS_PatientHistory_ID);
            return true;
        } catch (Exception e) {
            log.error("Cannot parse: " + strPatientID);
            return false;
        }
    }

    private boolean order(String mes) {
        log.debug("Recieve order: " + mes);
        String strOrderID = "";
        try {
            String[] temp = mes.split("\\|");
            strOrderID = temp[2];
            HIS_Service_MedicTestGroup_ID = Integer.parseInt(strOrderID);
            log.debug("Recieve order: " + HIS_Service_MedicTestGroup_ID);
            return true;
        } catch (Exception e) {
            log.error("Cannot parse: " + strOrderID);
            return false;
        }
    }

    private boolean updateResults(int HIS_PatientHistory_ID, int HIS_Service_MedicTestGroup_ID, List<Result> results) {
        for (Result result : results) {
//            HisServiceMedicaltest serviceMedicaltest = Model.getServiceTestByValue(result.getValue(), HIS_Service_MedicTestGroup_ID);
//            serviceMedicaltest.setin (BigDecimal.ZERO);
        }
        return true;
    }

    public boolean sendOrders(int hisPatientHistoryId) {
        boolean isOK = !isDone;
        try {
            List<MRVServiceMedicaltest> services = MRVServiceMedicaltest.getServiceTestByPatientID(hisPatientHistoryId);
            
            String str1 = Message.header();
            String str2 = Message.patient(services.get(0));
            String str3 = Message.order(1, services);
            String str4 = Message.terminator();

            String[] listMes = new String[]{str1, str2, str3, str4};

            if (isOK & !isDone) {
                isOK = sendMessages(listMes);
            }
        } catch (Exception e) {
            log.error(e);
            isOK = false;
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
//                if(!isOK){
//                    break;
//                }
            }
            
            if(isOK & !isDone){
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
                Thread.sleep(1000);
                if (sendOrders(2080058)) {
                    Thread.sleep(60000);
                };
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
        log.debug("Stop thread handle message of " + client.getID());
    }
}
