package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class DepartmentDto extends BaseCategoryDto {

    private String insuranceValue;

    private String insuranceName;

    private boolean emergency = false;

    private Long medicalRecordTypeId;

    private String shortName;

    private int sequenceNo;

    private Long buildingId;

    private Long cashierBuildingId;

    private boolean keepPatient = false;

    private Long timeKeepPatient;

    private Long insuranceCeilingAmount;

    private Long advanceAmount;

    private Long insuranceAdvanceAmount;

    private Long serviceAdvanceAmount;

    private Long planBed;

    private Long realBed;

    private Long planNurse;

    private Long planAssistant;

    private boolean clinical = false;

    private boolean subclinical = false;

    private boolean surgery = false;

    private boolean outpatientTreatment = false;

    private boolean outpatient = false;

    private boolean inpatient = false;

    private boolean online = false;

    private boolean useInReception = false;

    private boolean mandatoryNutrition = false;

    private boolean getConclusionSequenceNo = false;

    private boolean noReception = false;

    private boolean deferredPayment = false;

    private boolean noBed = false;

    private boolean rehabilitation = false;

    public DepartmentDto() {
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public Long getMedicalRecordTypeId() {
        return medicalRecordTypeId;
    }

    public void setMedicalRecordTypeId(Long medicalRecordTypeId) {
        this.medicalRecordTypeId = medicalRecordTypeId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public Long getPlanAssistant() {
        return planAssistant;
    }

    public void setPlanAssistant(Long planAssistant) {
        this.planAssistant = planAssistant;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getCashierBuildingId() {
        return cashierBuildingId;
    }

    public void setCashierBuildingId(Long cashierBuildingId) {
        this.cashierBuildingId = cashierBuildingId;
    }

    public boolean isKeepPatient() {
        return keepPatient;
    }

    public void setKeepPatient(boolean keepPatient) {
        this.keepPatient = keepPatient;
    }

    public Long getTimeKeepPatient() {
        return timeKeepPatient;
    }

    public void setTimeKeepPatient(Long timeKeepPatient) {
        this.timeKeepPatient = timeKeepPatient;
    }

    public Long getInsuranceCeilingAmount() {
        return insuranceCeilingAmount;
    }

    public void setInsuranceCeilingAmount(Long insuranceCeilingAmount) {
        this.insuranceCeilingAmount = insuranceCeilingAmount;
    }

    public Long getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(Long advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public Long getInsuranceAdvanceAmount() {
        return insuranceAdvanceAmount;
    }

    public void setInsuranceAdvanceAmount(Long insuranceAdvanceAmount) {
        this.insuranceAdvanceAmount = insuranceAdvanceAmount;
    }

    public Long getServiceAdvanceAmount() {
        return serviceAdvanceAmount;
    }

    public void setServiceAdvanceAmount(Long serviceAdvanceAmount) {
        this.serviceAdvanceAmount = serviceAdvanceAmount;
    }

    public Long getPlanBed() {
        return planBed;
    }

    public void setPlanBed(Long planBed) {
        this.planBed = planBed;
    }

    public Long getRealBed() {
        return realBed;
    }

    public void setRealBed(Long realBed) {
        this.realBed = realBed;
    }

    public Long getPlanNurse() {
        return planNurse;
    }

    public void setPlanNurse(Long planNurse) {
        this.planNurse = planNurse;
    }

    public boolean isClinical() {
        return clinical;
    }

    public void setClinical(boolean clinical) {
        this.clinical = clinical;
    }

    public boolean isSubclinical() {
        return subclinical;
    }

    public void setSubclinical(boolean subclinical) {
        this.subclinical = subclinical;
    }

    public boolean isSurgery() {
        return surgery;
    }

    public void setSurgery(boolean surgery) {
        this.surgery = surgery;
    }

    public boolean isOutpatientTreatment() {
        return outpatientTreatment;
    }

    public void setOutpatientTreatment(boolean outpatientTreatment) {
        this.outpatientTreatment = outpatientTreatment;
    }

    public boolean isOutpatient() {
        return outpatient;
    }

    public void setOutpatient(boolean outpatient) {
        this.outpatient = outpatient;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isUseInReception() {
        return useInReception;
    }

    public void setUseInReception(boolean useInReception) {
        this.useInReception = useInReception;
    }

    public boolean isMandatoryNutrition() {
        return mandatoryNutrition;
    }

    public void setMandatoryNutrition(boolean mandatoryNutrition) {
        this.mandatoryNutrition = mandatoryNutrition;
    }

    public boolean isGetConclusionSequenceNo() {
        return getConclusionSequenceNo;
    }

    public void setGetConclusionSequenceNo(boolean getConclusionSequenceNo) {
        this.getConclusionSequenceNo = getConclusionSequenceNo;
    }

    public boolean isNoReception() {
        return noReception;
    }

    public void setNoReception(boolean noReception) {
        this.noReception = noReception;
    }

    public boolean isDeferredPayment() {
        return deferredPayment;
    }

    public void setDeferredPayment(boolean deferredPayment) {
        this.deferredPayment = deferredPayment;
    }

    public boolean isNoBed() {
        return noBed;
    }

    public void setNoBed(boolean noBed) {
        this.noBed = noBed;
    }

    public boolean isRehabilitation() {
        return rehabilitation;
    }

    public void setRehabilitation(boolean rehabilitation) {
        this.rehabilitation = rehabilitation;
    }
}
