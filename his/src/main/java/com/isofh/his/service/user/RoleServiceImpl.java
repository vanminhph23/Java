package com.isofh.his.service.user;

import com.isofh.his.dto.RoleDto;
import com.isofh.his.model.employee.Role;
import com.isofh.his.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role create(Role model) {
        return repository.save(model);
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
    public Role getModel(RoleDto dto) {
        return getModelMapper().map(dto, Role.class);
    }

    @Override
    public RoleDto getDto(Role model) {
        return getModelMapper().map(model, RoleDto.class);
    }
}
