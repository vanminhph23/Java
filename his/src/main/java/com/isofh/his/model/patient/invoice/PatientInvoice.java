package com.isofh.his.model.patient.invoice;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.employee.User;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientType;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient_invoice")
public class PatientInvoice extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_invoice_generator")
    @SequenceGenerator(
            name = "patient_invoice_generator",
            sequenceName = "patient_invoice_sq",
            initialValue = 1000000
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_history_id")
    private PatientHistory patientHistory;

    @Column(name = "amount")
    @Audited
    private Double amount;

    @Column(name = "pay_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date payTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_user_id")
    private User cashierUser;

    @Column(name = "invoice_no")
    @Audited
    private String invoiceNo;

    @Column(name = "total_invoice_no")
    @Audited
    private String totalInvoiceNo;

    @Column(name = "paid")
    @Audited
    private boolean paid;

    @Column(name = "inpatient")
    @Audited
    private boolean inpatient;

    @Column(name = "invoice_type")
    @Audited
    private int invoiceType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_type_id")
    private PatientType patientType;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public User getCashierUser() {
        return cashierUser;
    }

    public void setCashierUser(User cashierUser) {
        this.cashierUser = cashierUser;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getTotalInvoiceNo() {
        return totalInvoiceNo;
    }

    public void setTotalInvoiceNo(String totalInvoiceNo) {
        this.totalInvoiceNo = totalInvoiceNo;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }
}
