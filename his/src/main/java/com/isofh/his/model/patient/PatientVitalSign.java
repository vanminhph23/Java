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
    private int bloodPressure;

    @Column(name = "temperature")
    @Audited
    private int temperature;

    @Column(name = "spo2")
    @Audited
    private int spo2;

    @Column(name = "pulse")
    @Audited
    private int pulse;

    @Column(name = "breath")
    @Audited
    private int breath;

    @Column(name = "height")
    @Audited
    private int height;

    @Column(name = "weight")
    @Audited
    private int weight;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}