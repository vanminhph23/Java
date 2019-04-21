package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;

public class ReferenceDto extends BaseCategoryDto {

    public ReferenceDto() {
    }

    private List<ReferenceListDto> referenceListDtos;

    private String description;

    public List<ReferenceListDto> getReferenceListDtos() {
        return referenceListDtos;
    }

    public void setReferenceListDtos(List<ReferenceListDto> referenceListDtos) {
        this.referenceListDtos = referenceListDtos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
