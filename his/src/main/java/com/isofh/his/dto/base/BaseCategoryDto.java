package com.isofh.his.dto.base;

public abstract class BaseCategoryDto extends BaseDto {

    private String value;

    private String name;

    public BaseCategoryDto() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
