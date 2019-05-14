package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.category.*;
import com.isofh.his.service.patient.PatientStatistics;
import com.isofh.his.util.DateUtil;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient_history",
        indexes = {@Index(name = "idx_ph_reg_date", columnList = "reg_date")})
public class PatientHistory extends BaseModel {
    @Id
    @GeneratedValue(generator = "patient_history_generator")
    @SequenceGenerator(
            name = "patient_history_generator",
            sequenceName = "patient_history_sq",
            initialValue = 1000000
    )
    private Long id;

    // common info
    @Column(name = "patient_value", nullable = false)
    @Audited
    private String patientValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @Audited
    private Patient patient;

    @Column(name = "patient_name", length = 7, unique = true)
    @Audited
    private String patientName;

    @Column(name = "medical_record_no", length = 7, unique = true)
    @Audited
    private String medicalRecordNo;

    @Column(name = "patient_document", nullable = false, length = 10, unique = true)
    @Audited
    private String patientDocument;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient = false;

    @Column(name = "reg_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date regDate;

    @Column(name = "time_go_in")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date timeGoIn;

    @Column(name = "time_go_out")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date timeGoOut;

    @Column(name = "birthday")
    @Audited
    private Date birthday;

    @Column(name = "only_year_birth")
    @Audited
    private boolean onlyYearBirth;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "gender", nullable = false)
    @Audited
    private Integer gender;

    @Column(name = "department_id", nullable = false)
    @Audited
    private Long departmentId;

    @Column(name = "job_id")
    @Audited
    private Long jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;

    @Column(name = "medical_record_type_id")
    @Audited
    private Long medicalRecordTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_type_id", insertable = false, updatable = false)
    private MedicalRecordType medicalRecordType;

    @Column(name = "nationality_id")
    @Audited
    private Long nationalityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id", insertable = false, updatable = false)
    private Country nationality;

    @Column(name = "ethnicity_id")
    @Audited
    private Long ethnicityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ethnicity_id", insertable = false, updatable = false)
    private Ethnicity ethnicity;

    @Column(name = "advance_payment")
    @Audited
    private boolean advancePayment;

    @Column(name = "blood_type")
    @Audited
    private Integer bloodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "patient_in_hospital")
    @Audited
    private boolean patientInHospital = true;

    //Out hospital
    @Column(name = "discharge_type")
    @Audited
    private Integer discharge_type;

    @Column(name = "treatment_details")
    @Audited
    private String treatmentDetails;

    @Column(name = "treatment_direction")
    @Audited
    private Integer treatmentDirection;

    @Column(name = "treatment_result")
    @Audited
    private Integer treatmentResult;

    @Column(name = "patient_state")
    @Audited
    private Integer patientState;

    @Column(name = "transfer_from_department_id")
    @Audited
    private Long transferFromDepartmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_from_department_id", insertable = false, updatable = false)
    private Department transferFromDepartment;

    @Column(name = "transfer_to_department_id")
    @Audited
    private Long transferToDepartmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_to_department_id", insertable = false, updatable = false)
    private Department transferToDepartment;

    @Column(name = "ph_collection_id", insertable = false, updatable = false)
    @Audited
    private Long phCollectionId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_history_collection_id")
    private PatientHistoryCollection patientHistoryCollection;

    // insurance info
    @Column(name = "patient_type", nullable = false)
    @Audited
    private Integer patientType;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_address_id", unique = true, updatable = false)
    private PatientAddress patientAddress;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_insurance_id", unique = true, updatable = false)
    private PatientInsurance patientInsurance;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_medical_history_id", unique = true, updatable = false)
    private PatientMedicalHistory medicalHistory;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_vital_sign_id", unique = true, updatable = false)
    private PatientVitalSign patientVitalSign;

    // CD vao vien
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_in_hospital_diag_id", unique = true, updatable = false)
    private PatientInHospitalDiag patientInHospitalDiag;

    // CD benh
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_diag_id", unique = true, updatable = false)
    private PatientDiag patientDiag;

    // Nguoi bao lanh
    @OneToOne(mappedBy = "patientHistory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private PatientGuardian patientGuardian;

    // Nguoi bao lanh
    @OneToOne(mappedBy = "patientHistory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private PatientStatistics patientStatistics;

    // KSK
    @OneToOne(mappedBy = "patientHistory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private PatientContract patientContract;

    @Column(name = "contract")
    @Audited
    private boolean contract;

    // iSofHCare
    @OneToOne(mappedBy = "patientHistory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private PatientOnline patientOnline;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getTimeGoIn() {
        return timeGoIn;
    }

    public void setTimeGoIn(Date timeGoIn) {
        this.timeGoIn = timeGoIn;
    }

    public Date getTimeGoOut() {
        return timeGoOut;
    }

    public void setTimeGoOut(Date timeGoOut) {
        this.timeGoOut = timeGoOut;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isOnlyYearBirth() {
        return onlyYearBirth;
    }

    public void setOnlyYearBirth(boolean onlyYearBirth) {
        this.onlyYearBirth = onlyYearBirth;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Long getMedicalRecordTypeId() {
        return medicalRecordTypeId;
    }

    public void setMedicalRecordTypeId(Long medicalRecordTypeId) {
        this.medicalRecordTypeId = medicalRecordTypeId;
    }

    public MedicalRecordType getMedicalRecordType() {
        return medicalRecordType;
    }

    public void setMedicalRecordType(MedicalRecordType medicalRecordType) {
        this.medicalRecordType = medicalRecordType;
    }

    public Long getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Long nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Long getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Long ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public boolean isAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(boolean advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getDischarge_type() {
        return discharge_type;
    }

    public void setDischarge_type(Integer discharge_type) {
        this.discharge_type = discharge_type;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public Integer getTreatmentDirection() {
        return treatmentDirection;
    }

    public void setTreatmentDirection(Integer treatmentDirection) {
        this.treatmentDirection = treatmentDirection;
    }

    public Integer getTreatmentResult() {
        return treatmentResult;
    }

    public void setTreatmentResult(Integer treatmentResult) {
        this.treatmentResult = treatmentResult;
    }

    public Integer getPatientState() {
        return patientState;
    }

    public void setPatientState(Integer patientState) {
        this.patientState = patientState;
    }

    public Long getTransferFromDepartmentId() {
        return transferFromDepartmentId;
    }

    public void setTransferFromDepartmentId(Long transferFromDepartmentId) {
        this.transferFromDepartmentId = transferFromDepartmentId;
    }

    public Department getTransferFromDepartment() {
        return transferFromDepartment;
    }

    public void setTransferFromDepartment(Department transferFromDepartment) {
        this.transferFromDepartment = transferFromDepartment;
    }

    public Long getTransferToDepartmentId() {
        return transferToDepartmentId;
    }

    public void setTransferToDepartmentId(Long transferToDepartmentId) {
        this.transferToDepartmentId = transferToDepartmentId;
    }

    public Department getTransferToDepartment() {
        return transferToDepartment;
    }

    public void setTransferToDepartment(Department transferToDepartment) {
        this.transferToDepartment = transferToDepartment;
    }

    public Long getPhCollectionId() {
        return phCollectionId;
    }

    public void setPhCollectionId(Long phCollectionId) {
        this.phCollectionId = phCollectionId;
    }

    public PatientHistoryCollection getPatientHistoryCollection() {
        return patientHistoryCollection;
    }

    public void setPatientHistoryCollection(PatientHistoryCollection patientHistoryCollection) {
        this.patientHistoryCollection = patientHistoryCollection;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public PatientAddress getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(PatientAddress patientAddress) {
        this.patientAddress = patientAddress;
    }

    public PatientInsurance getPatientInsurance() {
        return patientInsurance;
    }

    public void setPatientInsurance(PatientInsurance patientInsurance) {
        this.patientInsurance = patientInsurance;
    }

    public PatientMedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(PatientMedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public PatientVitalSign getPatientVitalSign() {
        return patientVitalSign;
    }

    public void setPatientVitalSign(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = patientVitalSign;
    }

    public PatientInHospitalDiag getPatientInHospitalDiag() {
        return patientInHospitalDiag;
    }

    public void setPatientInHospitalDiag(PatientInHospitalDiag patientInHospitalDiag) {
        this.patientInHospitalDiag = patientInHospitalDiag;
    }

    public PatientDiag getPatientDiag() {
        return patientDiag;
    }

    public void setPatientDiag(PatientDiag patientDiag) {
        this.patientDiag = patientDiag;
    }

    public PatientGuardian getPatientGuardian() {
        return patientGuardian;
    }

    public void setPatientGuardian(PatientGuardian patientGuardian) {
        this.patientGuardian = patientGuardian;
    }

    public PatientStatistics getPatientStatistics() {
        return patientStatistics;
    }

    public void setPatientStatistics(PatientStatistics patientStatistics) {
        this.patientStatistics = patientStatistics;
    }

    public PatientContract getPatientContract() {
        return patientContract;
    }

    public void setPatientContract(PatientContract patientContract) {
        this.patientContract = patientContract;
    }

    public PatientOnline getPatientOnline() {
        return patientOnline;
    }

    public void setPatientOnline(PatientOnline patientOnline) {
        this.patientOnline = patientOnline;
    }

    public boolean isPatientInHospital() {
        return patientInHospital;
    }

    public void setPatientInHospital(boolean patientInHospital) {
        this.patientInHospital = patientInHospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getBirthdayStr() {
        return isOnlyYearBirth() ? DateUtil.formatYear(getBirthday()) : DateUtil.formatDate(getBirthday());
    }
}
