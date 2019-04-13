package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceGroupLevel1Dto;
import com.isofh.his.dto.category.service.ServiceGroupLevel2Dto;
import com.isofh.his.model.category.service.ServiceGroupLevel1;
import com.isofh.his.model.category.service.ServiceGroupLevel2;
import com.isofh.his.repository.category.service.ServiceGroupLevel1Repository;
import com.isofh.his.repository.category.service.ServiceGroupLevel2Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroupLevel2ServiceImpl implements ServiceGroupLevel2Service {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel2ServiceImpl.class);

    @Autowired
    private ServiceGroupLevel2Repository repository;

    @Override
    public ServiceGroupLevel2Repository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceGroupLevel2> getModelClass() {
        return ServiceGroupLevel2.class;
    }

    @Override
    public Class<ServiceGroupLevel2Dto> getDtoClass() {
        return ServiceGroupLevel2Dto.class;
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
    public ServiceGroupLevel2 get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ServiceGroupLevel2 save(ServiceGroupLevel2 model) {
        return ServiceGroupLevel2Service.super.save(model);
    }
}
