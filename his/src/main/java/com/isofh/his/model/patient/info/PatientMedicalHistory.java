package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import com.isofh.his.model.patient.service.PatientServiceCheckUp;
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "medicalHistory")
    private PatientHistory patientHistory;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "medicalHistory")
    private PatientServiceCheckUp patientServiceCheckUp;

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

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public PatientServiceCheckUp getPatientServiceCheckUp() {
        return patientServiceCheckUp;
    }

    public void setPatientServiceCheckUp(PatientServiceCheckUp patientServiceCheckUp) {
        this.patientServiceCheckUp = patientServiceCheckUp;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getFamilyDisease() {
        return familyDisease;
    }

    public void setFamilyDisease(String familyDisease) {
        this.familyDisease = familyDisease;
    }

    public String getDiseaseProgression() {
        return diseaseProgression;
    }

    public void setDiseaseProgression(String diseaseProgression) {
        this.diseaseProgression = diseaseProgression;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }
}