package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;

@Entity
@Table(name = "his_position")
public class Position extends Base2Model {
    @Id
    @GeneratedValue(generator = "position_generator")
    @SequenceGenerator(
            name = "position_generator",
            sequenceName = "position_sq",
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
