package com.isofh.his.service.user;

import com.isofh.his.dto.BaseDto;
import com.isofh.his.dto.RoleDto;
import com.isofh.his.model.Role;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role createRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role get(Long id) {
        return repository.findById(id).orElse(null);
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public Role getModel(BaseDto source) {
        return getModelMapper().map(source, Role.class);
    }

    @Override
    public RoleDto getDto(BaseModel source) {
        return getModelMapper().map(source, RoleDto.class);
    }
}
