package com.isofh.his.model.patient;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.category.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_patient_history")
public class PatientHistory extends BaseModel {
    @Id
    @GeneratedValue(generator = "patient_history_generator")
    @SequenceGenerator(
            name = "patient_history_generator",
            sequenceName = "patient_history_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_value", nullable = false, unique = true)
    @Audited
    private String patientValue;

    @Column(name = "patient_name", nullable = false)
    @Audited
    private String patientName;

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

    @OneToOne
    @JoinColumn(name = "patient_address_id", insertable = false, updatable = false)
    private PatientAddress patientAddress;

    @Column(name = "patient_address_id")
    @Audited
    private Long patientAddressId;

    @Column(name = "patient_guardian_id", unique = true)
    @Audited
    private Long patientGuardianId;

    @ManyToOne
    @JoinColumn(name = "patient_guardian_id", insertable = false, updatable = false)
    private PatientGuardian patientGuardian;

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
    @Column(name = "blood_type")
    @Audited
    private int bloodType;

    @Column(name = "patient_medical_history_id", unique = true)
    @Audited
    private Long medicalHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_medical_history_id", insertable = false, updatable = false)
    private PatientMedicalHistory medicalHistory;

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

    // disease
    @Column(name = "patient_in_hospital_diag_id", unique = true)
    @Audited
    private PatientInHospitalDiag patientInHospitalDiagId;

    @Column(name = "patient_in_hospital_diag_id", insertable = false, updatable = false)
    @Audited
    private Long patientDiagnosticId;

    @OneToOne
    @JoinColumn(name = "patient_diag_id", insertable = false, updatable = false)
    private PatientDiag patientDiag;

    @Column(name = "patient_diag_id", unique = true)
    @Audited
    private Long patientDiagId;

    @OneToOne
    @JoinColumn(name = "patient_diagnostic_id", insertable = false, updatable = false)
    private PatientDiag patientDiagnostic;

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
    @Column(name = "patient_contract_id")
    @Audited
    private Long patientContractId;

    @ManyToOne
    @JoinColumn(name = "patient_contract_id", insertable = false, updatable = false)
    private PatientContract patientContract;

    // iSofHCare
    @Column(name = "patient_online_id")
    @Audited
    private Long patientOnlineId;

    @ManyToOne
    @JoinColumn(name = "patient_online_id", insertable = false, updatable = false)
    private PatientOnline patientOnline;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
