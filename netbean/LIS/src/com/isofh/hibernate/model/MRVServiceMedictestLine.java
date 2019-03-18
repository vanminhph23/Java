/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.RVServiceMedictestLine;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MRVServiceMedictestLine extends RVServiceMedictestLine {

    public MRVServiceMedictestLine() {
    }

    public static MRVServiceMedictestLine getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MRVServiceMedictestLine) session.createQuery("From MServiceMedicaltestLine m where m.serviceMedicaltestLineID = " + ID).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public static List<MRVServiceMedictestLine> getByMedicaltestID(int ID) {
            Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("From MRVServiceMedictestLine m where m.serviceMedicaltestID = " + ID).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
