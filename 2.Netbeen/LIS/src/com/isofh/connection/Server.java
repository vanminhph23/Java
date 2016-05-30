/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class Server implements Runnable, CallBack {

    private static final Logger log = Logger.getLogger(Server.class.getName());
    private ServerSocket server = null;
    private Thread thread = null;
    private List<Client> clients = new ArrayList<>();
    private final int MAX_CLIENT = 50;
    private boolean isDone = false;

    public Server(int port) {
        try {
            log.debug("Binding to port " + port + ", please wait ....");
            server = new ServerSocket(port);
            log.debug("Server started: " + server);
            start();

        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            isDone =  true;
            thread = null;
        }
    }

    public boolean addThread(Socket socket) {
        if (clients.size() > MAX_CLIENT) {
            log.error("The number of client is over : " + MAX_CLIENT);
            return false;
        }

        log.debug("Client accepted: " + socket);
        Client client = new Client(this, socket);
        try {
            client.open();
            client.start();
            clients.add(client);
            log.debug("Total client: " + clients.size());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error opening thread: " + e);
            return false;
        }
        return true;
    }

    private void remove(int ID) {
        int i = findClient(ID);
        if (i >= 0) {
            clients.remove(i);
        }
    }

    private int findClient(int ID) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void run() {
        while (thread != null && !isDone) {
            try {
                log.debug("Waiting for a client ...");
                addThread(server.accept());
            } catch (IOException ie) {
                log.debug("Acceptance Error: " + ie);
            }
        }
    }

    @Override
    public void onClosed(int ID) {
        remove(ID);
        log.debug("Total client: " + clients.size());
    }

}
