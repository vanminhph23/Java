package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.patient.BasePatientModel;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_transfer_department")
@Where(clause = "deleted=0")
public class PatientTransferDepartment extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_transfer_department_generator")
    @SequenceGenerator(
            name = "patient_transfer_department_generator",
            sequenceName = "patient_transfer_department_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}