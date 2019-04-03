package com.isofh.his.service.category;

import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.model.category.Department;
import com.isofh.his.repository.category.DepartmentRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    private final StorageService storageService;

    @Autowired
    public DepartmentServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Department save(Department model) {
        return repository.save(model);
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
}
