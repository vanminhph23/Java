package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseDto;

public class ReferenceListDto extends BaseDto {

    public ReferenceListDto() {
    }

    private int value;

    private String name;

    private Long referenceId;

    private String description;

    private boolean strictAccess;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStrictAccess() {
        return strictAccess;
    }

    public void setStrictAccess(boolean strictAccess) {
        this.strictAccess = strictAccess;
    }
}
