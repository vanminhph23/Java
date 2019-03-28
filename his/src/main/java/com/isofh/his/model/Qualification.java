package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;

@Entity
@Table(name = "his_qualification")
public class Qualification extends Base2Model {
    @Id
    @GeneratedValue(generator = "qualification_generator")
    @SequenceGenerator(
            name = "qualification_generator",
            sequenceName = "qualification_sq",
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
