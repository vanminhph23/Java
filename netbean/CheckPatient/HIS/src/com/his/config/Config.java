/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his.config;

/**
 *
 * @author DinhThap
 * 
 */

public class Config {
    /**
     * Thôn tin các tham số cho kết nối database
     */
    public static final String DATABASE = "HIS";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";
    public static final int PORT = 51266;
    public static final String HOST = "localhost";
    public static final String URL = "jdbc:sqlserver://"+HOST+":"+PORT+";user="+USERNAME+";password="+PASSWORD+";database="+DATABASE;
    
    
}
