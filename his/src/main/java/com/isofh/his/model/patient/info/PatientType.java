package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "his_patient_type", indexes = {@Index(name = "pt_patient_history_id", columnList = "patient_history_id")})
@Where(clause = "deleted=0")
public class PatientType extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_type_generator")
    @SequenceGenerator(
            name = "patient_type_generator",
            sequenceName = "patient_type_sq",
            initialValue = 1000000
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_history_id", nullable = false)
    private PatientHistory patientHistory;

    @Column(name = "patient_type")
    @Audited
    private int patientType;

    @Column(name = "act_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date actDate;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date toDate;

    // insurance info
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_insurance_id", unique = true, updatable = false)
    private PatientInsurance patientInsurance;

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

    public int getPatientType() {
        return patientType;
    }

    public void setPatientType(int patientType) {
        this.patientType = patientType;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public PatientInsurance getPatientInsurance() {
        return patientInsurance;
    }

    public void setPatientInsurance(PatientInsurance patientInsurance) {
        this.patientInsurance = patientInsurance;
    }
}