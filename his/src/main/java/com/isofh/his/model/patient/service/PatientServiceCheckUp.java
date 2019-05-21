package com.isofh.his.model.patient.service;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.patient.info.*;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_service_check_up")
public class PatientServiceCheckUp extends BaseModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private PatientInvoiceLine patientInvoiceLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_history_id")
    private PatientHistory patientHistory;

    // CD vao vien
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_in_hospital_diag_id", unique = true, updatable = false)
    private PatientInHospitalDiag patientInHospitalDiag;

    // CD benh
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_diag_id", unique = true, updatable = false)
    private PatientDiag patientDiag;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_vital_sign_id", unique = true, updatable = false)
    private PatientVitalSign patientVitalSign;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_medical_history_id", unique = true, updatable = false)
    private PatientMedicalHistory medicalHistory;

    @Column(name = "body")
    @Audited
    private String body;

    @Column(name = "respiration")
    @Audited
    private String respiration;

    @Column(name = "circulation")
    @Audited
    private String circulation;

    @Column(name = "ear_nose_throat")
    @Audited
    private String earNoseThroat;

    @Column(name = "musculoskel")
    @Audited
    private String musculoskel;

    @Column(name = "dentomaxillofacial")
    @Audited
    private String dentomaxillofacial;

    @Column(name = "urination")
    @Audited
    private String urination;

    @Column(name = "eye")
    @Audited
    private String eye;

    @Column(name = "digestion")
    @Audited
    private String digestion;

    @Column(name = "endocrine")
    @Audited
    private String endocrine;

    @Column(name = "nerve")
    @Audited
    private String nerve;

    @Column(name = "other")
    @Audited
    private String other;

    @Column(name = "medicine_document")
    @Audited
    private String medicineDocument;

    @Column(name = "conclusion")
    @Audited
    private String conclusion;

    @Column(name = "subclinical_result_summary")
    @Audited
    private String subclinicalResultSummary;

    @Column(name = "doctor_advice")
    @Audited
    private String doctorAdvice;

    @Column(name = "note")
    @Audited
    private String note;

    @Column(name = "treatment_direction")
    @Audited
    private Integer treatmentDirection;

    @Column(name = "treatment_result")
    @Audited
    private Integer treatmentResult;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public PatientInvoiceLine getPatientInvoiceLine() {
        return patientInvoiceLine;
    }

    public void setPatientInvoiceLine(PatientInvoiceLine patientInvoiceLine) {
        this.patientInvoiceLine = patientInvoiceLine;
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

    public PatientVitalSign getPatientVitalSign() {
        return patientVitalSign;
    }

    public void setPatientVitalSign(PatientVitalSign patientVitalSign) {
        this.patientVitalSign = patientVitalSign;
    }

    public PatientMedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(PatientMedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getCirculation() {
        return circulation;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }

    public String getEarNoseThroat() {
        return earNoseThroat;
    }

    public void setEarNoseThroat(String earNoseThroat) {
        this.earNoseThroat = earNoseThroat;
    }

    public String getMusculoskel() {
        return musculoskel;
    }

    public void setMusculoskel(String musculoskel) {
        this.musculoskel = musculoskel;
    }

    public String getDentomaxillofacial() {
        return dentomaxillofacial;
    }

    public void setDentomaxillofacial(String dentomaxillofacial) {
        this.dentomaxillofacial = dentomaxillofacial;
    }

    public String getUrination() {
        return urination;
    }

    public void setUrination(String urination) {
        this.urination = urination;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getDigestion() {
        return digestion;
    }

    public void setDigestion(String digestion) {
        this.digestion = digestion;
    }

    public String getEndocrine() {
        return endocrine;
    }

    public void setEndocrine(String endocrine) {
        this.endocrine = endocrine;
    }

    public String getNerve() {
        return nerve;
    }

    public void setNerve(String nerve) {
        this.nerve = nerve;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMedicineDocument() {
        return medicineDocument;
    }

    public void setMedicineDocument(String medicineDocument) {
        this.medicineDocument = medicineDocument;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getSubclinicalResultSummary() {
        return subclinicalResultSummary;
    }

    public void setSubclinicalResultSummary(String subclinicalResultSummary) {
        this.subclinicalResultSummary = subclinicalResultSummary;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
