/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanminh;

import com.vanminh.model.MRVServiceMedicaltest;
import java.util.List;

/**
 *
 * @author vanminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a = 0;
        List<MRVServiceMedicaltest> hisRvLisMedicaltestLp = MRVServiceMedicaltest.getServiceTestByPatientID(2080058);

        int i =0 ;
    }

}
