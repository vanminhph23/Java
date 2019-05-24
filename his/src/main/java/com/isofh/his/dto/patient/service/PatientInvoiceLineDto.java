package com.isofh.his.dto.patient.service;

import com.isofh.his.dto.base.BaseDto;

import java.util.Date;

public class PatientInvoiceLineDto extends BaseDto {

    private Long patientHistoryId;

    private Long serviceId;

    private Long createdFromRecordId;

    private Integer createdFromServiceType;

    private Long roomId;

    private Long servicePurposeId;

    private String diagnostic;

    private String specimens;

    private Long fromDoctorId;

    private Long fromDepartmentId;

    private boolean option;

    private boolean patientRequest;

    private boolean notCounted;

    private boolean serviceUsed;

    private boolean deferredPayment;

    private Double quantity;

    private Date docDate;

    private Date actDate;

    public Long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getCreatedFromRecordId() {
        return createdFromRecordId;
    }

    public void setCreatedFromRecordId(Long createdFromRecordId) {
        this.createdFromRecordId = createdFromRecordId;
    }

    public Integer getCreatedFromServiceType() {
        return createdFromServiceType;
    }

    public void setCreatedFromServiceType(Integer createdFromServiceType) {
        this.createdFromServiceType = createdFromServiceType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getServicePurposeId() {
        return servicePurposeId;
    }

    public void setServicePurposeId(Long servicePurposeId) {
        this.servicePurposeId = servicePurposeId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getSpecimens() {
        return specimens;
    }

    public void setSpecimens(String specimens) {
        this.specimens = specimens;
    }

    public Long getFromDoctorId() {
        return fromDoctorId;
    }

    public void setFromDoctorId(Long fromDoctorId) {
        this.fromDoctorId = fromDoctorId;
    }

    public Long getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Long fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    public boolean isOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    public boolean isPatientRequest() {
        return patientRequest;
    }

    public void setPatientRequest(boolean patientRequest) {
        this.patientRequest = patientRequest;
    }

    public boolean isNotCounted() {
        return notCounted;
    }

    public void setNotCounted(boolean notCounted) {
        this.notCounted = notCounted;
    }

    public boolean isServiceUsed() {
        return serviceUsed;
    }

    public void setServiceUsed(boolean serviceUsed) {
        this.serviceUsed = serviceUsed;
    }

    public boolean isDeferredPayment() {
        return deferredPayment;
    }

    public void setDeferredPayment(boolean deferredPayment) {
        this.deferredPayment = deferredPayment;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }
}
