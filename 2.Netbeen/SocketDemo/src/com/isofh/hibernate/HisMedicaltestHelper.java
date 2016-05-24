/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.hibernate;

import com.isofh.hibernate.HibernateUtil;
import com.isofh.hibernate.entities.HisMedicaltest;
import org.hibernate.Session;

/**
 *
 * @author vanminh
 */
public class HisMedicaltestHelper {
    public static HisMedicaltest getByID(int hisMedicaltestId){
        HisMedicaltest medicaltest = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            medicaltest = (HisMedicaltest) session.createQuery("from HisMedicaltest as m where m.hisMedicaltestId = " + hisMedicaltestId).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medicaltest;
}
    
}
