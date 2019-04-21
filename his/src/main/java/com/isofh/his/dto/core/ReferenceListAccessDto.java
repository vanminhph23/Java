package com.isofh.his.dto.core;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.dto.employee.PrivilegeDto;

public class ReferenceListAccessDto extends BaseDto {

    public ReferenceListAccessDto() {
    }

    private ReferenceListDto referenceListDto;

    private PrivilegeDto privilegeDto;

    private String description;

    private boolean access;

    public ReferenceListDto getReferenceListDto() {
        return referenceListDto;
    }

    public void setReferenceListDto(ReferenceListDto referenceListDto) {
        this.referenceListDto = referenceListDto;
    }

    public PrivilegeDto getPrivilegeDto() {
        return privilegeDto;
    }

    public void setPrivilegeDto(PrivilegeDto privilegeDto) {
        this.privilegeDto = privilegeDto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
