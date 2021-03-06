package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_group_level1", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Where(clause = "deleted=0")
public class ServiceGroupLevel1 extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "service_group_level1_generator")
    @SequenceGenerator(
            name = "service_group_level1_generator",
            sequenceName = "service_group_level1_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

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

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
}
