package com.isofh.his.model.patient.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_bed_service")
public class PatientBedService extends BaseModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private PatientInvoiceLine patientInvoiceLine;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
