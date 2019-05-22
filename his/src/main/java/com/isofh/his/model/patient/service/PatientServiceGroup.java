package com.isofh.his.model.patient.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_service_group")
public class PatientServiceGroup extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_service_group_generator")
    @SequenceGenerator(
            name = "patient_service_group_generator",
            sequenceName = "patient_service_group_sq",
            initialValue = 1000000
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_history_id")
    private PatientHistory patientHistory;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
