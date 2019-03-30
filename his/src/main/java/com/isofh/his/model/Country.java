package com.isofh.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_country")
public class Country extends Base2Model {
    @Id
    @GeneratedValue(generator = "country_generator")
    @SequenceGenerator(
            name = "country_generator",
            sequenceName = "country_sq",
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

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Province> provinces;
}
