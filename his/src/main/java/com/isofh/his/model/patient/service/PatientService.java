package com.isofh.his.model.patient.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.category.Room;
import com.isofh.his.model.category.service.Service;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientTransferDepartment;
import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.model.patient.invoice.PatientPayment;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

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

    @Column(name = "service_exemption_amount")
    @Audited
    private Double serviceExemptionAmount;

    @Column(name = "insurance_exemption_amount")
    @Audited
    private Double insuranceExemptionAmount;

    @Column(name = "amount")
    @Audited
    private Double amount;

    @Column(name = "quantity")
    @Audited
    private Double quantity;

    @Column(name = "service_pay_rate")
    @Audited
    private Double servicePayRate;

    @Column(name = "insurance_pay_rate")
    @Audited
    private Double insurancePayRate;

    @Column(name = "not_counted", nullable = false)
    @Audited
    private boolean notCounted;

    @Column(name = "service_used", nullable = false)
    @Audited
    private boolean serviceUsed;

    @Column(name = "insurance_paid", nullable = false)
    @Audited
    private boolean insurancePaid;

    @Column(name = "service_paid", nullable = false)
    @Audited
    private boolean servicePaid;

    @Column(name = "service_in_hospital", nullable = false)
    @Audited
    private boolean serviceInHospital;

    @Column(name = "contract", nullable = false)
    @Audited
    private boolean contract;

    @Column(name = "patient_request", nullable = false)
    @Audited
    private boolean patientRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_patient_invoice_id")
    private PatientInvoice insurancePatientInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_patient_invoice_id")
    private PatientInvoice servicePatientInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_transfer_department_id")
    private PatientTransferDepartment patientTransferDepartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_type_id")
    private PatientType patientType;

    @Column(name = "transfer_from_outpatient")
    @Audited
    private boolean transferFromOutpatient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_payment_id")
    private PatientPayment patientPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_department_id")
    private Department fromDepartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "created_from_record_id")
    @Audited
    private Long createdFromRecordId;

    @Column(name = "created_from_service_type")
    @Audited
    private int createdFromServiceType;

    @Column(name = "doc_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date docDate;

    @Column(name = "act_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date actDate;

    @Column(name = "status")
    @Audited
    private int status;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
