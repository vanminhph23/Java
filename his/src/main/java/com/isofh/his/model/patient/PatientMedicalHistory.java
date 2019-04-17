package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_medical_history")
public class PatientMedicalHistory extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_medical_history_generator")
    @SequenceGenerator(
            name = "patient_medical_history_generator",
            sequenceName = "patient_medical_history_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "allergy")
    @Audited
    private String allergy;

    @Column(name = "disease")
    @Audited
    private String disease;

    @Column(name = "family_disease")
    @Audited
    private String familyDisease;

    @Column(name = "disease_progression")
    @Audited
    private String diseaseProgression;

    @Column(name = "surgery")
    @Audited
    private String surgery;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}