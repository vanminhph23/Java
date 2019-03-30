package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_patient")
public class Patient extends BasePatientModel {
    @Id
    @GeneratedValue(generator = "patient_generator")
    @SequenceGenerator(
            name = "patient_generator",
            sequenceName = "patient_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "id_no", unique = true)
    @Audited
    private String idNo;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "address")
    @Audited
    private String address;

    @Column(name = "assurance_number")
    @Audited
    private String assuranceNumber;

    @Column(name = "birthday")
    @Audited
    private Timestamp birthday;

    @Column(name = "gender")
    @Audited
    private int gender;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
