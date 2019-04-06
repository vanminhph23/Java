package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "his_in_hospital_reason")
public class InHospitalReason extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "in_hospital_reason_generator")
    @SequenceGenerator(
            name = "in_hospital_reason_generator",
            sequenceName = "in_hospital_reason_sq",
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
