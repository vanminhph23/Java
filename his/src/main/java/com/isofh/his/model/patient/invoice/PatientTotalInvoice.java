package com.isofh.his.model.patient.invoice;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.employee.User;
import com.isofh.his.model.patient.info.PatientHistory;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient_total_invoice")
public class PatientTotalInvoice extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_total_invoice_generator")
    @SequenceGenerator(
            name = "patient_total_invoice_generator",
            sequenceName = "patient_total_invoice_sq",
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

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
