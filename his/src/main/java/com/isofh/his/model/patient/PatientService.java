package com.isofh.his.model.patient;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_service")
public class PatientService extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_service_generator")
    @SequenceGenerator(
            name = "patient_service_generator",
            sequenceName = "patient_service_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id")
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "patient_value", nullable = false)
    @Audited
    private String patientValue;

    @Column(name = "patient_name", nullable = false)
    @Audited
    private String patientName;

    @Column(name = "medical_record_no", length = 7)
    @Audited
    private String medicalRecordNo;

    @Column(name = "patient_document", nullable = false, length = 10)
    @Audited
    private String patientDocument;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient = false;

    @Column(name = "service_id")
    @Audited
    private Long serviceId;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

    @Column(name = "service_name")
    @Audited
    private String serviceName;

    @Column(name = "service_value")
    @Audited
    private String serviceValue;

    @Column(name = "service_group_level1_id")
    @Audited
    private Long serviceGroupLevel1Id;

    @Column(name = "service_group_level2_id")
    @Audited
    private Long serviceGroupLevel2Id;

    @Column(name = "service_group_level3_id")
    @Audited
    private Long serviceGroupLevel3Id;

    @Column(name = "service_unit_price")
    @Audited
    private Double serviceUnitPrice;

    @Column(name = "insurance_unit_price")
    @Audited
    private Double insuranceUnitPrice;

    @Column(name = "difference_unit_price")
    @Audited
    private Double differenceUnitPrice;

    @Column(name = "service_total_amount")
    @Audited
    private Double serviceTotalAmount;

    @Column(name = "insurance_total_amount")
    @Audited
    private Double insuranceTotalAmount;

    @Column(name = "service_amount")
    @Audited
    private Double serviceAmount;

    @Column(name = "insurance_amount")
    @Audited
    private Double insuranceAmount;

    @Column(name = "amount")
    @Audited
    private Double amount;

    @Column(name = "service_pay_rate")
    @Audited
    private Double servicePayRate;

    @Column(name = "insurance_pay_rate")
    @Audited
    private Double insurancePayRate;

    @Column(name = "from_department_id")
    @Audited
    private Long fromDepartmentId;

    @Column(name = "department_id")
    @Audited
    private Long departmentId;

    @Column(name = "room_id")
    @Audited
    private Long roomId;

    @Column(name = "created_from_record_id")
    @Audited
    private Long createdFromRecordId;

    @Column(name = "created_from_service_type")
    @Audited
    private int createdFromServiceType;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
