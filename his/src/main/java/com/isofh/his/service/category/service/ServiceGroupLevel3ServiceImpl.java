package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceGroupLevel3Dto;
import com.isofh.his.model.category.service.ServiceGroupLevel3;
import com.isofh.his.repository.category.service.ServiceGroupLevel3Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroupLevel3ServiceImpl implements ServiceGroupLevel3Service {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel3ServiceImpl.class);

    @Autowired
    private ServiceGroupLevel3Repository repository;

    @Override
    public ServiceGroupLevel3Repository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceGroupLevel3> getModelClass() {
        return ServiceGroupLevel3.class;
    }

    @Override
    public Class<ServiceGroupLevel3Dto> getDtoClass() {
        return ServiceGroupLevel3Dto.class;
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
