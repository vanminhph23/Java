package com.isofh.his.dto;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.Role;
import org.modelmapper.ModelMapper;

import java.util.Collection;

public class PrivilegeDto implements BaseDto {

    private Long id;

    private String name;

    private Collection<Role> roles;


    private ModelMapper modelMapper;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public Privilege getModel() {
        return getModelMapper().map(this, Privilege.class);
    }
}
