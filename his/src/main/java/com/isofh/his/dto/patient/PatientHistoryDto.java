package com.isofh.his.dto.patient;

import com.isofh.his.dto.base.BaseDto;

import java.sql.Timestamp;

public class PatientHistoryDto extends BaseDto {

    public PatientHistoryDto() {
    }

    private String patientValue;

    private String patientName;

    private String medicalRecordNo;

    private String patientDocument;

    private boolean inpatient = false;

    private Timestamp regDate;

    private Timestamp timeGoIn;

    private Timestamp timeGoOut;

    private Timestamp birthday;

    private boolean onlyYearBirth;

    private String idNo;

    private String phone;

    private int gender;

    private Long departmentId;

    private String address;

    private Long countryId;

    private Long provinceId;

    private Long districtId;

    private Long zoneId;

    private String detail;

    private String guardianPhone;

    private String guardianName;

    private String guardianIDNo;

    private Long jobId;

    private Long medicalRecordTypeId;

    private Long nationalityId;

    private Long ethnicityId;

    private boolean advancePayment;

    private int bloodPressure;

    private int temperature;

    private int spo2;

    private int pulse;

    private int breath;

    private int height;

    private int weight;

    private int bloodType;

    private String allergy;

    private String disease;

    private String familyDisease;

    private String diseaseProgression;

    private String surgery;

    private int patientType;

    private String insuranceAddress;

    private Timestamp insuranceFromDate;

    private Timestamp insuranceToDate;

    private String insuranceNumber;

    private int insurancePercent;

    private int insuranceRegAtHospitalId;

    private int patientFromHospitalId;

    private boolean emergency;

    private boolean appointment;

    private boolean extra;

    private boolean referral;

    private Timestamp timeContinuity5Year;

    private boolean continuity5Year;

    private boolean hundredPercentHightech;

    private boolean notCopayment;

    private Timestamp notCopaymentDate;

    private int regionValue;

    private String inHospitalDiseaseDiagnostic;

    private String prevDiagnostic;

    private String examinationReason;

    private Long patientDiagnosticId;

    private String firstDiagnostic;

    private String diagnostic;

    private String diseaseDiagnostic;

    private String otherDiseaseDiagnostic;

    private int discharge_type;

    private String treatmentDetails;

    private int treatmentDirection;

    private int treatmentResult;

    private int patientState;

    private Long transferFromDepartmentId;

    private Long transferToDepartmentId;

    private Long phCollectionId;

    private Long patientContractId;

    private Long patientOnlineId;

    private String accountOnline;

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

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public Timestamp getTimeGoIn() {
        return timeGoIn;
    }

    public void setTimeGoIn(Timestamp timeGoIn) {
        this.timeGoIn = timeGoIn;
    }

    public Timestamp getTimeGoOut() {
        return timeGoOut;
    }

    public void setTimeGoOut(Timestamp timeGoOut) {
        this.timeGoOut = timeGoOut;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianIDNo() {
        return guardianIDNo;
    }

    public void setGuardianIDNo(String guardianIDNo) {
        this.guardianIDNo = guardianIDNo;
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

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getSpo2() {
        return spo2;
    }

    public void setSpo2(int spo2) {
        this.spo2 = spo2;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getBreath() {
        return breath;
    }

    public void setBreath(int breath) {
        this.breath = breath;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBloodType() {
        return bloodType;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getFamilyDisease() {
        return familyDisease;
    }

    public void setFamilyDisease(String familyDisease) {
        this.familyDisease = familyDisease;
    }

    public String getDiseaseProgression() {
        return diseaseProgression;
    }

    public void setDiseaseProgression(String diseaseProgression) {
        this.diseaseProgression = diseaseProgression;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public int getPatientType() {
        return patientType;
    }

    public void setPatientType(int patientType) {
        this.patientType = patientType;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public Timestamp getInsuranceFromDate() {
        return insuranceFromDate;
    }

    public void setInsuranceFromDate(Timestamp insuranceFromDate) {
        this.insuranceFromDate = insuranceFromDate;
    }

    public Timestamp getInsuranceToDate() {
        return insuranceToDate;
    }

    public void setInsuranceToDate(Timestamp insuranceToDate) {
        this.insuranceToDate = insuranceToDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public int getInsurancePercent() {
        return insurancePercent;
    }

    public void setInsurancePercent(int insurancePercent) {
        this.insurancePercent = insurancePercent;
    }

    public int getInsuranceRegAtHospitalId() {
        return insuranceRegAtHospitalId;
    }

    public void setInsuranceRegAtHospitalId(int insuranceRegAtHospitalId) {
        this.insuranceRegAtHospitalId = insuranceRegAtHospitalId;
    }

    public int getPatientFromHospitalId() {
        return patientFromHospitalId;
    }

    public void setPatientFromHospitalId(int patientFromHospitalId) {
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

    public int getRegionValue() {
        return regionValue;
    }

    public void setRegionValue(int regionValue) {
        this.regionValue = regionValue;
    }

    public String getInHospitalDiseaseDiagnostic() {
        return inHospitalDiseaseDiagnostic;
    }

    public void setInHospitalDiseaseDiagnostic(String inHospitalDiseaseDiagnostic) {
        this.inHospitalDiseaseDiagnostic = inHospitalDiseaseDiagnostic;
    }

    public String getPrevDiagnostic() {
        return prevDiagnostic;
    }

    public void setPrevDiagnostic(String prevDiagnostic) {
        this.prevDiagnostic = prevDiagnostic;
    }

    public String getExaminationReason() {
        return examinationReason;
    }

    public void setExaminationReason(String examinationReason) {
        this.examinationReason = examinationReason;
    }

    public Long getPatientDiagnosticId() {
        return patientDiagnosticId;
    }

    public void setPatientDiagnosticId(Long patientDiagnosticId) {
        this.patientDiagnosticId = patientDiagnosticId;
    }

    public String getFirstDiagnostic() {
        return firstDiagnostic;
    }

    public void setFirstDiagnostic(String firstDiagnostic) {
        this.firstDiagnostic = firstDiagnostic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDiseaseDiagnostic() {
        return diseaseDiagnostic;
    }

    public void setDiseaseDiagnostic(String diseaseDiagnostic) {
        this.diseaseDiagnostic = diseaseDiagnostic;
    }

    public String getOtherDiseaseDiagnostic() {
        return otherDiseaseDiagnostic;
    }

    public void setOtherDiseaseDiagnostic(String otherDiseaseDiagnostic) {
        this.otherDiseaseDiagnostic = otherDiseaseDiagnostic;
    }

    public int getDischarge_type() {
        return discharge_type;
    }

    public void setDischarge_type(int discharge_type) {
        this.discharge_type = discharge_type;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public int getTreatmentDirection() {
        return treatmentDirection;
    }

    public void setTreatmentDirection(int treatmentDirection) {
        this.treatmentDirection = treatmentDirection;
    }

    public int getTreatmentResult() {
        return treatmentResult;
    }

    public void setTreatmentResult(int treatmentResult) {
        this.treatmentResult = treatmentResult;
    }

    public int getPatientState() {
        return patientState;
    }

    public void setPatientState(int patientState) {
        this.patientState = patientState;
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

    public Long getPhCollectionId() {
        return phCollectionId;
    }

    public void setPhCollectionId(Long phCollectionId) {
        this.phCollectionId = phCollectionId;
    }

    public Long getPatientContractId() {
        return patientContractId;
    }

    public void setPatientContractId(Long patientContractId) {
        this.patientContractId = patientContractId;
    }

    public Long getPatientOnlineId() {
        return patientOnlineId;
    }

    public void setPatientOnlineId(Long patientOnlineId) {
        this.patientOnlineId = patientOnlineId;
    }

    public String getAccountOnline() {
        return accountOnline;
    }

    public void setAccountOnline(String accountOnline) {
        this.accountOnline = accountOnline;
    }
}
