package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.model.category.Country;

import java.util.List;

public class ProvinceDto extends BaseCategoryDto {

    public ProvinceDto() {
    }

    private Long countryId;

    private Country country;

    private String acronym;

    private List<DistrictDto> districtDtos;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<DistrictDto> getDistrictDtos() {
        return districtDtos;
    }

    public void setDistrictDtos(List<DistrictDto> districtDtos) {
        this.districtDtos = districtDtos;
    }
}
