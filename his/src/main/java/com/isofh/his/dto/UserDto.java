package com.isofh.his.dto;

import com.isofh.his.model.Role;
import com.isofh.his.model.User;
import org.modelmapper.ModelMapper;

import java.util.Collection;

public class UserDto implements BaseDto {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private boolean enabled = true;

    private Collection<Role> roles;

    private ModelMapper modelMapper;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    public User getModel() {
        return getModelMapper().map(this, User.class);
    }
}
