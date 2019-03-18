/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.PatientHistory;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MPatientHistory extends PatientHistory {
    public MPatientHistory() {
        super();
    }

    public static MPatientHistory getByID(String ID, Logger log) {
        log.debug("Request: Get patient - " + ID);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MPatientHistory) session.createQuery("from MPatientHistory m where m.patientHistoryID = " + ID).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
