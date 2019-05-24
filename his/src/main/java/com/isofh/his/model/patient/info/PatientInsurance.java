package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import com.isofh.his.model.category.Hospital;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient_insurance")
@Where(clause = "deleted=0")
public class PatientInsurance extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_insurance_generator")
    @SequenceGenerator(
            name = "patient_insurance_generator",
            sequenceName = "patient_insurance_sq",
            initialValue = 1000000
    )
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientInsurance")
    private PatientHistory patientHistory;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientInsurance", cascade = {CascadeType.ALL})
    private PatientType patientType;

    @Column(name = "address")
    @Audited
    private String address;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date toDate;

    @Column(name = "insurance_number", length = 15, nullable = false)
    @Audited
    private String insuranceNumber;

    @Column(name = "percent", nullable = false)
    @Audited
    private Integer percent;

    @Column(name = "reg_at_hospital_id", nullable = false)
    @Audited
    private Long regAtHospitalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_at_hospital_id", insertable = false, updatable = false)
    private Hospital regAtHospital;

    @Column(name = "patient_from_hospital_id")
    @Audited
    private Long patientFromHospitalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_from_hospital_id", insertable = false, updatable = false)
    private Hospital patientFromHospital;

    @Column(name = "emergency", nullable = false)
    @Audited
    private boolean emergency;

    @Column(name = "appointment", nullable = false)
    @Audited
    private boolean appointment;

    @Column(name = "extra", nullable = false)
    @Audited
    private boolean extra;

    @Column(name = "referral", nullable = false)
    @Audited
    private boolean referral;

    @Column(name = "time_continuity_5year")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date timeContinuity5Year;

    @Column(name = "continuity_5year")
    @Audited
    private boolean continuity5Year;

    @Column(name = "hundred_percent_high_tech", nullable = false)
    @Audited
    private boolean hundredPercentHightech;

    @Column(name = "not_copayment", nullable = false)
    @Audited
    private boolean notCopayment;

    @Column(name = "not_copayment_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date notCopaymentDate;

    @Column(name = "region_value")
    @Audited
    private Integer regionValue;

    @Column(name = "keeping", nullable = false)
    @Audited
    private boolean keeping = true;

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

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Long getRegAtHospitalId() {
        return regAtHospitalId;
    }

    public void setRegAtHospitalId(Long regAtHospitalId) {
        this.regAtHospitalId = regAtHospitalId;
    }

    public Hospital getRegAtHospital() {
        return regAtHospital;
    }

    public void setRegAtHospital(Hospital regAtHospital) {
        this.regAtHospital = regAtHospital;
    }

    public Long getPatientFromHospitalId() {
        return patientFromHospitalId;
    }

    public void setPatientFromHospitalId(Long patientFromHospitalId) {
        this.patientFromHospitalId = patientFromHospitalId;
    }

    public Hospital getPatientFromHospital() {
        return patientFromHospital;
    }

    public void setPatientFromHospital(Hospital patientFromHospital) {
        this.patientFromHospital = patientFromHospital;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public boolean isReferral() {
        return referral;
    }

    public void setReferral(boolean referral) {
        this.referral = referral;
    }

    public Date getTimeContinuity5Year() {
        return timeContinuity5Year;
    }

    public void setTimeContinuity5Year(Date timeContinuity5Year) {
        this.timeContinuity5Year = timeContinuity5Year;
    }

    public boolean isContinuity5Year() {
        return continuity5Year;
    }

    public void setContinuity5Year(boolean continuity5Year) {
        this.continuity5Year = continuity5Year;
    }

    public boolean isHundredPercentHightech() {
        return hundredPercentHightech;
    }

    public void setHundredPercentHightech(boolean hundredPercentHightech) {
        this.hundredPercentHightech = hundredPercentHightech;
    }

    public boolean isNotCopayment() {
        return notCopayment;
    }

    public void setNotCopayment(boolean notCopayment) {
        this.notCopayment = notCopayment;
    }

    public Date getNotCopaymentDate() {
        return notCopaymentDate;
    }

    public void setNotCopaymentDate(Date notCopaymentDate) {
        this.notCopaymentDate = notCopaymentDate;
    }

    public Integer getRegionValue() {
        return regionValue;
    }

    public void setRegionValue(Integer regionValue) {
        this.regionValue = regionValue;
    }

    public boolean isKeeping() {
        return keeping;
    }

    public void setKeeping(boolean keeping) {
        this.keeping = keeping;
    }
}
