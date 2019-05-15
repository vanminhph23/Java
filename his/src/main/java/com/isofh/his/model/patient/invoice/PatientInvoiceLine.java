package com.isofh.his.model.patient.invoice;

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
@Table(name = "his_patient_invoice_line")
public class PatientInvoiceLine extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_invoice_line_generator")
    @SequenceGenerator(
            name = "patient_invoice_line_generator",
            sequenceName = "patient_invoice_line_sq",
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

    public Long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(String serviceValue) {
        this.serviceValue = serviceValue;
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

    public Double getServiceTotalAmount() {
        return serviceTotalAmount;
    }

    public void setServiceTotalAmount(Double serviceTotalAmount) {
        this.serviceTotalAmount = serviceTotalAmount;
    }

    public Double getInsuranceTotalAmount() {
        return insuranceTotalAmount;
    }

    public void setInsuranceTotalAmount(Double insuranceTotalAmount) {
        this.insuranceTotalAmount = insuranceTotalAmount;
    }

    public Double getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(Double serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public Double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Double getServiceExemptionAmount() {
        return serviceExemptionAmount;
    }

    public void setServiceExemptionAmount(Double serviceExemptionAmount) {
        this.serviceExemptionAmount = serviceExemptionAmount;
    }

    public Double getInsuranceExemptionAmount() {
        return insuranceExemptionAmount;
    }

    public void setInsuranceExemptionAmount(Double insuranceExemptionAmount) {
        this.insuranceExemptionAmount = insuranceExemptionAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getServicePayRate() {
        return servicePayRate;
    }

    public void setServicePayRate(Double servicePayRate) {
        this.servicePayRate = servicePayRate;
    }

    public Double getInsurancePayRate() {
        return insurancePayRate;
    }

    public void setInsurancePayRate(Double insurancePayRate) {
        this.insurancePayRate = insurancePayRate;
    }

    public boolean isNotCounted() {
        return notCounted;
    }

    public void setNotCounted(boolean notCounted) {
        this.notCounted = notCounted;
    }

    public boolean isServiceUsed() {
        return serviceUsed;
    }

    public void setServiceUsed(boolean serviceUsed) {
        this.serviceUsed = serviceUsed;
    }

    public boolean isInsurancePaid() {
        return insurancePaid;
    }

    public void setInsurancePaid(boolean insurancePaid) {
        this.insurancePaid = insurancePaid;
    }

    public boolean isServicePaid() {
        return servicePaid;
    }

    public void setServicePaid(boolean servicePaid) {
        this.servicePaid = servicePaid;
    }

    public boolean isServiceInHospital() {
        return serviceInHospital;
    }

    public void setServiceInHospital(boolean serviceInHospital) {
        this.serviceInHospital = serviceInHospital;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public boolean isPatientRequest() {
        return patientRequest;
    }

    public void setPatientRequest(boolean patientRequest) {
        this.patientRequest = patientRequest;
    }

    public PatientInvoice getInsurancePatientInvoice() {
        return insurancePatientInvoice;
    }

    public void setInsurancePatientInvoice(PatientInvoice insurancePatientInvoice) {
        this.insurancePatientInvoice = insurancePatientInvoice;
    }

    public PatientInvoice getServicePatientInvoice() {
        return servicePatientInvoice;
    }

    public void setServicePatientInvoice(PatientInvoice servicePatientInvoice) {
        this.servicePatientInvoice = servicePatientInvoice;
    }

    public PatientTransferDepartment getPatientTransferDepartment() {
        return patientTransferDepartment;
    }

    public void setPatientTransferDepartment(PatientTransferDepartment patientTransferDepartment) {
        this.patientTransferDepartment = patientTransferDepartment;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public boolean isTransferFromOutpatient() {
        return transferFromOutpatient;
    }

    public void setTransferFromOutpatient(boolean transferFromOutpatient) {
        this.transferFromOutpatient = transferFromOutpatient;
    }

    public PatientPayment getPatientPayment() {
        return patientPayment;
    }

    public void setPatientPayment(PatientPayment patientPayment) {
        this.patientPayment = patientPayment;
    }

    public Department getFromDepartment() {
        return fromDepartment;
    }

    public void setFromDepartment(Department fromDepartment) {
        this.fromDepartment = fromDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getCreatedFromRecordId() {
        return createdFromRecordId;
    }

    public void setCreatedFromRecordId(Long createdFromRecordId) {
        this.createdFromRecordId = createdFromRecordId;
    }

    public int getCreatedFromServiceType() {
        return createdFromServiceType;
    }

    public void setCreatedFromServiceType(int createdFromServiceType) {
        this.createdFromServiceType = createdFromServiceType;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
