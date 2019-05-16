package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_in_hospital_diag")
public class PatientInHospitalDiag extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_in_hospital_diag_generator")
    @SequenceGenerator(
            name = "patient_in_hospital_diag_generator",
            sequenceName = "patient_in_hospital_diag_sq",
            initialValue = 1000000
    )
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientInHospitalDiag")
    private PatientHistory patientHistory;

    @Column(name = "in_hospital_disease_diagnostic")
    @Audited
    private String inHospitalDiseaseDiagnostic;

    @Column(name = "prev_diagnostic")
    @Audited
    private String prevDiagnostic;

    @Column(name = "examination_reason")
    @Audited
    private String examinationReason;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}