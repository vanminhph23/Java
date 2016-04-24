/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.sqlserver;

import com.minhthuan.lib.user.SettingUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vanmi
 */
public class DBSettingUser {

    private final String[] KEY_DB = new String[]{"ID", "Radius", "TimeReport"};
    private final String TABLE = "Table_AccountSetting";
    private SQLServer sQLServer;
    private final String TAG = "DBSettingUser: ";

    public DBSettingUser(SQLServer sQLServer) {
        this.sQLServer = sQLServer;
    }

    public SettingUser getItem(ResultSet rs) throws SQLException {
        return new SettingUser(rs.getInt(KEY_DB[0]), Double.valueOf(rs.getString(KEY_DB[1])), rs.getInt(KEY_DB[2]));
    }

    public SettingUser getByID(int id) {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "select * from " + TABLE + " where " + KEY_DB[0] + " = " + id;
            ResultSet resultSet = statement.executeQuery(cmds);
            if (!resultSet.next()) {
                return null;
            }
            SettingUser settingUser = getItem(resultSet);
            return settingUser;
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
        return null;
    }

    public SettingUser addItem(SettingUser user) {
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
            cmds += "'" + user.getRadius() + "'," + user.getTimeReport() + ")";
            System.out.println(cmds);
            statement.executeUpdate(cmds);
            return getByID(getCurrentID());
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
        return null;
    }
    
    public SettingUser updateItem(SettingUser user) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = String.format("update %s set %s = %s, %s = %s where %s = %d", TABLE, KEY_DB[1],user.getRadius(),KEY_DB[2],user.getTimeReport(),KEY_DB[0],user.getID());
            System.out.println(cmds);
            statement.executeUpdate(cmds);
            return getByID(user.getID());
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
        return null;
    }

    private int getCurrentID() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "SELECT IDENT_CURRENT('" + TABLE + "')";
            System.out.println(cmds);
            ResultSet resultSet = statement.executeQuery(cmds);
            if (!resultSet.next()) {
                return -1;
            }
            int id = resultSet.getInt(1);
            System.out.println("Current ID " + TABLE + " :" + id);
            return id;
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
        return -1;
    }
}
