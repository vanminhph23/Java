package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;

@Entity
@Table(name = "his_medical_record_type")
public class MedicalRecordType extends Base2Model {
    @Id
    @GeneratedValue(generator = "medical_record_type_generator")
    @SequenceGenerator(
            name = "medical_record_type_generator",
            sequenceName = "medical_record_type_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
