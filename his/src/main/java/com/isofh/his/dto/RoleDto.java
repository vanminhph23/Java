package com.isofh.his.dto;

import com.isofh.his.dto.base.BaseDto;

import java.util.List;

public class RoleDto extends BaseDto {
    private Long id;

    private String name;

    private List<UserDto> users;

    private List<PrivilegeDto> privileges;

    public RoleDto(Long id) {
        super(id);
    }
}
