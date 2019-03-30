package com.isofh.his.model;

import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_zone")
public class Zone extends Base2Model {
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

    @Column(name = "district_id")
    @Audited
    private Long districtId;

    @ManyToOne
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private District district;

    @Column(name = "acronym")
    @Audited
    private String acronym;
}
