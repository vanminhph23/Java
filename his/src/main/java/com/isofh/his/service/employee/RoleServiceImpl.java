package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.RoleDto;
import com.isofh.his.model.employee.Role;
import com.isofh.his.repository.employee.RoleRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Class<Role> getModelClass() {
        return Role.class;
    }

    @Override
    public Class<RoleDto> getDtoClass() {
        return RoleDto.class;
    }

    @Override
    public Role save(Role model) {
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
}
