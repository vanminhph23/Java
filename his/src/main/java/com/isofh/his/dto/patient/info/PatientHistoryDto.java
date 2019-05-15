package com.isofh.his.dto.patient.info;

public class PatientHistoryDto extends SimpleInsurancePatientHistoryDto {

    public PatientHistoryDto() {
    }

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

    // statistic
    private Integer outpatientTimes;

    private Integer insOutpatientTimes;

    private Integer insOutpatientTimesMonth;

    private Integer insOutpatientTimesYear;

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
