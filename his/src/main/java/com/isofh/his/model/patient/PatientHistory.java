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

    @Column(name = "medical_record_no", nullable = false, length = 7, unique = true)
    @Audited
    private String medicalRecordNo;

    @Column(name = "patient_document", nullable = false, length = 10, unique = true)
    @Audited
    private String patientDocument;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient = false;

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

    @Column(name = "address")
    @Audited
    private String address;

    @Column(name = "patient_guardian_id", unique = true)
    @Audited
    private Long patientGuardianId;

    @OneToOne
    @JoinColumn(name = "patient_guardian_id", insertable = false, updatable = false)
    private PatientGuardian patientGuardian;

    @OneToOne
    @JoinColumn(name = "patient_address_id", insertable = false, updatable = false)
    private PatientAddress patientAddress;

    @Column(name = "patient_address_id")
    @Audited
    private Long patientAddressId;

    @ManyToOne
    @JoinColumn(name = "guardian_id", insertable = false, updatable = false)
    private PatientGuardian guardian;

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

    @Column(name = "ethnicity_id")
    @Audited
    private Long ethnicityId;

    @ManyToOne
    @JoinColumn(name = "ethnicity_id", insertable = false, updatable = false)
    private Ethnicity ethnicity;

    @Column(name = "advance_payment")
    @Audited
    private boolean advancePayment;

    @Column(name = "patient_vital_sign_id", unique = true)
    @Audited
    private Long patientVitalSignId;

    @OneToOne
    @JoinColumn(name = "patient_vital_sign_id", insertable = false, updatable = false)
    private PatientVitalSign patientVitalSign;

    // common info
    @Column(name = "height")
    @Audited
    private int height;

    @Column(name = "weight")
    @Audited
    private int weight;

    @Column(name = "blood_type")
    @Audited
    private int bloodType;

    @Column(name = "anamnesis")
    @Audited
    private String anamnesis;

    @Column(name = "anamnesis_family")
    @Audited
    private String anamnesisFamily;

    @Column(name = "hospital_record")
    @Audited
    private int hospitalRecord;

    // patient type
    @Column(name = "patient_type")
    @Audited
    private int patientType;

    // insurance info
    @Column(name = "patient_insurance_id", unique = true)
    @Audited
    private Long patientInsuranceId;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id", insertable = false, updatable = false)
    private PatientInsurance patientInsurance;

    // in hospital disease
    @Column(name = "first_diagnostic")
    @Audited
    private String firstDiagnostic;

    @Column(name = "in_hospital_diag_disease")
    @Audited
    private String inHospitalDiagDisease;

    @Column(name = "prev_diagnostic")
    @Audited
    private String prevDiagnostic;

    //Out hospital
    @Column(name = "discharge_type")
    @Audited
    private int discharge_type;

    @Column(name = "treatment_details")
    @Audited
    private String treatmentDetails;

    @Column(name = "treatment_direction")
    @Audited
    private int treatmentDirection;

    @Column(name = "treatment_result")
    @Audited
    private int treatmentResult;

    @Column(name = "discharge_diagnostic")
    @Audited
    private String dischargeDiagnostic;

    // ICD, separate ID by ','
    @Column(name = "discharge_diag_disease")
    @Audited
    private String dischargeDiagDisease;

    @Column(name = "other_discharge_diag_disease")
    @Audited
    private String otherDischargeDiagDisease;

    @Column(name = "patient_state")
    @Audited
    private int patientState;

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
