/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.sqlserver;

import com.minhthuan.lib.maps.Marker;
import com.minhthuan.lib.maps.MyLatLong;
import com.minhthuan.lib.user.SettingUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sev_user
 */
public class DBMarker {

    private final String[] KEY_DB = new String[]{"ID", "Lat", "Long", "LevelJam", "Reporter", "TimeReport", "Comment"};
    private final String TABLE = "Table_Marker";
    private SQLServer sQLServer;
    private final String TAG = "DBMarker: ";

    public DBMarker(SQLServer sQLServer) {
        this.sQLServer = sQLServer;
    }

    private Marker getItem(ResultSet rs) throws SQLException {
        Marker.Level level = null;
        switch (rs.getInt(KEY_DB[3])) {
            case Marker.GOOD:
                level = Marker.Level.Good;
                break;
            case Marker.LIGHT_JAM:
                level = Marker.Level.Light_Jam;
                break;
            case Marker.JAM:
                level = Marker.Level.Jam;
                break;
            case Marker.HEAVY_JAM:
                level = Marker.Level.Heavy_Jam;
                break;
            default:
                break;
        }

        return new Marker(rs.getInt(KEY_DB[0]), new MyLatLong(rs.getDouble(KEY_DB[1]), rs.getDouble(KEY_DB[2])), level, rs.getInt(KEY_DB[4]), rs.getString(KEY_DB[5]), rs.getString(KEY_DB[6]));
    }

    private Marker getItem(String cmds) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmds);
            Marker marker = null;
            if (resultSet.next()) {
                marker = getItem(resultSet);
            }
            return marker;
        } catch (SQLException ex) {
            Logger.getLogger(SQLServer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }
        }
    }

    private List<Marker> getItems(String cmds) {
        Connection connection = null;
        Statement statement = null;
        try {
            List<Marker> listMarker = new ArrayList<Marker>();
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(cmds);
            while (resultSet.next()) {
                Marker user = getItem(resultSet);
                listMarker.add(user);
            }
            return listMarker;
        } catch (SQLException ex) {
            Logger.getLogger(SQLServer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }
        }
    }

    public List<Marker> getAll() {
        String cmds = "select * from " + TABLE;
        return getItems(cmds);
    }

    private List<Marker> getByTimeReport(int min) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

        String cmd = String.format("select * from %s where DATEADD(MINUTE, %d , %s) > cast( '%s' as datetime)", TABLE, min, KEY_DB[5], dateFormat.format(date));
        return getItems(cmd);
    }

    public List<Marker> getAll(MyLatLong yourLocation, SettingUser settingUser) {
        double radius = settingUser.getRadius();
        List<Marker> all = getAll(settingUser);
        List<Marker> listFilter = new ArrayList<>();
        for (Marker m : all) {
            if (m.distanceFrom(yourLocation) <= radius) {
                listFilter.add(m);
            }
        }
        return listFilter;
    }
    
        public List<Marker> getAll(SettingUser settingUser) {
        int timeReport = settingUser.getTimeReport();
        return getByTimeReport(timeReport);
    }

    public Marker getByID(int id) {
        String cmds = "select * from " + TABLE + " where " + KEY_DB[0] + " = " + id;
        return getItem(cmds);
    }

    public Marker getByReporter(int id) {
        String cmds = "select * from " + TABLE + " where " + KEY_DB[3] + " = " + id;
        return getItem(cmds);
    }

    public boolean addItem(Marker marker) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "insert into " + TABLE + " (";

            for (int i = 1; i < KEY_DB.length; i++) {
                cmds += KEY_DB[i] + ",";
            }
            cmds = cmds.substring(0, cmds.length() - 1);
            cmds += ") values (";
            cmds += "'" + marker.getLatLong().getLatitude() + "'," + "'" + marker.getLatLong().getLongitude() + "'," + marker.getLevel().getLevel() + "," + marker.getReporter() + "," + "'" + marker.getTimeReport() + "'," + "'" + marker.getComment() + "')";
            System.out.println(cmds);
            statement.executeUpdate(cmds);
            return true;
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(TAG + ex.getMessage());
            }
        }
        return false;
    }
}
