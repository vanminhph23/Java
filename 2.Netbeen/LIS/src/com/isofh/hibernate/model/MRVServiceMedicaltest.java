/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MRVServiceMedicaltest extends RVServiceMedicaltest implements IModel<MRVServiceMedicaltest> {

    public MRVServiceMedicaltest() {
        super();
    }

    public MRVServiceMedicaltest getByID(int ID) {
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

    public List<MRVServiceMedicaltest> getByPatientID(int patientHistoryID) {
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
