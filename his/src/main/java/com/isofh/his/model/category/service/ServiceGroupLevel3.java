package com.isofh.his.model.category.service;

import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_group_level3")
public class ServiceGroupLevel3 extends Base2Model {
    @Id
    @GeneratedValue(generator = "service_group_level3_generator")
    @SequenceGenerator(
            name = "service_group_level3_generator",
            sequenceName = "service_group_level3_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

    @Column(name = "service_group_level2_id")
    @Audited
    private Long serviceGroupLevel2Id;

    @ManyToOne
    @JoinColumn(name = "service_group_level2_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel2;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
