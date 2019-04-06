package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "his_uom")
public class UOM extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "uom_generator")
    @SequenceGenerator(
            name = "uom_generator",
            sequenceName = "uom_sq",
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
