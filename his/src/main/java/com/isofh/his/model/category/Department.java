package com.isofh.his.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.employee.User;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_department")
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

    @ManyToOne
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

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "cashier_building_id")
    @Audited
    private Long cashierBuildingId;

    @ManyToOne
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
}
