package com.isofh.hibernate.entities;
// Generated Jun 3, 2016 4:51:39 PM by Hibernate Tools 4.3.1

import java.sql.Timestamp;

/**
 * HisServiceMedicaltest generated by hbm2java
 */
public class ServiceMedicaltest implements java.io.Serializable {

    private int serviceMedicaltestID;
    private String status;
    private String statusLIS;
    private Timestamp timegotResult;
    private Timestamp timehasResult;
    private Timestamp timeTakePatient;
    private Timestamp updated;
    private int updatedby;
    private int serviceMedictestGroupID;
    private String patientValue;
    private String patientMedicalRecordNo;
    private String indicatorStr;
    private int patientHistoryID;

    public ServiceMedicaltest() {
    }

    public int getServiceMedicaltestID() {
        return serviceMedicaltestID;
    }

    public void setServiceMedicaltestID(int serviceMedicaltestID) {
        this.serviceMedicaltestID = serviceMedicaltestID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimegotResult() {
        return timegotResult;
    }

    public void setTimegotResult(Timestamp timegotResult) {
        this.timegotResult = timegotResult;
    }

    public Timestamp getTimehasResult() {
        return timehasResult;
    }

    public void setTimehasResult(Timestamp timehasResult) {
        this.timehasResult = timehasResult;
    }

    public Timestamp getTimeTakePatient() {
        return timeTakePatient;
    }

    public void setTimeTakePatient(Timestamp timeTakePatient) {
        this.timeTakePatient = timeTakePatient;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    public int getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(int updatedby) {
        this.updatedby = updatedby;
    }

    public int getServiceMedictestGroupID() {
        return serviceMedictestGroupID;
    }

    public void setServiceMedictestGroupID(int serviceMedictestGroupID) {
        this.serviceMedictestGroupID = serviceMedictestGroupID;
    }

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientMedicalRecordNo() {
        return patientMedicalRecordNo;
    }

    public void setPatientMedicalRecordNo(String patientMedicalRecordNo) {
        this.patientMedicalRecordNo = patientMedicalRecordNo;
    }

    public String getIndicatorStr() {
        return indicatorStr;
    }

    public void setIndicatorStr(String indicatorStr) {
        this.indicatorStr = indicatorStr;
    }

    public int getPatientHistoryID() {
        return patientHistoryID;
    }

    public void setPatientHistoryID(int patientHistoryID) {
        this.patientHistoryID = patientHistoryID;
    }

    public String getStatusLIS() {
        return statusLIS;
    }

    public void setStatusLIS(String statusLIS) {
        this.statusLIS = statusLIS;
    }

}
