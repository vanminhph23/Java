package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.model.core.ReferenceListAccess;

import java.util.List;

public class ReferenceListDto extends BaseDto {

    public ReferenceListDto() {
    }

    private int value;

    private String name;

    private ReferenceDto referenceDto;

    private Long referenceId;

    private String description;

    private boolean strictAccess;

    private List<ReferenceListAccess> referenceListAccesses;

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

    public ReferenceDto getReferenceDto() {
        return referenceDto;
    }

    public void setReferenceDto(ReferenceDto referenceDto) {
        this.referenceDto = referenceDto;
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

    public List<ReferenceListAccess> getReferenceListAccesses() {
        return referenceListAccesses;
    }

    public void setReferenceListAccesses(List<ReferenceListAccess> referenceListAccesses) {
        this.referenceListAccesses = referenceListAccesses;
    }
}
