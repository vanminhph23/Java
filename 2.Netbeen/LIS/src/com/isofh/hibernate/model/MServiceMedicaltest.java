/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.HisServiceMedicaltest;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vanminh
 */
public class MServiceMedicaltest extends HisServiceMedicaltest {

    public final static int AD_USER_ID_HIS_LIS = 0;

    public enum Status {
        STATUS_AC("AC"),
        STATUS_WT("WT"),
        STATUS_HR("HR"),
        STATUS_Approved("Approved"),
        STATUS_Canceled("Canceled"),
        STATUS_Canceling("Canceling"),
        STATUS_Finish("Finish"),
        STATUS_GR("GR"),
        STATUS_IsTransferred("IsTransferred"),
        STATUS_HasServiceResult("HasServiceResult"),
        STATUS_IsServicing("IsServicing"),
        STATUS_Normal("Normal"),
        STATUS_PR("PR");
        
        private String status = "";
        
        Status(String value){
            this.status = value;
        }
        String Status(){
            return this.status;
        }
    }
   

    public MServiceMedicaltest() {
        super();
    }

    public static MServiceMedicaltest getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MServiceMedicaltest) session.createQuery("from MServiceMedicaltest m where m.serviceMedicaltestID = " + "1328170").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static List<MServiceMedicaltest> getByMedicaltestGroupID(int groupID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from MServiceMedicaltest m where m.serviceMedictestgroupID = " + groupID).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static boolean updateStatus(int groupID, Status status ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        List<MServiceMedicaltest> list = getByMedicaltestGroupID(groupID);
        for (MServiceMedicaltest serviceMedicaltest : list) {
            serviceMedicaltest.setStatus(status.Status());
            serviceMedicaltest.setUpdated(new Date());
            serviceMedicaltest.setUpdatedby(AD_USER_ID_HIS_LIS);
            session.save(serviceMedicaltest);
        }
        transaction.commit();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
        
        return true;
    }

}
