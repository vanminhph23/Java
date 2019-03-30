package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import com.isofh.his.model.category.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_patient_history")
public class PatientHistory extends BasePatientModel {
    @Id
    @GeneratedValue(generator = "patient_history_generator")
    @SequenceGenerator(
            name = "patient_history_generator",
            sequenceName = "patient_history_sq",
            initialValue = 1000000
    )
    private Long id;

    // common info
    @Column(name = "age")
    @Audited
    private int age;

    @Column(name = "birthday")
    @Audited
    private Timestamp birthday;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "gender")
    @Audited
    private int gender;

    @Column(name = "department_id", nullable = false)
    @Audited
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "country_id")
    @Audited
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "province_id")
    @Audited
    private Long provinceId;

    @ManyToOne
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province province;

    @Column(name = "district_id")
    @Audited
    private Long districtId;

    @ManyToOne
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private District district;

    @Column(name = "zone_id")
    @Audited
    private Long zoneId;

    @ManyToOne
    @JoinColumn(name = "zone_id", insertable = false, updatable = false)
    private Zone zone;

    @Column(name = "detail_address")
    @Audited
    private String detailAddress;

    @Column(name = "address")
    @Audited
    private String address;

    // disease
    @Column(name = "blood_type")
    @Audited
    private int bloodType;

    @Column(name = "blood_pressure")
    @Audited
    private int bloodPressure;

    @Column(name = "check_up_breath")
    @Audited
    private int checkUpBreath;

    @Column(name = "anamnesis")
    @Audited
    private String anamnesis;

    @Column(name = "anamnesis_family")
    @Audited
    private String anamnesisFamily;

    // ICD, separate ID by ','
    @Column(name = "discharge_diag_disease")
    @Audited
    private String dischargeDiagDisease;

    @Column(name = "discharge_diagnostic")
    @Audited
    private String dischargeDiagnostic;

    // assurance info
    @Column(name = "assurance_address")
    @Audited
    private String assuranceAddress;

    @Column(name = "assurance_from_date")
    @Audited
    private Timestamp assuranceFromDate;

    @Column(name = "assurance_to_date")
    @Audited
    private Timestamp assuranceToDate;

    @Column(name = "assurance_number", length = 15)
    @Audited
    private String assuranceNumber;

    @Column(name = "assurance_percent")
    @Audited
    private int assurancePercent;

    @Column(name = "assurance_reg_at_hospital_id")
    @Audited
    private int assuranceRegAtHospitalId;

    // iSofHCare
    @Column(name = "account_online")
    @Audited
    private String accountOnline;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
