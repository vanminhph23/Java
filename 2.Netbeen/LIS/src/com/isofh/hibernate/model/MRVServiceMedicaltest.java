/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.*;
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

    public static MRVServiceMedicaltest getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MRVServiceMedicaltest) session.createQuery("from MRVServiceMedicaltest m where m.serviceMedicalTestID = " + "10381771785").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static List<MRVServiceMedicaltest> getByPatientID(int patientHistoryID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from MRVServiceMedicaltest m where m.patientHistoryID = " + patientHistoryID).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static List<MRVServiceMedicaltest> getByGroupMedicaltestID(int groupID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from MRVServiceMedicaltest m where m.serviceMedictestgroupID = " + groupID).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static List<Integer> getGroupMedicaltestID() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("select distinct m.serviceMedictestgroupID from MRVServiceMedicaltest m").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
