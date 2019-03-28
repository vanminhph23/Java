package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;

@Entity
@Table(name = "his_specialist")
public class Specialist extends Base2Model {
    @Id
    @GeneratedValue(generator = "specialist_generator")
    @SequenceGenerator(
            name = "specialist_generator",
            sequenceName = "specialist_sq",
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
