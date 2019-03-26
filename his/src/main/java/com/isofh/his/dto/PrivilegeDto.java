package com.isofh.his.dto;

import java.util.List;
import com.isofh.his.dto.base.BaseDto;


public class PrivilegeDto extends BaseDto {

    private Long id;

    private String name;

    private List<RoleDto> roles;

    public PrivilegeDto() {
    }
}
