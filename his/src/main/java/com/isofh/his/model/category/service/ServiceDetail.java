package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_service_detail")
public class ServiceDetail extends BaseCategoryModel {

    @Id
    @GeneratedValue(generator = "service_detail_generator")
    @SequenceGenerator(
            name = "service_detail_generator",
            sequenceName = "service_detail_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "link_value")
    @Audited
    private String linkValue;

    @Column(name = "service_id", nullable = false)
    @Audited
    private Long serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceSource service;

    @Column(name = "low_indicator")
    @Audited
    private Double lowIndicator;

    @Column(name = "high_indicator")
    @Audited
    private Double highIndicator;

    @Column(name = "male_low_indicator")
    @Audited
    private Double maleLowIndicator;

    @Column(name = "male_high_indicator")
    @Audited
    private Double maleHighIndicator;

    @Column(name = "female_low_indicator")
    @Audited
    private Double femaleLowIndicator;

    @Column(name = "female_high_indicator")
    @Audited
    private Double femaleHighIndicator;

    @Column(name = "normal_range")
    @Audited
    private String normalRange;

    @Column(name = "unit")
    @Audited
    private String unit;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
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

    public Double getLowIndicator() {
        return lowIndicator;
    }

    public void setLowIndicator(Double lowIndicator) {
        this.lowIndicator = lowIndicator;
    }

    public Double getHighIndicator() {
        return highIndicator;
    }

    public void setHighIndicator(Double highIndicator) {
        this.highIndicator = highIndicator;
    }

    public Double getMaleLowIndicator() {
        return maleLowIndicator;
    }

    public void setMaleLowIndicator(Double maleLowIndicator) {
        this.maleLowIndicator = maleLowIndicator;
    }

    public Double getMaleHighIndicator() {
        return maleHighIndicator;
    }

    public void setMaleHighIndicator(Double maleHighIndicator) {
        this.maleHighIndicator = maleHighIndicator;
    }

    public Double getFemaleLowIndicator() {
        return femaleLowIndicator;
    }

    public void setFemaleLowIndicator(Double femaleLowIndicator) {
        this.femaleLowIndicator = femaleLowIndicator;
    }

    public Double getFemaleHighIndicator() {
        return femaleHighIndicator;
    }

    public void setFemaleHighIndicator(Double femaleHighIndicator) {
        this.femaleHighIndicator = femaleHighIndicator;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
