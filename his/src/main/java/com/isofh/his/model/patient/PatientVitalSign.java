package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_vital_sign")
public class PatientVitalSign extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_vital_sign_generator")
    @SequenceGenerator(
            name = "patient_vital_sign_generator",
            sequenceName = "patient_vital_sign_sq",
            initialValue = 1000000
    )
    private Long id;

    @OneToOne(mappedBy = "patientVitalSign")
    private PatientHistory patientHistory;

    @Column(name = "blood_pressure")
    @Audited
    private Integer bloodPressure;

    @Column(name = "temperature")
    @Audited
    private Integer temperature;

    @Column(name = "spo2")
    @Audited
    private Integer spo2;

    @Column(name = "pulse")
    @Audited
    private Integer pulse;

    @Column(name = "breath")
    @Audited
    private Integer breath;

    @Column(name = "height")
    @Audited
    private Integer height;

    @Column(name = "weight")
    @Audited
    private Integer weight;

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

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getSpo2() {
        return spo2;
    }

    public void setSpo2(Integer spo2) {
        this.spo2 = spo2;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getBreath() {
        return breath;
    }

    public void setBreath(Integer breath) {
        this.breath = breath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}