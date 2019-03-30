package com.isofh.his.model.category;

import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_hospital")
public class Hospital extends Base2Model {
    @Id
    @GeneratedValue(generator = "hospital_generator")
    @SequenceGenerator(
            name = "hospital_generator",
            sequenceName = "hospital_sq",
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

    @Column(name = "level")
    private int level;

    @Column(name = "rank")
    private int rank;

    @Column(name = "address")
    private int address;

    @Column(name = "note")
    private int note;
}
