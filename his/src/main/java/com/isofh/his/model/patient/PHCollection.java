package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_ph_collection")
public class PHCollection extends BasePatientModel {
    @Id
    @GeneratedValue(generator = "ph_collection_generator")
    @SequenceGenerator(
            name = "ph_collection_generator",
            sequenceName = "ph_collection_sq",
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

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
