package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_statistics")
@Where(clause = "deleted=0")
public class PatientStatistics extends BasePatientModel {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PatientHistory patientHistory;

    @Column(name = "outpatient_times")
    @Audited
    private Integer outpatientTimes;

    @Column(name = "ins_outpatient_times")
    @Audited
    private Integer insOutpatientTimes;

    @Column(name = "ins_outpatient_times_month")
    @Audited
    private Integer insOutpatientTimesMonth;

    @Column(name = "ins_outpatient_times_year")
    @Audited
    private Integer insOutpatientTimesYear;

    @Override
    public Long getId() {
        return id;
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

    public Integer getOutpatientTimes() {
        return outpatientTimes;
    }

    public void setOutpatientTimes(Integer outpatientTimes) {
        this.outpatientTimes = outpatientTimes;
    }

    public Integer getInsOutpatientTimes() {
        return insOutpatientTimes;
    }

    public void setInsOutpatientTimes(Integer insOutpatientTimes) {
        this.insOutpatientTimes = insOutpatientTimes;
    }

    public Integer getInsOutpatientTimesMonth() {
        return insOutpatientTimesMonth;
    }

    public void setInsOutpatientTimesMonth(Integer insOutpatientTimesMonth) {
        this.insOutpatientTimesMonth = insOutpatientTimesMonth;
    }

    public Integer getInsOutpatientTimesYear() {
        return insOutpatientTimesYear;
    }

    public void setInsOutpatientTimesYear(Integer insOutpatientTimesYear) {
        this.insOutpatientTimesYear = insOutpatientTimesYear;
    }
}
