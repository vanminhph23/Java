package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_service_purpose")
@Where(clause = "deleted=0")
public class ServicePurpose extends BaseCategoryModel {

    @Id
    @GeneratedValue(generator = "service_purpose_generator")
    @SequenceGenerator(
            name = "service_purpose_generator",
            sequenceName = "service_purpose_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_id", nullable = false)
    @Audited
    private Long serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceSource service;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date toDate;

    @Column(name = "service_unit_price")
    @Audited
    private Double serviceUnitPrice;

    @Column(name = "insurance_unit_price")
    @Audited
    private Double insuranceUnitPrice;

    @Column(name = "difference_unit_price")
    @Audited
    private Double differenceUnitPrice;

    @Column(name = "note")
    @Audited
    private String note;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Double getServiceUnitPrice() {
        return serviceUnitPrice;
    }

    public void setServiceUnitPrice(Double serviceUnitPrice) {
        this.serviceUnitPrice = serviceUnitPrice;
    }

    public Double getInsuranceUnitPrice() {
        return insuranceUnitPrice;
    }

    public void setInsuranceUnitPrice(Double insuranceUnitPrice) {
        this.insuranceUnitPrice = insuranceUnitPrice;
    }

    public Double getDifferenceUnitPrice() {
        return differenceUnitPrice;
    }

    public void setDifferenceUnitPrice(Double differenceUnitPrice) {
        this.differenceUnitPrice = differenceUnitPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
