package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_group_level3", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class ServiceGroupLevel3 extends BaseCategoryModel {
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

    @Column(name = "service_group_level2_id", nullable = false)
    @Audited
    private Long serviceGroupLevel2Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_group_level2_id", insertable = false, updatable = false)
    private ServiceGroupLevel2 serviceGroupLevel2;

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

    public Long getServiceGroupLevel2Id() {
        return serviceGroupLevel2Id;
    }

    public void setServiceGroupLevel2Id(Long serviceGroupLevel2Id) {
        this.serviceGroupLevel2Id = serviceGroupLevel2Id;
    }

    public ServiceGroupLevel2 getServiceGroupLevel2() {
        return serviceGroupLevel2;
    }

    public void setServiceGroupLevel2(ServiceGroupLevel2 serviceGroupLevel2) {
        this.serviceGroupLevel2 = serviceGroupLevel2;
    }
}
