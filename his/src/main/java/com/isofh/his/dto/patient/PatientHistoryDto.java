package com.isofh.his.dto.patient;

import com.isofh.his.dto.base.BaseDto;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import java.sql.Timestamp;

public class PatientHistoryDto extends BaseDto {

    public PatientHistoryDto() {
    }

    // insurance
    private String insuranceAddress;

    private Timestamp insuranceFromDate;

    private Timestamp insuranceToDate;

    private Timestamp insuranceAppliedFromDate;

    private Timestamp insuranceAppliedToDate;

    private String insuranceNumber;

    private Integer insurancePercent;

    private Long insuranceRegAtHospitalId;

    private Long insurancePatientFromHospitalId;

    private boolean insuranceEmergency;

    private boolean insuranceAppointment;

    private boolean insuranceExtra;

    private boolean insuranceReferral;

    private Timestamp insuranceTimeContinuity5Year;

    private boolean insuranceContinuity5Year;

    private boolean insuranceHundredPercentHightech;

    private boolean insuranceNotCoPayment;

    private Timestamp insuranceNotCopaymentDate;

    private Integer insuranceRegionValue;

    private boolean insuranceKeeping;

    // address
    private Long countryId;

    private Long provinceId;

    private Long districtId;

    private Long zoneId;

    private String detail;

    private String address;

    // guardian
    private String guardianPhone;

    private String guardianName;

    private String guardianIdNo;

    // vital sign
    private Integer bloodPressure;

    private Integer temperature;

    private Integer spo2;

    private Integer pulse;

    private Integer breath;

    private Integer height;

    private Integer weight;

    // medical history
    private String allergy;

    private String disease;

    private String familyDisease;

    private String diseaseProgression;

    private String surgery;

    // in hospital diag
    private String inHospitalDiseaseDiagnostic;

    private String prevDiagnostic;

    private String examinationReason;

    // diag
    private String firstDiagnostic;

    private String diagnostic;

    private String diseaseDiagnostic;

    private String otherDiseaseDiagnostic;

    // common info
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

    private Long phCollectionId;

    private Integer outpatientTimes;

    private Integer insOutpatientTimes;

    private Integer insOutpatientTimesMonth;

    private Integer insOutpatientTimesYear;

    private boolean contract;

    public boolean isPatientInHospital() {
        return patientInHospital;
    }

    public void setPatientInHospital(boolean patientInHospital) {
        this.patientInHospital = patientInHospital;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
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

    public Timestamp getInsuranceAppliedFromDate() {
        return insuranceAppliedFromDate;
    }

    public void setInsuranceAppliedFromDate(Timestamp insuranceAppliedFromDate) {
        this.insuranceAppliedFromDate = insuranceAppliedFromDate;
    }

    public Timestamp getInsuranceAppliedToDate() {
        return insuranceAppliedToDate;
    }

    public void setInsuranceAppliedToDate(Timestamp insuranceAppliedToDate) {
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

    public Timestamp getInsuranceTimeContinuity5Year() {
        return insuranceTimeContinuity5Year;
    }

    public void setInsuranceTimeContinuity5Year(Timestamp insuranceTimeContinuity5Year) {
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

    public Timestamp getInsuranceNotCopaymentDate() {
        return insuranceNotCopaymentDate;
    }

    public void setInsuranceNotCopaymentDate(Timestamp insuranceNotCopaymentDate) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getGuardianIdNo() {
        return guardianIdNo;
    }

    public void setGuardianIdNo(String guardianIdNo) {
        this.guardianIdNo = guardianIdNo;
    }

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getSpo2() {
        return spo2;
    }

    public void setSpo2(Integer spo2) {
        this.spo2 = spo2;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getBreath() {
        return breath;
    }

    public void setBreath(Integer breath) {
        this.breath = breath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public Integer getOutpatientTimes() {
        return outpatientTimes;
    }

    public void setOutpatientTimes(Integer outpatientTimes) {
        this.outpatientTimes = outpatientTimes;
    }

    public Integer getInsOutpatientTimes() {
        return insOutpatientTimes;
    }

    public void setInsOutpatientTimes(Integer insOutpatientTimes) {
        this.insOutpatientTimes = insOutpatientTimes;
    }

    public Integer getInsOutpatientTimesMonth() {
        return insOutpatientTimesMonth;
    }

    public void setInsOutpatientTimesMonth(Integer insOutpatientTimesMonth) {
        this.insOutpatientTimesMonth = insOutpatientTimesMonth;
    }

    public Integer getInsOutpatientTimesYear() {
        return insOutpatientTimesYear;
    }

    public void setInsOutpatientTimesYear(Integer insOutpatientTimesYear) {
        this.insOutpatientTimesYear = insOutpatientTimesYear;
    }
}
