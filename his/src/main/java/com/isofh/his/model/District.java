package com.isofh.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_district")
public class District extends Base2Model {
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

    @Column(name = "province_id")
    @Audited
    private Long provinceId;

    @ManyToOne
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province province;

    @Column(name = "acronym")
    @Audited
    private String acronym;

    @JsonIgnore
    @OneToMany(mappedBy = "district")
    private List<Zone> zones;
}
