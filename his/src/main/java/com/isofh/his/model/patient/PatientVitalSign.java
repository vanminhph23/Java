package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientHistoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_vital_sign")
public class PatientVitalSign extends BasePatientHistoryModel {

    @Id
    @GeneratedValue(generator = "patient_vital_sign_generator")
    @SequenceGenerator(
            name = "patient_vital_sign_generator",
            sequenceName = "patient_vital_sign_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}