package com.isofh.his.model.base.patient;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePatient2Model extends BasePatientModel {

    @Column(name = "medical_record_no", nullable = false, length = 7)
    @Audited
    private String medicalRecordNo;

    @Column(name = "patient_document", nullable = false, length = 10)
    @Audited
    private String patientDocument;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient = false;
}