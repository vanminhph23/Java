package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_guardian")
public class PatientGuardian extends BasePatientModel {
    @Id
    @GeneratedValue(generator = "patient_guardian_generator")
    @SequenceGenerator(
            name = "patient_guardian_generator",
            sequenceName = "patient_guardian_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "name")
    @Audited
    private String name;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
