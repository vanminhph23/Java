/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.entities.*;
import com.isofh.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class Model {
    
    public static HisServiceMedicaltest getServiceTestByID(int hisServiceMedicaltestId) {
        HisServiceMedicaltest medicaltest = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            medicaltest = (HisServiceMedicaltest) session.createQuery("from HisServiceMedicaltest m where m.hisServiceMedicaltestId = " + hisServiceMedicaltestId).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medicaltest;
    }
    
    public static HisServiceMedicaltest getServiceTestByValue(String value, int hisServiceMedictestgroupId) {
        HisServiceMedicaltest medicaltest = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            medicaltest = (HisServiceMedicaltest) session.createQuery("from HisServiceMedicaltest m where m.hisServiceMedictestgroupId = " + hisServiceMedictestgroupId
            + " and m.value = " + value).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medicaltest;
    }
    
    public static List<HisServiceMedicaltest> getServiceTestByPatientID(int hisPatienthistoryId) {
        List<HisServiceMedicaltest> medicaltests = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            medicaltests =  session.createQuery("from HisServiceMedicaltest m where m.hisPatienthistoryId = " + hisPatienthistoryId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medicaltests;
    }
   
    
    public static HisServiceMedictestline getServiceTestLineByID(int hisServiceMedictestlineId) {
        HisServiceMedictestline medicaltest = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            medicaltest = (HisServiceMedictestline) session.createQuery("from HisServiceMedictestline m where m.hisServiceMedictestlineId = " + hisServiceMedictestlineId).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medicaltest;
    }
    
}
