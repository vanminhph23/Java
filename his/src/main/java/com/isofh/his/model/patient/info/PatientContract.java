package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_contract")
public class PatientContract extends BasePatientModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private PatientHistory patientHistory;

    @Column(name = "employee_value")
    @Audited
    private String employeeValue;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}