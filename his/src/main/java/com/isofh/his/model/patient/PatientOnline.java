package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientHistoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_online")
public class PatientOnline extends BasePatientHistoryModel {

    @Id
    @GeneratedValue(generator = "patient_online_generator")
    @SequenceGenerator(
            name = "patient_online_generator",
            sequenceName = "patient_online_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "account")
    @Audited
    private String account;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}