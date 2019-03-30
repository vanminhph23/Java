package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;

import javax.persistence.*;

@Entity
@Table(name = "his_patient")
public class Patient extends BasePatientModel {
    @Id
    @GeneratedValue(generator = "patient_generator")
    @SequenceGenerator(
            name = "patient_generator",
            sequenceName = "patient_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
