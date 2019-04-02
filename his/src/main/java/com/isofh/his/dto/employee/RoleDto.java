package com.isofh.his.dto.employee;

import com.isofh.his.dto.base.Base2Dto;

import java.util.List;

public class RoleDto extends Base2Dto {

    private List<UserDto> users;

    private List<PrivilegeDto> privileges;

    public RoleDto() {
    }
}
