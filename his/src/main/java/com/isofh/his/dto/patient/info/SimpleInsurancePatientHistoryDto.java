package com.isofh.his.dto.patient.info;

import java.util.Date;

public class SimpleInsurancePatientHistoryDto extends SimplePatientHistoryDto {

    public SimpleInsurancePatientHistoryDto() {
    }

    // insurance
    private String insuranceAddress;

    private Date insuranceFromDate;

    private Date insuranceToDate;

    private Date insuranceAppliedFromDate;

    private Date insuranceAppliedToDate;

    private String insuranceNumber;

    private Integer insurancePercent;

    private Long insuranceRegAtHospitalId;

    private Long insurancePatientFromHospitalId;

    private boolean insuranceEmergency;

    private boolean insuranceAppointment;

    private boolean insuranceExtra;

    private boolean insuranceReferral;

    private Date insuranceTimeContinuity5Year;

    private boolean insuranceContinuity5Year;

    private boolean insuranceHundredPercentHightech;

    private boolean insuranceNotCoPayment;

    private Date insuranceNotCopaymentDate;

    private Integer insuranceRegionValue;

    private boolean insuranceKeeping;

    private boolean ignoreValidatePortalInsurance;

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public Date getInsuranceFromDate() {
        return insuranceFromDate;
    }

    public void setInsuranceFromDate(Date insuranceFromDate) {
        this.insuranceFromDate = insuranceFromDate;
    }

    public Date getInsuranceToDate() {
        return insuranceToDate;
    }

    public void setInsuranceToDate(Date insuranceToDate) {
        this.insuranceToDate = insuranceToDate;
    }

    public Date getInsuranceAppliedFromDate() {
        return insuranceAppliedFromDate;
    }

    public void setInsuranceAppliedFromDate(Date insuranceAppliedFromDate) {
        this.insuranceAppliedFromDate = insuranceAppliedFromDate;
    }

    public Date getInsuranceAppliedToDate() {
        return insuranceAppliedToDate;
    }

    public void setInsuranceAppliedToDate(Date insuranceAppliedToDate) {
        this.insuranceAppliedToDate = insuranceAppliedToDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Integer getInsurancePercent() {
        return insurancePercent;
    }

    public void setInsurancePercent(Integer insurancePercent) {
        this.insurancePercent = insurancePercent;
    }

    public Long getInsuranceRegAtHospitalId() {
        return insuranceRegAtHospitalId;
    }

    public void setInsuranceRegAtHospitalId(Long insuranceRegAtHospitalId) {
        this.insuranceRegAtHospitalId = insuranceRegAtHospitalId;
    }

    public Long getInsurancePatientFromHospitalId() {
        return insurancePatientFromHospitalId;
    }

    public void setInsurancePatientFromHospitalId(Long insurancePatientFromHospitalId) {
        this.insurancePatientFromHospitalId = insurancePatientFromHospitalId;
    }

    public boolean isInsuranceEmergency() {
        return insuranceEmergency;
    }

    public void setInsuranceEmergency(boolean insuranceEmergency) {
        this.insuranceEmergency = insuranceEmergency;
    }

    public boolean isInsuranceAppointment() {
        return insuranceAppointment;
    }

    public void setInsuranceAppointment(boolean insuranceAppointment) {
        this.insuranceAppointment = insuranceAppointment;
    }

    public boolean isInsuranceExtra() {
        return insuranceExtra;
    }

    public void setInsuranceExtra(boolean insuranceExtra) {
        this.insuranceExtra = insuranceExtra;
    }

    public boolean isInsuranceReferral() {
        return insuranceReferral;
    }

    public void setInsuranceReferral(boolean insuranceReferral) {
        this.insuranceReferral = insuranceReferral;
    }

    public Date getInsuranceTimeContinuity5Year() {
        return insuranceTimeContinuity5Year;
    }

    public void setInsuranceTimeContinuity5Year(Date insuranceTimeContinuity5Year) {
        this.insuranceTimeContinuity5Year = insuranceTimeContinuity5Year;
    }

    public boolean isInsuranceContinuity5Year() {
        return insuranceContinuity5Year;
    }

    public void setInsuranceContinuity5Year(boolean insuranceContinuity5Year) {
        this.insuranceContinuity5Year = insuranceContinuity5Year;
    }

    public boolean isInsuranceHundredPercentHightech() {
        return insuranceHundredPercentHightech;
    }

    public void setInsuranceHundredPercentHightech(boolean insuranceHundredPercentHightech) {
        this.insuranceHundredPercentHightech = insuranceHundredPercentHightech;
    }

    public boolean isInsuranceNotCoPayment() {
        return insuranceNotCoPayment;
    }

    public void setInsuranceNotCoPayment(boolean insuranceNotCoPayment) {
        this.insuranceNotCoPayment = insuranceNotCoPayment;
    }

    public Date getInsuranceNotCopaymentDate() {
        return insuranceNotCopaymentDate;
    }

    public void setInsuranceNotCopaymentDate(Date insuranceNotCopaymentDate) {
        this.insuranceNotCopaymentDate = insuranceNotCopaymentDate;
    }

    public Integer getInsuranceRegionValue() {
        return insuranceRegionValue;
    }

    public void setInsuranceRegionValue(Integer insuranceRegionValue) {
        this.insuranceRegionValue = insuranceRegionValue;
    }

    public boolean isInsuranceKeeping() {
        return insuranceKeeping;
    }

    public void setInsuranceKeeping(boolean insuranceKeeping) {
        this.insuranceKeeping = insuranceKeeping;
    }

    public boolean isIgnoreValidatePortalInsurance() {
        return ignoreValidatePortalInsurance;
    }

    public void setIgnoreValidatePortalInsurance(boolean ignoreValidatePortalInsurance) {
        this.ignoreValidatePortalInsurance = ignoreValidatePortalInsurance;
    }
}
