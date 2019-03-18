/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh;

import con.isofh.connection.Server;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log.error("Start HIS- LIS");
        Server server = new Server(HardCode.PORT);
    }
    
}
