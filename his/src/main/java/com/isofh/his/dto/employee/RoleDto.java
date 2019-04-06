package com.isofh.his.dto.employee;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;

public class RoleDto extends BaseCategoryDto {

    private List<UserDto> users;

    private List<PrivilegeDto> privileges;

    public RoleDto() {
    }
}
