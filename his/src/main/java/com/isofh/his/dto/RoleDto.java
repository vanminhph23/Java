package com.isofh.his.dto;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.User;

import java.util.Collection;

public class RoleDto {
    private Long id;

    private String name;

    private Collection<User> users;

    private Collection<Privilege> privileges;
}
