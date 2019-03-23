package com.isofh.his.model.base;

import javax.persistence.Column;

public abstract class Base2Model extends BaseModel {

    @Column(name = "value", nullable = false, unique = true)
    private String value;

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}