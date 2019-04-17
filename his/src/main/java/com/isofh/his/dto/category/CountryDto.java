package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;

public class CountryDto extends BaseCategoryDto {

    public CountryDto() {
    }

    private List<ProvinceDto> provinceDtos;

    public List<ProvinceDto> getProvinceDtos() {
        return provinceDtos;
    }

    public void setProvinceDtos(List<ProvinceDto> provinceDtos) {
        this.provinceDtos = provinceDtos;
    }
}
