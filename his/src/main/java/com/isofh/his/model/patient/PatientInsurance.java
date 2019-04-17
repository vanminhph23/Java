package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import com.isofh.his.model.category.Hospital;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_patient_insurance")
public class PatientInsurance extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_insurance_generator")
    @SequenceGenerator(
            name = "patient_insurance_generator",
            sequenceName = "patient_insurance_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "insurance_address")
    @Audited
    private String insuranceAddress;

    @Column(name = "insurance_from_date")
    @Audited
    private Timestamp insuranceFromDate;

    @Column(name = "insurance_to_date")
    @Audited
    private Timestamp insuranceToDate;

    @Column(name = "insurance_number", length = 15)
    @Audited
    private String insuranceNumber;

    @Column(name = "insurance_percent")
    @Audited
    private int insurancePercent;

    @Column(name = "insurance_reg_at_hospital_id")
    @Audited
    private int insuranceRegAtHospitalId;

    @ManyToOne
    @JoinColumn(name = "insurance_reg_at_hospital_id", insertable = false, updatable = false)
    private Hospital insuranceRegAtHospital;

    @Column(name = "patient_from_hospital_id")
    @Audited
    private int patientFromHospitalId;

    @ManyToOne
    @JoinColumn(name = "patient_from_hospital_id", insertable = false, updatable = false)
    private Hospital patientFromHospital;

    @Column(name = "emergency")
    @Audited
    private boolean emergency;

    @Column(name = "appointment")
    @Audited
    private boolean appointment;

    @Column(name = "extra")
    @Audited
    private boolean extra;

    @Column(name = "referral")
    @Audited
    private boolean referral;

    @Column(name = "time_continuity_5year")
    @Audited
    private Timestamp timeContinuity5Year;

    @Column(name = "continuity_5year")
    @Audited
    private boolean continuity5Year;

    @Column(name = "hundred_percent_high_tech")
    @Audited
    private boolean hundredPercentHightech;

    @Column(name = "not_copayment")
    @Audited
    private boolean notCopayment;

    @Column(name = "not_copayment_date")
    @Audited
    private Timestamp notCopaymentDate;

    @Column(name = "region_value")
    @Audited
    private int regionValue;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
