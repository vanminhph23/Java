package com.isofh.his.service.user;

import com.isofh.his.dto.DepartmentDto;
import com.isofh.his.dto.PrivilegeDto;
import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.model.Department;
import com.isofh.his.model.Privilege;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.DepartmentRepository;
import com.isofh.his.repository.PrivilegeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department create(Department department) {
        return repository.save(department);
    }

    @Override
    public Department get(Long id) {
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
    public Department getModel(DepartmentDto dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, Department.class);
    }

    @Override
    public DepartmentDto getDto(Department model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, DepartmentDto.class);
    }
}
