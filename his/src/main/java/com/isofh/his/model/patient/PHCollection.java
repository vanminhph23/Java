package com.isofh.his.model.patient;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_ph_collection")
public class PHCollection extends BaseModel {
    @Id
    @GeneratedValue(generator = "ph_collection_generator")
    @SequenceGenerator(
            name = "ph_collection_generator",
            sequenceName = "ph_collection_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "patient_value", nullable = false, unique = true)
    @Audited
    private String patientValue;

    @Column(name = "patient_name", nullable = false)
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

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
