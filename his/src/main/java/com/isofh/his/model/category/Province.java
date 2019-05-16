package com.isofh.his.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_province", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class Province extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "province_generator")
    @SequenceGenerator(
            name = "province_generator",
            sequenceName = "province_sq",
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

    @Column(name = "country_id", nullable = false)
    @Audited
    private Long countryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "acronym")
    @Audited
    private String acronym;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private List<District> districts;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
