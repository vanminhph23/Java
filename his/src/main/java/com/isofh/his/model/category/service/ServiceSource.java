package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.UOM;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "service_type", "deleted"})})
@Where(clause = "deleted=0")
public class ServiceSource extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "service_generator")
    @SequenceGenerator(
            name = "service_generator",
            sequenceName = "service_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

    @Column(name = "c9324_expense_type")
    @Audited
    private int c9324ExpenseType;

    @Column(name = "cx_value")
    @Audited
    private String cxValue;

    @Column(name = "cx_name")
    @Audited
    private String cxName;

    @Column(name = "insurance_pay_rate", nullable = false)
    @Audited
    private int insurancePayRate;

    @Column(name = "uom_id")
    @Audited
    private Long uomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uom_id", insertable = false, updatable = false)
    private UOM uom;

    @Column(name = "service_group_level1_id")
    @Audited
    private Long serviceGroupLevel1Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_group_level1_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel1;

    @Column(name = "service_group_level2_id")
    @Audited
    private Long serviceGroupLevel2Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_group_level2_id", insertable = false, updatable = false)
    private ServiceGroupLevel2 serviceGroupLevel2;

    @Column(name = "service_group_level3_id")
    @Audited
    private Long serviceGroupLevel3Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_group_level3_id", insertable = false, updatable = false)
    private ServiceGroupLevel3 serviceGroupLevel3;

    @Column(name = "service_unit_price")
    @Audited
    private Double serviceUnitPrice;

    @Column(name = "insurance_unit_price")
    @Audited
    private Double insuranceUnitPrice;

    @Column(name = "difference_unit_price")
    @Audited
    private Double differenceUnitPrice;

    @Column(name = "old_value")
    @Audited
    private String oldValue;

    @Column(name = "old_name")
    @Audited
    private String oldName;

    @Column(name = "short_name")
    @Audited
    private String shortName;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "not_counted", nullable = false)
    @Audited
    private boolean notCounted;

    @Column(name = "service_in_hospital", nullable = false)
    @Audited
    private boolean serviceInHospital;

    @Column(name = "not_used", nullable = false)
    @Audited
    private boolean notUsed;

    @Column(name = "not_control", nullable = false)
    @Audited
    private boolean notControl;

    @Column(name = "create_odd", nullable = false)
    @Audited
    private boolean createOdd;

    @Column(name = "change_source", nullable = false)
    @Audited
    private boolean changeSource;

    @Column(name = "apply_c35", nullable = false)
    @Audited
    private boolean applyC35;

    @Column(name = "surgery", nullable = false)
    @Audited
    private boolean surgery;

    @Column(name = "consultation", nullable = false)
    @Audited
    private boolean consultation;

    @Column(name = "tracking_using_day", nullable = false)
    @Audited
    private boolean trackingUsingDay;

    @Column(name = "limit_insurance", nullable = false)
    @Audited
    private boolean limitInsurance;

    @Column(name = "dosage", nullable = false)
    @Audited
    private boolean dosage;

    @Column(name = "antibiotic", nullable = false)
    @Audited
    private boolean antibiotic;

    @Column(name = "free_by_approval", nullable = false)
    @Audited
    private boolean freeByApproval;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public UOM getUom() {
        return uom;
    }

    public void setUom(UOM uom) {
        this.uom = uom;
    }

    public Long getServiceGroupLevel1Id() {
        return serviceGroupLevel1Id;
    }

    public void setServiceGroupLevel1Id(Long serviceGroupLevel1Id) {
        this.serviceGroupLevel1Id = serviceGroupLevel1Id;
    }

    public ServiceGroupLevel1 getServiceGroupLevel1() {
        return serviceGroupLevel1;
    }

    public void setServiceGroupLevel1(ServiceGroupLevel1 serviceGroupLevel1) {
        this.serviceGroupLevel1 = serviceGroupLevel1;
    }

    public Long getServiceGroupLevel2Id() {
        return serviceGroupLevel2Id;
    }

    public void setServiceGroupLevel2Id(Long serviceGroupLevel2Id) {
        this.serviceGroupLevel2Id = serviceGroupLevel2Id;
    }

    public ServiceGroupLevel2 getServiceGroupLevel2() {
        return serviceGroupLevel2;
    }

    public void setServiceGroupLevel2(ServiceGroupLevel2 serviceGroupLevel2) {
        this.serviceGroupLevel2 = serviceGroupLevel2;
    }

    public Long getServiceGroupLevel3Id() {
        return serviceGroupLevel3Id;
    }

    public void setServiceGroupLevel3Id(Long serviceGroupLevel3Id) {
        this.serviceGroupLevel3Id = serviceGroupLevel3Id;
    }

    public ServiceGroupLevel3 getServiceGroupLevel3() {
        return serviceGroupLevel3;
    }

    public void setServiceGroupLevel3(ServiceGroupLevel3 serviceGroupLevel3) {
        this.serviceGroupLevel3 = serviceGroupLevel3;
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