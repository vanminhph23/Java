package com.isofh.his.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_country")
@Audited
public class Country extends BaseCategoryModel {
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

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}
