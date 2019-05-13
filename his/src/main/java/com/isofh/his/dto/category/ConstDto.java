package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;

public class ConstDto extends BaseCategoryDto {

    public ConstDto() {
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
