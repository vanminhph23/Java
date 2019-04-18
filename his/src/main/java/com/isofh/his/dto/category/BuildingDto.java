package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class BuildingDto extends BaseCategoryDto {

    public BuildingDto() {
    }

    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
