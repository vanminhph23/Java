package com.isofh.his.dto.category.service;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ServiceSourceDto extends BaseCategoryDto {

    public ServiceSourceDto() {
    }

    private int serviceType;

    private int c9324ExpenseType;

    private String cxValue;

    private String cxName;

    private int insurancePayRate;

    private Long uomId;

    private Long serviceGroupLevel1Id;

    private Long serviceGroupLevel2Id;

    private Long serviceGroupLevel3Id;

    private Double serviceUnitPrice;

    private Double insuranceUnitPrice;

    private Double differenceUnitPrice;

    private String oldValue;

    private String oldName;

    private String shortName;

    private String description;

    private boolean notCounted;

    private boolean serviceInHospital;

    private boolean notUsed;

    private boolean notControl;

    private boolean createOdd;

    private boolean changeSource;

    private boolean applyC35;

    private boolean surgery;

    private boolean consultation;

    private boolean trackingUsingDay;

    private boolean limitInsurance;

    private boolean dosage;

    private boolean antibiotic;

    private boolean freeByApproval;

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public int getC9324ExpenseType() {
        return c9324ExpenseType;
    }

    public void setC9324ExpenseType(int c9324ExpenseType) {
        this.c9324ExpenseType = c9324ExpenseType;
    }

    public String getCxValue() {
        return cxValue;
    }

    public void setCxValue(String cxValue) {
        this.cxValue = cxValue;
    }

    public String getCxName() {
        return cxName;
    }

    public void setCxName(String cxName) {
        this.cxName = cxName;
    }

    public int getInsurancePayRate() {
        return insurancePayRate;
    }

    public void setInsurancePayRate(int insurancePayRate) {
        this.insurancePayRate = insurancePayRate;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Long getServiceGroupLevel1Id() {
        return serviceGroupLevel1Id;
    }

    public void setServiceGroupLevel1Id(Long serviceGroupLevel1Id) {
        this.serviceGroupLevel1Id = serviceGroupLevel1Id;
    }

    public Long getServiceGroupLevel2Id() {
        return serviceGroupLevel2Id;
    }

    public void setServiceGroupLevel2Id(Long serviceGroupLevel2Id) {
        this.serviceGroupLevel2Id = serviceGroupLevel2Id;
    }

    public Long getServiceGroupLevel3Id() {
        return serviceGroupLevel3Id;
    }

    public void setServiceGroupLevel3Id(Long serviceGroupLevel3Id) {
        this.serviceGroupLevel3Id = serviceGroupLevel3Id;
    }

    public Double getServiceUnitPrice() {
        return serviceUnitPrice;
    }

    public void setServiceUnitPrice(Double serviceUnitPrice) {
        this.serviceUnitPrice = serviceUnitPrice;
    }

    public Double getInsuranceUnitPrice() {
        return insuranceUnitPrice;
    }

    public void setInsuranceUnitPrice(Double insuranceUnitPrice) {
        this.insuranceUnitPrice = insuranceUnitPrice;
    }

    public Double getDifferenceUnitPrice() {
        return differenceUnitPrice;
    }

    public void setDifferenceUnitPrice(Double differenceUnitPrice) {
        this.differenceUnitPrice = differenceUnitPrice;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotCounted() {
        return notCounted;
    }

    public void setNotCounted(boolean notCounted) {
        this.notCounted = notCounted;
    }

    public boolean isServiceInHospital() {
        return serviceInHospital;
    }

    public void setServiceInHospital(boolean serviceInHospital) {
        this.serviceInHospital = serviceInHospital;
    }

    public boolean isNotUsed() {
        return notUsed;
    }

    public void setNotUsed(boolean notUsed) {
        this.notUsed = notUsed;
    }

    public boolean isNotControl() {
        return notControl;
    }

    public void setNotControl(boolean notControl) {
        this.notControl = notControl;
    }

    public boolean isCreateOdd() {
        return createOdd;
    }

    public void setCreateOdd(boolean createOdd) {
        this.createOdd = createOdd;
    }

    public boolean isChangeSource() {
        return changeSource;
    }

    public void setChangeSource(boolean changeSource) {
        this.changeSource = changeSource;
    }

    public boolean isApplyC35() {
        return applyC35;
    }

    public void setApplyC35(boolean applyC35) {
        this.applyC35 = applyC35;
    }

    public boolean isSurgery() {
        return surgery;
    }

    public void setSurgery(boolean surgery) {
        this.surgery = surgery;
    }

    public boolean isConsultation() {
        return consultation;
    }

    public void setConsultation(boolean consultation) {
        this.consultation = consultation;
    }

    public boolean isTrackingUsingDay() {
        return trackingUsingDay;
    }

    public void setTrackingUsingDay(boolean trackingUsingDay) {
        this.trackingUsingDay = trackingUsingDay;
    }

    public boolean isLimitInsurance() {
        return limitInsurance;
    }

    public void setLimitInsurance(boolean limitInsurance) {
        this.limitInsurance = limitInsurance;
    }

    public boolean isDosage() {
        return dosage;
    }

    public void setDosage(boolean dosage) {
        this.dosage = dosage;
    }

    public boolean isAntibiotic() {
        return antibiotic;
    }

    public void setAntibiotic(boolean antibiotic) {
        this.antibiotic = antibiotic;
    }

    public boolean isFreeByApproval() {
        return freeByApproval;
    }

    public void setFreeByApproval(boolean freeByApproval) {
        this.freeByApproval = freeByApproval;
    }
}
