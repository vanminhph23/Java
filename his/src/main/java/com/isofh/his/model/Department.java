package com.isofh.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_department")
public class Department extends Base2Model {
    @Id
    @GeneratedValue(generator = "department_generator")
    @SequenceGenerator(
            name = "department_generator",
            sequenceName = "department_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "assurance_value")
    @Audited
    private String assuranceValue;

    @Column(name = "assurance_name")
    @Audited
    private String assuranceName;

    @Column(name = "emergency")
    @Audited
    private boolean emergency = false;

    @Column(name = "medical_record_type_id")
    @Audited
    private String medicalRecordTypeId;

    @JoinColumn(name = "medical_record_type_id", insertable = false, updatable = false)
    private MedicalRecordType medicalRecordType;

    @Column(name = "short_name")
    @Audited
    private String shortName;

    @Column(name = "sequence_no")
    @Audited
    private String sequenceNo;

    @Column(name = "building_id")
    @Audited
    private String buildingId;

    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "cashier_building_id")
    @Audited
    private String cashierBuildingId;

    @JoinColumn(name = "cashier_building_id", insertable = false, updatable = false)
    private Building cashierBuilding;

    @Column(name = "keep_patient")
    @Audited
    private boolean keepPatient = false;

    @Column(name = "time_keep_patient")
    @Audited
    private Long timeKeepPatient;

    @Column(name = "ceiling_assurance_amount")
    @Audited
    private Long ceilingAssuranceAmount;

    @Column(name = "advance_assurance_amount")
    @Audited
    private Long advanceAssuranceAmount;

    @Column(name = "advance_service_amount")
    @Audited
    private Long advanceServiceAmount;

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
    private Long plan_assistant;

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

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<User> users;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getAssuranceValue() {
        return assuranceValue;
    }

    public void setAssuranceValue(String assuranceValue) {
        this.assuranceValue = assuranceValue;
    }

    public String getAssuranceName() {
        return assuranceName;
    }

    public void setAssuranceName(String assuranceName) {
        this.assuranceName = assuranceName;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public String getMedicalRecordTypeId() {
        return medicalRecordTypeId;
    }

    public void setMedicalRecordTypeId(String medicalRecordTypeId) {
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

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getCashierBuildingId() {
        return cashierBuildingId;
    }

    public void setCashierBuildingId(String cashierBuildingId) {
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

    public Long getCeilingAssuranceAmount() {
        return ceilingAssuranceAmount;
    }

    public void setCeilingAssuranceAmount(Long ceilingAssuranceAmount) {
        this.ceilingAssuranceAmount = ceilingAssuranceAmount;
    }

    public Long getAdvanceAssuranceAmount() {
        return advanceAssuranceAmount;
    }

    public void setAdvanceAssuranceAmount(Long advanceAssuranceAmount) {
        this.advanceAssuranceAmount = advanceAssuranceAmount;
    }

    public Long getAdvanceServiceAmount() {
        return advanceServiceAmount;
    }

    public void setAdvanceServiceAmount(Long advanceServiceAmount) {
        this.advanceServiceAmount = advanceServiceAmount;
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

    public Long getPlan_assistant() {
        return plan_assistant;
    }

    public void setPlan_assistant(Long plan_assistant) {
        this.plan_assistant = plan_assistant;
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
