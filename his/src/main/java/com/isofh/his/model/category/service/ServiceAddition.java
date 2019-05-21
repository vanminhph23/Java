package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.Room;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_addition")
public class ServiceAddition extends BaseCategoryModel {

    @Id
    @GeneratedValue(generator = "service_addition_generator")
    @SequenceGenerator(
            name = "service_addition_generator",
            sequenceName = "service_addition_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_id", nullable = false)
    @Audited
    private Long serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceSource service;

    @Column(name = "addition_service_id", nullable = false)
    @Audited
    private Long additionServiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addition_service_id", insertable = false, updatable = false)
    private ServiceSource additionService;

    @Column(name = "quantity")
    @Audited
    private Double quantity;

    @Column(name = "not_counted")
    @Audited
    private Boolean notCounted;

    @Column(name = "service_used")
    @Audited
    private Boolean serviceUsed;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
