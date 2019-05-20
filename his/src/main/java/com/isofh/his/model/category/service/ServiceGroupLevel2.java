package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_group_level2", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class ServiceGroupLevel2 extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "service_group_level2_generator")
    @SequenceGenerator(
            name = "service_group_level2_generator",
            sequenceName = "service_group_level2_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "service_group_level1_id", nullable = false)
    @Audited
    private Long serviceGroupLevel1Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_group_level1_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel1;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getServiceGroupLevel1Id() {
        return serviceGroupLevel1Id;
    }

    public void setServiceGroupLevel1Id(Long serviceGroupLevel1Id) {
        this.serviceGroupLevel1Id = serviceGroupLevel1Id;
    }

    public ServiceGroupLevel1 getServiceGroupLevel1() {
        return serviceGroupLevel1;
    }

    public void setServiceGroupLevel1(ServiceGroupLevel1 serviceGroupLevel1) {
        this.serviceGroupLevel1 = serviceGroupLevel1;
    }
}
