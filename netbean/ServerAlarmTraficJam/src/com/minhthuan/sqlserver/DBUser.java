/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.sqlserver;

import com.minhthuan.lib.user.SettingUser;
import com.minhthuan.lib.user.User;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sev_user
 */
public class DBUser {

    private final String[] KEY_DB = new String[]{"ID", "UserName", "Pass", "FullName", "Email", "Avatar", "Birthday", "SettingID", "LastTimeLogin"};
    private final String TABLE = "Table_User";
    private SQLServer sQLServer;
    private String TAG = "DBUser: ";

    public DBUser(SQLServer sQLServer) {
        this.sQLServer = sQLServer;
    }

    public User getItem(ResultSet rs) throws SQLException {
        User user = new User(rs.getInt(KEY_DB[0]), rs.getString(KEY_DB[1]), rs.getString(KEY_DB[2]), rs.getString(KEY_DB[3]), rs.getString(KEY_DB[4]), null, rs.getString(KEY_DB[6]), null, rs.getString(KEY_DB[8]));
        int settingID = rs.getInt(KEY_DB[7]);
        DBSettingUser dBSettingUser = new DBSettingUser(sQLServer);
        SettingUser settingUser = dBSettingUser.getByID(settingID);
        user.setSettingUser(settingUser);
        String avatarPath = rs.getString(KEY_DB[4]);
        if (avatarPath != null && !avatarPath.equals("")) {
            File file = new File(avatarPath);
            user.setAvatar(file);
        }
        updateTimeLogin(user);
        return user;
    }

    public List<User> getAll() {
        Connection connection = null;
        Statement statement = null;
        try {
            List<User> listUser = new ArrayList<User>();
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + TABLE);
            while (resultSet.next()) {
                User user = getItem(resultSet);
                listUser.add(user);
            }
            return listUser;
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
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

    public User getByID(int id) {

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
            User user = getItem(resultSet);
            return user;
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
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

    public User checkUser(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "select * from " + TABLE + " where " + KEY_DB[1] + " = '" + user.getUserName() + "' and " + KEY_DB[2] + " = '" + user.getPass() + "'";
            ResultSet resultSet = statement.executeQuery(cmds);
            if (!resultSet.next()) {
                return null;
            }
            return getItem(resultSet);
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
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

    public User getByUsername(String username) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "select * from " + TABLE + " where " + KEY_DB[1] + " = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(cmds);
            if (!resultSet.next()) {
                return null;
            }
            User user = getItem(resultSet);
            return user;
        } catch (SQLException ex) {
            System.out.println(TAG + ex.getMessage());
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

    public User addItem(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            DBSettingUser dBSettingUser = new DBSettingUser(sQLServer);
            SettingUser settingUser = new SettingUser(1000, 60);
            settingUser = dBSettingUser.addItem(settingUser);

            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "insert into " + TABLE + " (";

            for (int i = 1; i < KEY_DB.length; i++) {
                cmds += KEY_DB[i] + ",";
            }
            cmds = cmds.substring(0, cmds.length() - 1);
            cmds += ") values (";
            cmds += "'" + user.getUserName() + "'," + "'" + user.getPass() + "'," + "N'" + user.getFullName() + "'," + "'" + user.getEmail() + "'," + "'" + user.getAvatar() + "'," + "'" + user.getBirthday() + "'," + "'" + settingUser.getID() + "'," + "'" + user.getLastTimeLogin() + "'" + ")";
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

    private void updateTimeLogin(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
            dateFormat.format(date);
            connection = sQLServer.getConnection();
            statement = connection.createStatement();
            String cmds = "update " + TABLE + " set " + KEY_DB[KEY_DB.length - 1] + "='" + dateFormat.format(date) + "' where " + KEY_DB[0] + "=" + id;
            System.out.println(cmds);
            statement.executeUpdate(cmds);
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
    }

    private void updateTimeLogin(User user) {
        updateTimeLogin(user.getId());
    }

}
