/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.network;

import com.minhthuan.lib.ultil.Global;
import java.awt.AWTEventMulticaster;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanmi
 */
public class MyServer extends Thread {

    private final String TAG = "MyServer: ";
    private ServerSocket server;
    private boolean isRunning = true;
    private List<MyClient> allClient;

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Server run");
        try {
            while (isRunning) {
                if (server == null) {
                    System.out.println(TAG + "Server is null!");
                    break;
                }
                final Socket client = server.accept();
                checkClientExist(client);
                System.out.println(TAG + "Connected with the client: " + client.getInetAddress().toString());

                MyClient myClient = new MyClient(client);
                myClient.start();
                System.out.println("Add client: " + myClient.getIP());
                allClient.add(myClient);
                System.out.println("The number of client: " + allClient.size());
                
            }

        } catch (IOException ex) {
            System.out.println(TAG + ex.getMessage());
        }

    }

    public MyServer() {
        try {
            server = new ServerSocket(Global.PORT);
            allClient = new ArrayList<MyClient>();
        } catch (IOException ex) {
            System.out.println(TAG + ex.getMessage());
        }
    }

    public void stopServer() {
        isRunning = false;
    }

    private void checkClientExist(Socket socket) {
        List<MyClient> temp = new ArrayList<>();
        for (MyClient m : allClient) {
            if (m.getIP().equals(socket.getInetAddress().toString())) {
                temp.add(m);
            }
        }
        removeClient(temp);
    }

    private void removeClient(List<MyClient> myClient) {
        for (MyClient m : myClient) {
            System.out.println(TAG + "Remove client: " + m.getIP());
            if (m.isConnect()) {
                m.close();
            }
            allClient.remove(m);
        }
    }

}
