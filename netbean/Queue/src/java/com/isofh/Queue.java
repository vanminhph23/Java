/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh;

import com.isofh.hibernate.model.MPatientHistory;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.log4j.Logger;

/**
 *
 * @author vanminh
 */
@WebService(serviceName = "Queue")
public class Queue {
        private final Logger log = Logger.getLogger(Queue.class.getName());
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getPatient")
    public String getPatient(@WebParam(name = "ID") String ID) {
            MPatientHistory patientHistory = MPatientHistory.getByID(ID, log);
                if(patientHistory == null){
                    log.error("Fail: Not found patient - " + ID);
                    return null;
                }
                log.debug("Success: " + patientHistory.getName()+"#"+patientHistory.getPatientID());
                return patientHistory.getName()+"#"+patientHistory.getPatientID();
    }
}
