package com.isofh.his.dto;

import java.util.List;

public class RoleDto implements BaseDto {
    private Long id;

    private String name;

    private List<UserDto> users;

    private List<PrivilegeDto> privileges;
}
