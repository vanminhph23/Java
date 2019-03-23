package com.isofh.his.dto;

import java.util.List;

public class UserDto implements BaseDto {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private boolean enabled = true;

    private List<RoleDto> roles;
}
