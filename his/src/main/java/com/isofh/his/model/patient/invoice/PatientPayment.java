package com.isofh.his.model.patient.invoice;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.employee.User;
import com.isofh.his.model.patient.info.PatientHistory;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient_payment")
@Where(clause = "deleted=0")
public class PatientPayment extends BaseModel {

    @Id
    @GeneratedValue(generator = "patient_payment_generator")
    @SequenceGenerator(
            name = "patient_payment_generator",
            sequenceName = "patient_payment_sq",
            initialValue = 1000000
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_history_id")
    private PatientHistory patientHistory;

    @Column(name = "amount")
    @Audited
    private Double amount;

    @Column(name = "requested_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date requestedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requested_user_id")
    private User requestedUser;

    @Column(name = "approved_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date approvedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_user_id")
    private User approvedUser;

    @Column(name = "pay_time")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date payTime;

    @Column(name = "payment_no")
    @Audited
    private String paymentNo;

    @Column(name = "approved")
    @Audited
    private boolean approved;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
