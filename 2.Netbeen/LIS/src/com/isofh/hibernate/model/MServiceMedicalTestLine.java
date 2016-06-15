/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.SeviceMedicaltestLine;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MServiceMedicaltestLine extends SeviceMedicaltestLine {

    public MServiceMedicaltestLine() {
    }
    
    public static MServiceMedicaltestLine getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MServiceMedicaltestLine) session.createQuery("from MServiceMedicaltestLine m where m.serviceMedicaltestLineID = " + ID).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public static MServiceMedicaltestLine getByHISLISCode(String hisLisCode, int serviceMedictestGroupID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Integer ID = (Integer) session.createQuery("select m.serviceMedicaltestLineID from MRVServiceMedictestLine m where m.hisLISCode = ? and m.serviceMedictestGroupID = ?")
                    .setParameter(0, hisLisCode)
                    .setParameter(1, serviceMedictestGroupID)
                    .uniqueResult();
            return MServiceMedicaltestLine.getByID(ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
