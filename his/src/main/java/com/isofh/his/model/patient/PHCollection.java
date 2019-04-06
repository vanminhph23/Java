package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientServiceModel;

import javax.persistence.*;

@Entity
@Table(name = "his_ph_collection")
public class PHCollection extends BasePatientServiceModel {
    @Id
    @GeneratedValue(generator = "ph_collection_generator")
    @SequenceGenerator(
            name = "ph_collection_generator",
            sequenceName = "ph_collection_sq",
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
