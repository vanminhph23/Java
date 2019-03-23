package com.isofh.his.service.user;

import com.isofh.his.dto.BaseDto;
import com.isofh.his.dto.PrivilegeDto;
import com.isofh.his.model.Privilege;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.PrivilegeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    @Override
    public Privilege create(Privilege privilege) {
        return repository.save(privilege);
    }

    @Override
    public Privilege get(Long id) {
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
    public Privilege getModel(BaseDto source) {
        return getModelMapper().map(source, Privilege.class);
    }

    @Override
    public PrivilegeDto getDto(BaseModel source) {
        return getModelMapper().map(source, PrivilegeDto.class);
    }
}
