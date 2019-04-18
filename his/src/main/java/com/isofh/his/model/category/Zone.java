package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_zone", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class Zone extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "zone_generator")
    @SequenceGenerator(
            name = "zone_generator",
            sequenceName = "zone_sq",
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

    @Column(name = "district_id", nullable = false)
    @Audited
    private Long districtId;

    @ManyToOne
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private District district;

    @Column(name = "acronym")
    @Audited
    private String acronym;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
