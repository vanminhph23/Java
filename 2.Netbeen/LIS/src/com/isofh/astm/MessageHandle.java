/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.astm;

import com.isofh.HardCode;
import com.isofh.hibernate.entities.HisPatienthistory;
import com.isofh.hibernate.entities.HisServiceMedicaltest;
import com.isofh.hibernate.entities.Model;
import con.isofh.connection.Client;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class MessageHandle implements Runnable {

    private final Logger log = Logger.getLogger(MessageHandle.class.getName());
    private Client client = null;
    private boolean isReady = false;
    private Thread threadSend = null;
    private boolean isDone = false;

    public MessageHandle(Client client) {
        this.client = client;
        start();
    }

    public void stop() {
        if (threadSend != null) {
            isDone = true;
            threadSend = null;
        }
    }

    public void start() {
        if (threadSend == null) {
            threadSend = new Thread(this);
            threadSend.start();
        }
    }

    public boolean handle(byte[] data) {
        boolean isOK = !isDone;

        if (data[0] == Message.ACK) {
            log.debug("Recieve: ACK");
            isReady = true;
        } else if (data[0] == Message.ENQ) { // The first
            log.debug("Recieve: ENQ");
            if (isOK) {
                isOK = client.sendACK();
            }
        } else if (data[0] == Message.EOT) { // The end
            log.debug("Recieve: EOT");
            if (isOK) {
                isOK = client.sendACK();
            }
        } else {
            char recordType = (char) data[1];
            switch (recordType) {
                case 'H':
                    break;
                case 'Q':
                    break;
                case 'R':
                    break;
                case 'O':
                    break;
                case 'L':
                    break;
                default:
                    break;
            }
            if (isOK) {
                isOK = client.sendACK();
            }
        }

        if (!isOK) {
            log.error("handle: Cant send mes");
        }

        return isOK;
    }

    public boolean sendOrders(int hisPatientHistoryId) {
        boolean isOK = true;
        try {
            if (isOK) {
                isOK = client.sendENQ();
            }

            HisPatienthistory patienthistory = Model.getPatientByID(hisPatientHistoryId);
            List<HisServiceMedicaltest> services = Model.getServiceTestByPatientID(hisPatientHistoryId);

            String str1 = Message.header();
            String str2 = Message.patient(patienthistory);
            String str3 = Message.order(1, services);
            String str4 = Message.terminator();

            String[] listMes = new String[]{str1, str2, str3, str4};

            if (isOK) {
                isOK = sendMessages(listMes);
            }

            if (isOK) {
                isOK = client.sendEOT();
            }
        } catch (Exception e) {
            log.error(e);
            isOK = false;
        }
        if (!isOK) {
            log.error("sendOrders: Cant send mes");
        }
        return isOK;
    }

    private boolean sendMessages(String[] listMes) {
        boolean isOK = true;
        try {
            int send = 0;
            int seQ = 1;
            for (String mes : listMes) {
                while (isOK) {
                    if (!isReady) {
                        Thread.sleep(HardCode.TIME_TRY_TO_SEND);
                        send++;
                        if (send >= HardCode.TIME_OUT / HardCode.TIME_TRY_TO_SEND) {
                            isOK = false;
                            break;
                        }
                    } else {
                        isReady = false;
                        isOK = client.sendMessage(seQ, seQ == listMes.length, mes);
                        seQ++;
                        send = 0;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            log.error(e);
            isOK = false;
        }
        if (!isOK) {
            log.error("sendMessages: Cant send mes");
        }
        return isOK;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e);
        }
        if (!sendOrders(2081158)) {
            stop();
        };
    }
}
