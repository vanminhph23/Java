package com.isofh.his.dto.category.service;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ServiceDetailDto extends BaseCategoryDto {

    public ServiceDetailDto() {
    }

    private String linkValue;

    private Long serviceId;

    private Double lowIndicator;

    private Double highIndicator;

    private Double maleLowIndicator;

    private Double maleHighIndicator;

    private Double femaleLowIndicator;

    private Double femaleHighIndicator;

    private String normalRange;

    private String unit;

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
