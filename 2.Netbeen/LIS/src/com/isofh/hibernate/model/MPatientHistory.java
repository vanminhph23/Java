/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.HisPatientHistory;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MPatientHistory extends HisPatientHistory {

    public MPatientHistory() {
        super();
    }

    public static MPatientHistory getByID(int ID) {
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

    public static MPatientHistory getByMedicaltestGroupID(int groupID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Integer patientHistoryID = (Integer) session.createQuery("select m.patientHistoryID From MRVServiceMedicaltest m where m.serviceMedictestgroupID = " + groupID).uniqueResult();
            if (patientHistoryID.compareTo(0) <= 0) {
                return null;
            }
            return (MPatientHistory) session.createQuery("from MPatientHistory m where m.patientHistoryID = " + patientHistoryID).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
