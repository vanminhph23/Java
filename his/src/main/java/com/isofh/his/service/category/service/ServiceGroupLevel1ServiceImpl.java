package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceGroupLevel1Dto;
import com.isofh.his.model.category.service.ServiceGroupLevel1;
import com.isofh.his.repository.category.service.ServiceGroupLevel1Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroupLevel1ServiceImpl implements ServiceGroupLevel1Service {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel1ServiceImpl.class);

    @Autowired
    private ServiceGroupLevel1Repository repository;

    @Override
    public ServiceGroupLevel1Repository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceGroupLevel1> getModelClass() {
        return ServiceGroupLevel1.class;
    }

    @Override
    public Class<ServiceGroupLevel1Dto> getDtoClass() {
        return ServiceGroupLevel1Dto.class;
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
