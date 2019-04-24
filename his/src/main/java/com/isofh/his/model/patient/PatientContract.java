package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_contract")
public class PatientContract extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_contract_generator")
    @SequenceGenerator(
            name = "patient_contract_generator",
            sequenceName = "patient_contract_sq",
            initialValue = 1000000
    )
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_history_id")
    private PatientHistory patientHistory;

    @Column(name = "employee_value")
    @Audited
    private String employeeValue;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}