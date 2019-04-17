package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.model.category.District;

public class ZoneDto extends BaseCategoryDto {

    public ZoneDto() {
    }

    private Long districtId;

    private District district;

    private String acronym;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
