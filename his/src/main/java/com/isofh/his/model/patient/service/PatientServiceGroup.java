package com.isofh.his.model.patient.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.patient.info.PatientHistory;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_service_group")
@Where(clause = "deleted=0")
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
