package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientHistoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_diagnostic")
public class PatientDiagnostic extends BasePatientHistoryModel {

    @Id
    @GeneratedValue(generator = "patient_diagnostic_generator")
    @SequenceGenerator(
            name = "patient_diagnostic_generator",
            sequenceName = "patient_diagnostic_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "first_diagnostic")
    @Audited
    private String firstDiagnostic;

    @Column(name = "diagnostic")
    @Audited
    private String diagnostic;

    // ICD, separate ID by ','
    @Column(name = "disease_diagnostic")
    @Audited
    private String diseaseDiagnostic;

    @Column(name = "other_disease_diagnostic")
    @Audited
    private String otherDiseaseDiagnostic;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}