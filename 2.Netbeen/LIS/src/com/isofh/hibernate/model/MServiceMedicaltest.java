/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.ServiceMedicaltest;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vanminh
 */
public class MServiceMedicaltest extends ServiceMedicaltest {

    public final static int AD_USER_ID_HIS_LIS = 1002251;

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

        Status(String value) {
            this.status = value;
        }

        public String Status() {
            return this.status;
        }
    }

    public MServiceMedicaltest() {
        super();
    }

    public static MServiceMedicaltest getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MServiceMedicaltest) session.createQuery("from MServiceMedicaltest m where m.serviceMedicaltestID = " + ID).uniqueResult();
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
            return session.createQuery("from MServiceMedicaltest m where m.serviceMedictestGroupID = " + groupID).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static MServiceMedicaltest getByHISLISCode(String hisLisCode, int serviceMedictestGroupID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Object ID = session.createQuery("select m.serviceMedicalTestID from MRVServiceMedicaltest m where m.hisLisCode = ? and m.serviceMedictestGroupID = ?")
                    .setParameter(0, hisLisCode)
                    .setParameter(1, serviceMedictestGroupID)
                    .uniqueResult();
            if (ID == null) {
                return null;
            }
            return MServiceMedicaltest.getByID((Integer) ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static boolean updateStatus(int groupID, Status status) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            List<MServiceMedicaltest> list = getByMedicaltestGroupID(groupID);

            for (MServiceMedicaltest serviceMedicaltest : list) {
                serviceMedicaltest.setStatus(status.Status());
                serviceMedicaltest.setStatusLIS(status.Status());
                serviceMedicaltest.setUpdated(new Timestamp(System.currentTimeMillis()));
                serviceMedicaltest.setUpdatedby(AD_USER_ID_HIS_LIS);
                serviceMedicaltest.setTimeTakePatient(new Timestamp(System.currentTimeMillis()));
                session.update(serviceMedicaltest);
            }
            transaction.commit();
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
