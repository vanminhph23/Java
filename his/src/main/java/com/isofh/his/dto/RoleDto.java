package com.isofh.his.dto;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.Role;
import com.isofh.his.model.User;
import org.modelmapper.ModelMapper;

import java.util.Collection;

public class RoleDto implements BaseDto {
    private Long id;

    private String name;

    private Collection<User> users;

    private Collection<Privilege> privileges;
}
