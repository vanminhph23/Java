package com.isofh.his.dto.employee;

import java.util.List;
import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.dto.employee.RoleDto;


public class PrivilegeDto extends BaseDto {

    private Long id;

    private String name;

    private List<RoleDto> roles;

    public PrivilegeDto() {
    }
}
