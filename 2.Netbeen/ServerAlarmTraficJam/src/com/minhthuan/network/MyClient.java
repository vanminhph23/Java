package com.minhthuan.network;

import com.google.gson.Gson;
import com.minhthuan.lib.maps.Marker;
import com.minhthuan.lib.maps.MyLatLong;
import com.minhthuan.lib.result.BaseResult;
import com.minhthuan.lib.result.Protocol;
import com.minhthuan.lib.ultil.Global;
import com.minhthuan.lib.user.SettingUser;
import com.minhthuan.lib.user.User;
import com.minhthuan.sqlserver.DBMarker;
import com.minhthuan.sqlserver.DBSettingUser;
import com.minhthuan.sqlserver.DBUser;
import com.minhthuan.ultil.Ultil;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class MyClient extends Thread {

    private final String TAG = "MyClient: ";
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private User user;

    public MyClient(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        } catch (IOException ex) {
            System.out.println(TAG + ex.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public int getIdClient() {
        return user.getId();
    }

    public boolean send(String str) {
        if (isConnect()) {
            System.out.println("send: " + str);
            printWriter.println(str);
        }
        return false;
    }

    public boolean isConnect() {
        if (socket != null && socket.isConnected()) {
            return true;
        }
        return false;
    }

    public String getIP() {
        if (isConnect()) {
            return socket.getInetAddress().toString();
        } else {
            return null;
        }
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(TAG + "Start");
        String strLine;
        try {
            while (socket != null && socket.isConnected()) {
                while ((strLine = bufferedReader.readLine()) != null) {
                    //TODO: Xu ly nhan du lieu tu client  
                    System.out.println("onDataReceive: " + strLine);
                    Protocol protocol = new Gson().fromJson(strLine, Protocol.class);
                    DBUser dBUser;
                    DBMarker dBMarker;
                    DBSettingUser dBSettingUser;
                    BaseResult baseResult;
                    switch (protocol.getType()) {
                        case LOGIN:
                            user = new Gson().fromJson(protocol.getObject(), User.class);
                            System.out.println("LOGIN: " + user.toString());
                            dBUser = new DBUser(Ultil.server);
                            user = dBUser.checkUser(user);
                            if (user == null) {
                                baseResult = new BaseResult(Protocol.Type.LOGIN, Global.MSG_ERROR, null, "Account not valid!");
                            } else {
                                baseResult = new BaseResult(Protocol.Type.LOGIN, Global.MSG_SUCCESS, user, null);
                            }
                            send(new Gson().toJson(baseResult));
                            break;
                        case SIGUP:

                            user = new Gson().fromJson(protocol.getObject(), User.class);
                            System.out.println("SIGNUP: " + user.toString());
                            dBUser = new DBUser(Ultil.server);
                            user = dBUser.addItem(user);
                            if (user == null) {
                                baseResult = new BaseResult(Protocol.Type.SIGUP, Global.MSG_ERROR, null, "Account not valid!");
                            } else {
                                baseResult = new BaseResult(Protocol.Type.SIGUP, Global.MSG_SUCCESS, user, null);
                            }
                            send(new Gson().toJson(baseResult));

                            break;
                        case ADD_MARKER:
                            Marker marker = new Gson().fromJson(protocol.getObject(), Marker.class);
                            System.out.println("ADD_MARKER: " + marker.toString());
                            dBMarker = new DBMarker(Ultil.server);
                            if (!dBMarker.addItem(marker)) {
                                baseResult = new BaseResult(Protocol.Type.ADD_MARKER, Global.MSG_ERROR, null, "Marker not valid!");
                            } else {
                                baseResult = new BaseResult(Protocol.Type.ADD_MARKER, Global.MSG_SUCCESS, null, null);
                            }
                            send(new Gson().toJson(baseResult));
                        case GET_MARKER:
                            MyLatLong myLatLong = new Gson().fromJson(protocol.getObject(), MyLatLong.class);
                            dBMarker = new DBMarker(Ultil.server);
                            List<Marker> list;
                            System.out.println("GET_MARKER: ");
                            if (user == null) {
                                user = new Gson().fromJson(protocol.getUser(), User.class);
                            }
                            if (myLatLong != null) {
                                System.out.println("Your location is exist: " + myLatLong.toString());
                                list = dBMarker.getAll(myLatLong, user.getSettingUser());
                            } else {
                                System.out.println("Your location is null!");
                                list = dBMarker.getAll(user.getSettingUser());
                            }
                            System.out.println("GET_MARKER: Total marker: " + list.size());
                            baseResult = new BaseResult(Protocol.Type.GET_MARKER, Global.MSG_SUCCESS, list, null);
                            send(new Gson().toJson(baseResult));
                            break;
                        case UPDATESETTING:
                            if (user == null) {
                                user = new Gson().fromJson(protocol.getUser(), User.class);
                            }
                            SettingUser setting = new Gson().fromJson(protocol.getObject(), SettingUser.class);
                            dBSettingUser = new DBSettingUser(Ultil.server);
                            setting = dBSettingUser.updateItem(setting);

                            if (setting == null) {
                                baseResult = new BaseResult(Protocol.Type.UPDATESETTING, Global.MSG_ERROR, null, "Setting not valid!");
                            } else {
                                baseResult = new BaseResult(Protocol.Type.UPDATESETTING, Global.MSG_SUCCESS, null, null);
                            }
                            send(new Gson().toJson(baseResult));

                            break;
                        case UPDATE_AVATAR:

                            byte[] mybytearray = new byte[1024];
                            InputStream is = socket.getInputStream();
                            FileOutputStream fos = new FileOutputStream("F:\\minh.jpg");
                            BufferedOutputStream bos = new BufferedOutputStream(fos);
                            int bytesRead = is.read(mybytearray, 0, mybytearray.length);
                            bos.write(mybytearray, 0, bytesRead);
                            bos.close();

                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.println(TAG + "Finish");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean close() {
        if (isConnect()) {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(TAG + e.getMessage());
                return false;
            }
        }
        return true;
    }

}
