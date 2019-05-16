package com.isofh.his.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_district", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class District extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "district_generator")
    @SequenceGenerator(
            name = "district_generator",
            sequenceName = "district_sq",
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

    @Column(name = "province_id", nullable = false)
    @Audited
    private Long provinceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province province;

    @Column(name = "acronym")
    @Audited
    private String acronym;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private List<Zone> zones;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}
