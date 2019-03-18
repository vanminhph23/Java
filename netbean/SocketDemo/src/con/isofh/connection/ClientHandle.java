/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package con.isofh.connection;

import com.isofh.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class ClientHandle extends Thread {
    
    private static final Logger log = Logger.getLogger(ClientHandle.class.getName());
    private Socket socket = null;
    private int ID = -1;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;
    private boolean isDone = false;
    private CallBack callBack = null;
    
    public ClientHandle(CallBack callBack, Socket socket) {
        super();
        this.callBack = callBack;
        this.socket = socket;
        ID = socket.getPort();
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
                    close();
                } else {
                    log.debug("Client[" + ID + "]: Recieve[" + m + "] - " + new String(data).trim() + " - [" + Util.bytesToHex(data, m) + "]");
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
    
    public int getID() {
        return ID;
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
            if (socket != null) {
                log.debug("Close client socket: " + socket);
                socket.close();
            }
            if (streamIn != null) {
                streamIn.close();
            }
            if (streamOut != null) {
                streamOut.close();
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
    
    public boolean send(byte[] data) {
        try {
            streamOut.write(data);
            streamOut.flush();
            return true;
        } catch (Exception e) {
            log.error(socket + " Error sending: " + e.getMessage());
            close();
            return false;
        }
    }
    
}
