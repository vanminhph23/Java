/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanminh.logger;

import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
public class CLogger {

    Logger log = null;
    String prefix = null;

    public CLogger(String name) {
        prefix = name;
        log = Logger.getLogger(name);
    }

    public void debug(String mes) {
        log.error(prefix + " - " + mes);
    }

    public void error(String mes) {
        log.error(prefix + " - " + mes);
    }
    
    public static CLogger getLogger(String name){
        return new CLogger(name);
    }
    

}
