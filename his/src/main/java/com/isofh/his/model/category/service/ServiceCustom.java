package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.Department;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_service_custom")
@Where(clause = "deleted=0")
public class ServiceCustom extends BaseCategoryModel {

    @Id
    @GeneratedValue(generator = "service_custom_generator")
    @SequenceGenerator(
            name = "service_custom_generator",
            sequenceName = "service_custom_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_id", nullable = false)
    @Audited
    private Long serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceSource service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_department_id")
    private Department fromDepartment;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date toDate;

    @Column(name = "not_counted", nullable = false)
    @Audited
    private boolean notCounted;

    @Column(name = "option", nullable = false)
    @Audited
    private boolean option;

    @Column(name = "base_unit_price")
    @Audited
    private Double baseUnitPrice;

    @Column(name = "service_unit_price")
    @Audited
    private Double serviceUnitPrice;

    @Column(name = "insurance_unit_price")
    @Audited
    private Double insuranceUnitPrice;

    @Column(name = "difference_unit_price")
    @Audited
    private Double differenceUnitPrice;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceSource getService() {
        return service;
    }

    public void setService(ServiceSource service) {
        this.service = service;
    }
}
