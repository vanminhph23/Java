package com.isofh.his.model.base.patient;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePatientModel extends BaseModel {

    @Column(name = "patient_value", nullable = false)
    @Audited
    private String patientValue;

    @Column(name = "patient_name", nullable = false)
    @Audited
    private String patientName;

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}