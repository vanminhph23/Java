package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.repository.employee.PrivilegeRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    private final static Logger logger = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

    @Autowired
    private PrivilegeRepository repository;

    @Override
    public PrivilegeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Privilege> getModelClass() {
        return Privilege.class;
    }

    @Override
    public Class<PrivilegeDto> getDtoClass() {
        return PrivilegeDto.class;
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
