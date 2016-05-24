/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.utils;

import com.his.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author DinhThap
 */
public class DatabaseUtils {

    private static Logger log = Logger.getLogger(DatabaseUtils.class.getName());
    private static DatabaseUtils instance = null;
    private Connection conn = null;

    private DatabaseUtils() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            log.info("Error during load class");
            ex.printStackTrace();
        }
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public Connection openConnectionNotAutoCommit() throws SQLException {
        conn = DriverManager.getConnection(Config.URL);
        conn.setAutoCommit(false);
        log.info("Connect successfully");
        return conn;
    }

    public Connection openConnection() throws SQLException {
        conn = DriverManager.getConnection(Config.URL);
        log.info("Connect successfully");
        return conn;
    }

    public void rollBackAndClose(Connection conn) throws SQLException {
        if (conn != null) {
            conn.rollback();
            conn.close();
        }
    }

    public void commitAndClose(Connection conn) throws SQLException {
        if (conn != null) {
            conn.commit();
            conn.close();
        }
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        log.info("Close successfully");
    }

    public static void closeAll(PreparedStatement ps, ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            ps.close();
        } catch (Exception e) {
        }
    }
}
