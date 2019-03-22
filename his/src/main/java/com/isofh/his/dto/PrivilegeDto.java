package com.isofh.his.dto;

import com.isofh.his.model.Role;

import java.util.Collection;

public class PrivilegeDto {

    private Long id;

    private String name;

    private Collection<Role> roles;
}
