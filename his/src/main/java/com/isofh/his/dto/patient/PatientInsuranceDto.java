package com.isofh.his.dto.patient;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.sql.Timestamp;

public class PatientInsuranceDto extends BaseCategoryDto {

    public PatientInsuranceDto() {
    }

    private String address;

    private Timestamp fromDate;

    private Timestamp toDate;

    private Timestamp appliedFromDate;

    private Timestamp appliedToDate;

    private String insuranceNumber;

    private Integer percent;

    private Long regAtHospitalId;

    private Long patientFromHospitalId;

    private boolean emergency;

    private boolean appointment;

    private boolean extra;

    private boolean referral;

    private Timestamp timeContinuity5Year;

    private boolean continuity5Year;

    private boolean hundredPercentHightech;

    private boolean notCopayment;

    private Timestamp notCopaymentDate;

    private Integer regionValue;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Timestamp getAppliedFromDate() {
        return appliedFromDate;
    }

    public void setAppliedFromDate(Timestamp appliedFromDate) {
        this.appliedFromDate = appliedFromDate;
    }

    public Timestamp getAppliedToDate() {
        return appliedToDate;
    }

    public void setAppliedToDate(Timestamp appliedToDate) {
        this.appliedToDate = appliedToDate;
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

    public Long getPatientFromHospitalId() {
        return patientFromHospitalId;
    }

    public void setPatientFromHospitalId(Long patientFromHospitalId) {
        this.patientFromHospitalId = patientFromHospitalId;
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

    public Timestamp getTimeContinuity5Year() {
        return timeContinuity5Year;
    }

    public void setTimeContinuity5Year(Timestamp timeContinuity5Year) {
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

    public Timestamp getNotCopaymentDate() {
        return notCopaymentDate;
    }

    public void setNotCopaymentDate(Timestamp notCopaymentDate) {
        this.notCopaymentDate = notCopaymentDate;
    }

    public Integer getRegionValue() {
        return regionValue;
    }

    public void setRegionValue(Integer regionValue) {
        this.regionValue = regionValue;
    }
}