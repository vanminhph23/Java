package com.isofh.his.dto;

import java.util.Collection;

public class PrivilegeDto implements BaseDto {

    private Long id;

    private String name;

    private Collection<RoleDto> roles;
}
