package com.isofh.his.dto.category.service;

import java.util.Date;

public class ServiceTechnicalDto extends ServiceSourceDto {

    public ServiceTechnicalDto() {
    }

    private Long departmentId;

    private Long roomId;

    private Long specialistId;

    private Long dyeMethodId;

    private Long reportTemplateId;

    private String linkValue;

    private String formValue;

    private boolean useInReception;

    private boolean longTakeResult;

    private boolean inpatient;

    private boolean outpatient;

    private Double lowIndicator;

    private Double highIndicator;

    private Double maleLowIndicator;

    private Double maleHighIndicator;

    private Double femaleLowIndicator;

    private Double femaleHighIndicator;

    private String normalRange;

    private String unit;

    private String reportName;

    private String c43Value;

    private String c43Name;

    private String c37Value;

    private String c37Name;

    private String machineName;

    private String conclusionTemplate;

    private String decision;

    private Date decisionDate;

    private String usingObject;

    private int printOrder;

    private boolean onRequest;

    private boolean timeKeeping;

    private boolean specimens;

    private boolean contract;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public Long getDyeMethodId() {
        return dyeMethodId;
    }

    public void setDyeMethodId(Long dyeMethodId) {
        this.dyeMethodId = dyeMethodId;
    }

    public Long getReportTemplateId() {
        return reportTemplateId;
    }

    public void setReportTemplateId(Long reportTemplateId) {
        this.reportTemplateId = reportTemplateId;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue;
    }

    public boolean isUseInReception() {
        return useInReception;
    }

    public void setUseInReception(boolean useInReception) {
        this.useInReception = useInReception;
    }

    public boolean isLongTakeResult() {
        return longTakeResult;
    }

    public void setLongTakeResult(boolean longTakeResult) {
        this.longTakeResult = longTakeResult;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public boolean isOutpatient() {
        return outpatient;
    }

    public void setOutpatient(boolean outpatient) {
        this.outpatient = outpatient;
    }

    public Double getLowIndicator() {
        return lowIndicator;
    }

    public void setLowIndicator(Double lowIndicator) {
        this.lowIndicator = lowIndicator;
    }

    public Double getHighIndicator() {
        return highIndicator;
    }

    public void setHighIndicator(Double highIndicator) {
        this.highIndicator = highIndicator;
    }

    public Double getMaleLowIndicator() {
        return maleLowIndicator;
    }

    public void setMaleLowIndicator(Double maleLowIndicator) {
        this.maleLowIndicator = maleLowIndicator;
    }

    public Double getMaleHighIndicator() {
        return maleHighIndicator;
    }

    public void setMaleHighIndicator(Double maleHighIndicator) {
        this.maleHighIndicator = maleHighIndicator;
    }

    public Double getFemaleLowIndicator() {
        return femaleLowIndicator;
    }

    public void setFemaleLowIndicator(Double femaleLowIndicator) {
        this.femaleLowIndicator = femaleLowIndicator;
    }

    public Double getFemaleHighIndicator() {
        return femaleHighIndicator;
    }

    public void setFemaleHighIndicator(Double femaleHighIndicator) {
        this.femaleHighIndicator = femaleHighIndicator;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getC43Value() {
        return c43Value;
    }

    public void setC43Value(String c43Value) {
        this.c43Value = c43Value;
    }

    public String getC43Name() {
        return c43Name;
    }

    public void setC43Name(String c43Name) {
        this.c43Name = c43Name;
    }

    public String getC37Value() {
        return c37Value;
    }

    public void setC37Value(String c37Value) {
        this.c37Value = c37Value;
    }

    public String getC37Name() {
        return c37Name;
    }

    public void setC37Name(String c37Name) {
        this.c37Name = c37Name;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getConclusionTemplate() {
        return conclusionTemplate;
    }

    public void setConclusionTemplate(String conclusionTemplate) {
        this.conclusionTemplate = conclusionTemplate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getUsingObject() {
        return usingObject;
    }

    public void setUsingObject(String usingObject) {
        this.usingObject = usingObject;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public boolean isOnRequest() {
        return onRequest;
    }

    public void setOnRequest(boolean onRequest) {
        this.onRequest = onRequest;
    }

    public boolean isTimeKeeping() {
        return timeKeeping;
    }

    public void setTimeKeeping(boolean timeKeeping) {
        this.timeKeeping = timeKeeping;
    }

    public boolean isSpecimens() {
        return specimens;
    }

    public void setSpecimens(boolean specimens) {
        this.specimens = specimens;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }
}
