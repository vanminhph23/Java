package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "his_nation")
public class Nation extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "nation_generator")
    @SequenceGenerator(
            name = "nation_generator",
            sequenceName = "nation_sq",
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
