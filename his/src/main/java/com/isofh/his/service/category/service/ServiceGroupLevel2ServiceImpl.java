package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceGroupLevel2Dto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.service.ServiceGroupLevel2;
import com.isofh.his.repository.category.service.ServiceGroupLevel2Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroupLevel2ServiceImpl implements ServiceGroupLevel2Service {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel2ServiceImpl.class);

    @Autowired
    private ServiceGroupLevel2Repository repository;

    @Autowired
    private ServiceGroupLevel1Service groupLevel1Service;

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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Object getReference(Header header, String value) {
        if ("serviceGroupLevel1Id".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return groupLevel1Service.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return groupLevel1Service.findIdByName(value);
            }
        }

        return null;
    }
}
