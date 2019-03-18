/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isora;

import java.math.BigDecimal;

/**
 *
 * @author Minh
 */
public class Patient {
    
    String department;
    String medicalrecord;
    int amount;
    int seq;
    String name;
    

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMedicalrecord() {
        return medicalrecord;
    }

    public void setMedicalrecord(String medicalrecord) {
        this.medicalrecord = medicalrecord;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Patient(int seq, String name, String department, String medicalrecord, int amount) {
        this.seq= seq;
        this.name = name;
        this.department = department;
        this.medicalrecord = medicalrecord;
        this.amount = amount;
    }

    public Patient() {
    }
    
}
