package com.isofh.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_province")
public class Province extends Base2Model {
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

    @Column(name = "country_id")
    @Audited
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "acronym")
    @Audited
    private String acronym;

    @JsonIgnore
    @OneToMany(mappedBy = "province")
    private List<District> districts;
}
