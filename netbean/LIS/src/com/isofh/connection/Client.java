/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.connection;

import com.isofh.Util;
import com.isofh.astm.Message;
import com.isofh.astm.MessageHandle;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class Client extends Thread {

    private static final Logger log = Logger.getLogger(Client.class.getName());
    private Socket socket = null;
    private int ID = -1;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;
    private boolean isDone = false;
    private CallBack callBack = null;
    private MessageHandle messageHandle = null;

    public Client(CallBack callBack, Socket socket) {
        super();
        this.callBack = callBack;
        this.socket = socket;
        ID = socket.getPort();
        messageHandle = new MessageHandle(this);
    }

    @Override
    public void run() {
        log.debug("Client thread " + ID + " running.");
        while (!isDone) {
            try {
                byte[] data = new byte[2048];
                int m = streamIn.read(data);
                if (m == -1) {
                    log.debug(socket + " is closed by foreign host!");
                    isDone = true;
                } else {
                    log.debug("Client[" + ID + "]: Recieve[" + m + "] - " + Util.getMessage(data, m) + " - [" + Util.bytesToHex(data, m) + "]");
                    if (isValidChecksum(data, m)) {
                        handle(data, m);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                isDone = true;
            }
        }
        close();
    }

    public int getID() {
        return ID;
    }

    private synchronized boolean handle(byte[] data, int length) {
        return messageHandle.handle(data, length);
    }

    public void open() {
        try {
            streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            log.error(socket + "Error opening: " + e.getMessage());
            close();
        }
    }

    private boolean close() {
        try {
            isDone = true;
            callBack.onClosed(ID);
            if (messageHandle != null) {
                messageHandle.stop();
            }

            if (streamIn != null) {
                streamIn.close();
            }
            if (streamOut != null && !socket.isClosed()) {
                streamOut.close();
            }
            if (socket != null) {
                log.debug("Close client socket: " + socket);
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(socket + "Error closing: " + e.getMessage());
            socket = null;
            streamIn = null;
            streamOut = null;
            return false;
        }
        return true;
    }

    private boolean send(byte[] data) {
        try {
            log.debug("Client Send data: " + Util.bytesToHex(data));
            streamOut.write(data);
            streamOut.flush();
            return true;
        } catch (Exception e) {
            log.error(socket + " Error sending: " + e.getMessage());
            close();
            return false;
        }
    }
    
    public boolean sendFlag(byte flag){
        return send(new byte[]{flag});
    }

    public boolean sendMessage(int seQ, boolean isLast, byte[] mes) {
        if(mes.length == 1){
            return send(mes);
        }
        
        byte[] data = new byte[mes.length + 8];
        int length = data.length;
        // start frame
        data[0] = Message.STX;
        // Seq
        data[1] = String.valueOf(seQ).getBytes()[0];
        for (int i = 0; i < mes.length; i++) {
            data[i + 2] = mes[i];
        }
        data[length - 6] = Message.CR;
        // end frame
        if (isLast) {
            data[length - 5] = Message.ETX;
        } else {
            data[length - 5] = Message.ETB;
        }
        String checkSum = calChecksum(data);
        data[length - 4] = checkSum.getBytes()[0];
        data[length - 3] = checkSum.getBytes()[1];
        data[length - 2] = Message.CR;
        data[length - 1] = Message.LF;
        return send(data);
    }

    private String calChecksum(byte[] data, int length) {
        if (length == 0) {
            length = data.length;
        }
        int sum = 0;
        for (int i = 1; i < length - 4; i++) {
            sum += data[i];
        }
        byte[] result = new byte[]{(byte) ((sum % 256) & 255)};
        return Util.bytesToHex(result);
    }

    private String calChecksum(byte[] data) {
        return calChecksum(data, 0);
    }

    private boolean isValidChecksum(byte[] data, int length) {
        if (length == 0) {
            length = data.length;
        }
        if (length <= 8) {
            return true;
        }
        String recCr = new String(new byte[]{data[length - 4], data[length - 3]}, Charset.forName("UTF-8"));
        String calCr = calChecksum(data, length);
        if (recCr.equals(calCr)) {
            return true;
        } else {
            log.error("Checksum is not valid : " + recCr + " - " + calCr);
            return false;
        }
    }
}
