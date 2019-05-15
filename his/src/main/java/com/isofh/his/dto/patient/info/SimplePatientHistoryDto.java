package com.isofh.his.dto.patient.info;

import com.isofh.his.dto.base.BaseDto;

import java.util.Date;

public class SimplePatientHistoryDto extends BaseDto {

    public SimplePatientHistoryDto() {
    }

    // common info
    private String patientValue;

    private String patientName;

    private String medicalRecordNo;

    private String patientDocument;

    private boolean inpatient = false;

    private Date regDate;

    private Date timeGoIn;

    private Date timeGoOut;

    private Date birthday;

    private String birthdayStr;

    private boolean onlyYearBirth;

    private String idNo;

    private String phone;

    private Integer gender;

    private Long departmentId;

    private Long jobId;

    private Long medicalRecordTypeId;

    private Long nationalityId;

    private Long ethnicityId;

    private boolean advancePayment;

    private Integer bloodType;

    private Integer patientType;

    //Out hospital
    private Integer discharge_type;

    private String treatmentDetails;

    private Integer treatmentDirection;

    private Integer treatmentResult;

    private Integer patientState;

    private boolean patientInHospital = true;

    private Long transferFromDepartmentId;

    private Long transferToDepartmentId;

    private Long patientHistoryCollectionId;

    private boolean contract;

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getTimeGoIn() {
        return timeGoIn;
    }

    public void setTimeGoIn(Date timeGoIn) {
        this.timeGoIn = timeGoIn;
    }

    public Date getTimeGoOut() {
        return timeGoOut;
    }

    public void setTimeGoOut(Date timeGoOut) {
        this.timeGoOut = timeGoOut;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public boolean isOnlyYearBirth() {
        return onlyYearBirth;
    }

    public void setOnlyYearBirth(boolean onlyYearBirth) {
        this.onlyYearBirth = onlyYearBirth;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getMedicalRecordTypeId() {
        return medicalRecordTypeId;
    }

    public void setMedicalRecordTypeId(Long medicalRecordTypeId) {
        this.medicalRecordTypeId = medicalRecordTypeId;
    }

    public Long getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Long nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Long getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Long ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public boolean isAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(boolean advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public Integer getDischarge_type() {
        return discharge_type;
    }

    public void setDischarge_type(Integer discharge_type) {
        this.discharge_type = discharge_type;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public Integer getTreatmentDirection() {
        return treatmentDirection;
    }

    public void setTreatmentDirection(Integer treatmentDirection) {
        this.treatmentDirection = treatmentDirection;
    }

    public Integer getTreatmentResult() {
        return treatmentResult;
    }

    public void setTreatmentResult(Integer treatmentResult) {
        this.treatmentResult = treatmentResult;
    }

    public Integer getPatientState() {
        return patientState;
    }

    public void setPatientState(Integer patientState) {
        this.patientState = patientState;
    }

    public boolean isPatientInHospital() {
        return patientInHospital;
    }

    public void setPatientInHospital(boolean patientInHospital) {
        this.patientInHospital = patientInHospital;
    }

    public Long getTransferFromDepartmentId() {
        return transferFromDepartmentId;
    }

    public void setTransferFromDepartmentId(Long transferFromDepartmentId) {
        this.transferFromDepartmentId = transferFromDepartmentId;
    }

    public Long getTransferToDepartmentId() {
        return transferToDepartmentId;
    }

    public void setTransferToDepartmentId(Long transferToDepartmentId) {
        this.transferToDepartmentId = transferToDepartmentId;
    }

    public Long getPatientHistoryCollectionId() {
        return patientHistoryCollectionId;
    }

    public void setPatientHistoryCollectionId(Long patientHistoryCollectionId) {
        this.patientHistoryCollectionId = patientHistoryCollectionId;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }
}
