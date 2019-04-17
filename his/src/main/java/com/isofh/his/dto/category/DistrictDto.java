package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.model.category.Province;

import java.util.List;

public class DistrictDto extends BaseCategoryDto {

    public DistrictDto() {
    }

    private Long provinceId;

    private Province province;

    private String acronym;

    private List<ZoneDto> zoneDtos;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<ZoneDto> getZoneDtos() {
        return zoneDtos;
    }

    public void setZoneDtos(List<ZoneDto> zoneDtos) {
        this.zoneDtos = zoneDtos;
    }
}
