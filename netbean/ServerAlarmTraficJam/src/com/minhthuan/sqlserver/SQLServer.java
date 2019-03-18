/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sev_user
 */
public class SQLServer {

    private String host, database, username, pass;
    
    private final String TABLE_MARKER = "Table_Marker";

    public SQLServer(String host, String database, String username, String pass) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.pass = pass;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + host + ":1433;databaseName="
                    + database;

            return DriverManager.getConnection(connectionURL, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
