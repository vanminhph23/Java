package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_department", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Where(clause = "deleted=0")
public class Department extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "department_generator")
    @SequenceGenerator(
            name = "department_generator",
            sequenceName = "department_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "insurance_value")
    @Audited
    private String insuranceValue;

    @Column(name = "insurance_name")
    @Audited
    private String insuranceName;

    @Column(name = "emergency")
    @Audited
    private boolean emergency = false;

    @Column(name = "medical_record_type_id")
    @Audited
    private Long medicalRecordTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_type_id", insertable = false, updatable = false)
    private MedicalRecordType medicalRecordType;

    @Column(name = "short_name")
    @Audited
    private String shortName;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "building_id")
    @Audited
    private Long buildingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "cashier_building_id")
    @Audited
    private Long cashierBuildingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_building_id", insertable = false, updatable = false)
    private Building cashierBuilding;

    @Column(name = "keep_patient")
    @Audited
    private boolean keepPatient = false;

    @Column(name = "time_keep_patient")
    @Audited
    private Long timeKeepPatient;

    @Column(name = "insurance_ceiling_amount")
    @Audited
    private Long insuranceCeilingAmount;

    @Column(name = "advance_amount")
    @Audited
    private Long advanceAmount;

    @Column(name = "insurance_advance_amount")
    @Audited
    private Long insuranceAdvanceAmount;

    @Column(name = "service_advance_amount")
    @Audited
    private Long serviceAdvanceAmount;

    @Column(name = "plan_bed")
    @Audited
    private Long planBed;

    @Column(name = "real_bed")
    @Audited
    private Long realBed;

    @Column(name = "plan_nurse")
    @Audited
    private Long planNurse;

    @Column(name = "plan_assistant")
    @Audited
    private Long planAssistant;

    @Column(name = "clinical")
    @Audited
    private boolean clinical = false;

    @Column(name = "subclinical")
    @Audited
    private boolean subclinical = false;

    @Column(name = "surgery")
    @Audited
    private boolean surgery = false;

    @Column(name = "outpatient_treatment")
    @Audited
    private boolean outpatientTreatment = false;

    @Column(name = "outpatient")
    @Audited
    private boolean outpatient = false;

    @Column(name = "inpatient")
    @Audited
    private boolean inpatient = false;

    @Column(name = "online")
    @Audited
    private boolean online = false;

    @Column(name = "use_in_reception")
    @Audited
    private boolean useInReception = false;

    @Column(name = "mandatory_nutrition")
    @Audited
    private boolean mandatoryNutrition = false;

    @Column(name = "get_conclusion_sequence_no")
    @Audited
    private boolean getConclusionSequenceNo = false;

    @Column(name = "no_reception")
    @Audited
    private boolean noReception = false;

    @Column(name = "deferred_payment")
    @Audited
    private boolean deferredPayment = false;

    @Column(name = "no_bed")
    @Audited
    private boolean noBed = false;

    @Column(name = "rehabilitation")
    @Audited
    private boolean rehabilitation = false;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public MedicalRecordType getMedicalRecordType() {
        return medicalRecordType;
    }

    public void setMedicalRecordType(MedicalRecordType medicalRecordType) {
        this.medicalRecordType = medicalRecordType;
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

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getCashierBuildingId() {
        return cashierBuildingId;
    }

    public void setCashierBuildingId(Long cashierBuildingId) {
        this.cashierBuildingId = cashierBuildingId;
    }

    public Building getCashierBuilding() {
        return cashierBuilding;
    }

    public void setCashierBuilding(Building cashierBuilding) {
        this.cashierBuilding = cashierBuilding;
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

    public Long getPlanAssistant() {
        return planAssistant;
    }

    public void setPlanAssistant(Long planAssistant) {
        this.planAssistant = planAssistant;
    }
}
