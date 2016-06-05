/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate.model;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.HisServiceMedictestLine;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class MServiceMedicaltestLine extends HisServiceMedictestLine {

    public MServiceMedicaltestLine() {
    }

    public static MServiceMedicaltestLine getByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (MServiceMedicaltestLine) session.createQuery("From MServiceMedicaltestLine m where m.serviceMedicaltestLineID = " + "0").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
