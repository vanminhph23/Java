package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientServiceModel;
import com.isofh.his.model.category.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_patient_history")
public class PatientHistory extends BasePatientServiceModel {
    @Id
    @GeneratedValue(generator = "patient_history_generator")
    @SequenceGenerator(
            name = "patient_history_generator",
            sequenceName = "patient_history_sq",
            initialValue = 1000000
    )
    private Long id;

    // common info
    @Column(name = "reg_date")
    @Audited
    private Timestamp regDate;

    @Column(name = "time_go_in")
    @Audited
    private Timestamp timeGoIn;

    @Column(name = "time_go_out")
    @Audited
    private Timestamp timeGoOut;

    @Column(name = "age")
    @Audited
    private int age;

    @Column(name = "birthday")
    @Audited
    private Timestamp birthday;

    @Column(name = "only_year_birth")
    @Audited
    private boolean onlyYearBirth;

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

    @Column(name = "guardian_id")
    @Audited
    private Long guardianId;

    @ManyToOne
    @JoinColumn(name = "guardian_id", insertable = false, updatable = false)
    private Guardian guardian;

    @Column(name = "job_id")
    @Audited
    private Long jobId;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @Column(name = "medical_record_type_id")
    @Audited
    private Long medicalRecordTypeId;

    @ManyToOne
    @JoinColumn(name = "medical_record_type_id", insertable = false, updatable = false)
    private MedicalRecordType medicalRecordType;

    @Column(name = "nationality_id")
    @Audited
    private Long nationalityId;

    @ManyToOne
    @JoinColumn(name = "nationality_id", insertable = false, updatable = false)
    private Country nationality;

    @Column(name = "nation_id")
    @Audited
    private Long nationId;

    @ManyToOne
    @JoinColumn(name = "nation_id", insertable = false, updatable = false)
    private Ethnicity nation;

    @Column(name = "patient_type")
    @Audited
    private int patientType;

    @Column(name = "advance_payment")
    @Audited
    private boolean advancePayment;

    // disease
    @Column(name = "height")
    @Audited
    private int height;

    @Column(name = "weight")
    @Audited
    private int weight;

    @Column(name = "blood_pressure")
    @Audited
    private int bloodPressure;

    @Column(name = "temperature")
    @Audited
    private int temperature;

    @Column(name = "spo2")
    @Audited
    private int spo2;

    @Column(name = "pulse")
    @Audited
    private int pulse;

    @Column(name = "check_up_breath")
    @Audited
    private int checkUpBreath;

    @Column(name = "blood_type")
    @Audited
    private int bloodType;

    @Column(name = "anamnesis")
    @Audited
    private String anamnesis;

    @Column(name = "anamnesis_family")
    @Audited
    private String anamnesisFamily;

    @Column(name = "treatment_details")
    @Audited
    private String treatmentDetails;

    @Column(name = "treatment_direction")
    @Audited
    private int treatmentDirection;

    @Column(name = "treatment_result")
    @Audited
    private int treatmentResult;

    @Column(name = "hospital_record")
    @Audited
    private int hospitalRecord;

    @Column(name = "first_diagnostic")
    @Audited
    private String firstDiagnostic;

    @Column(name = "discharge_diagnostic")
    @Audited
    private String dischargeDiagnostic;

    @Column(name = "in_hospital_diag_disease")
    @Audited
    private String inHospitalDiagDisease;

    @Column(name = "patient_state")
    @Audited
    private int patientState;

    // ICD, separate ID by ','
    @Column(name = "discharge_diag_disease")
    @Audited
    private String dischargeDiagDisease;

    @Column(name = "other_discharge_diag_disease")
    @Audited
    private String otherDischargeDiagDisease;

    @Column(name = "prev_diagnostic")
    @Audited
    private String prevDiagnostic;

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

    @ManyToOne
    @JoinColumn(name = "assurance_reg_at_hospital_id", insertable = false, updatable = false)
    private Hospital assuranceRegAtHospital;

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

    //Out hospital
    @Column(name = "discharge_type")
    @Audited
    private int discharge_type;

    @Column(name = "transfer_from_department_id")
    @Audited
    private Long transferFromDepartmentId;

    @ManyToOne
    @JoinColumn(name = "transfer_from_department_id", insertable = false, updatable = false)
    private Department transferFromDepartment;

    @Column(name = "transfer_to_department_id")
    @Audited
    private Long transferToDepartmentId;

    @ManyToOne
    @JoinColumn(name = "transfer_to_department_id", insertable = false, updatable = false)
    private Department transferToDepartment;

    @Column(name = "ph_collection_id")
    @Audited
    private Long phCollectionId;

    @ManyToOne
    @JoinColumn(name = "ph_collection_id", insertable = false, updatable = false)
    private PHCollection phCollection;

    // KSK
    @Column(name = "contract")
    @Audited
    private boolean contract;

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
