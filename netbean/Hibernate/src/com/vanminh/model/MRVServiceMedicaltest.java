/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanminh.model;

import com.vanminh.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MRVServiceMedicaltest extends RVServiceMedicaltest {

    public MRVServiceMedicaltest() {
        super();
    }
    
    

    public static MRVServiceMedicaltest getByID() {
        MRVServiceMedicaltest patienthistory = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            patienthistory = (MRVServiceMedicaltest) session.createQuery("from MRVServiceMedicaltest m where m.RVserviceMedicalTestID = " + "10381771785").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patienthistory;
    }

    public static List<MRVServiceMedicaltest> getServiceTestByPatientID(int patientHistoryID) {
        List<MRVServiceMedicaltest> list = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            list = session.createQuery("from MRVServiceMedicaltest m where m.patientHistoryID = " + patientHistoryID).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
