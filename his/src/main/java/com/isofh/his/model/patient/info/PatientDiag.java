package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_diag")
public class PatientDiag extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_diag_generator")
    @SequenceGenerator(
            name = "patient_diag_generator",
            sequenceName = "patient_diag_sq",
            initialValue = 1000000
    )
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientDiag")
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