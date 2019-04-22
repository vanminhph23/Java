package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;

public class ReferenceDto extends BaseCategoryDto {

    public ReferenceDto() {
    }

    private List<ReferenceListDto> referenceLists;

    private String description;

    public List<ReferenceListDto> getReferenceLists() {
        return referenceLists;
    }

    public void setReferenceLists(List<ReferenceListDto> referenceLists) {
        this.referenceLists = referenceLists;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
