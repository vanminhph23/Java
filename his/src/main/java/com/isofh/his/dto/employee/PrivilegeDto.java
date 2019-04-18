package com.isofh.his.dto.employee;

import com.isofh.his.dto.base.BaseCategoryDto;

import java.util.List;


public class PrivilegeDto extends BaseCategoryDto {

    private Long id;

    private String name;

    private List<RoleDto> roles;

    public PrivilegeDto() {
    }
}
