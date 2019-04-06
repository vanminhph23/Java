package com.isofh.his.model.base;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseCategoryModel extends BaseModel {

    @Column(name = "value", nullable = false)
    @Audited
    private String value;

    @Column(name = "name", nullable = false)
    @Audited
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