package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceGroupLevel3Dto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.service.ServiceGroupLevel3;
import com.isofh.his.repository.category.service.ServiceGroupLevel3Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGroupLevel3ServiceImpl implements ServiceGroupLevel3Service {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel3ServiceImpl.class);

    @Autowired
    private ServiceGroupLevel3Repository repository;

    @Autowired
    private ServiceGroupLevel2Service groupLevel2Service;

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
        if ("serviceGroupLevel2Id".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return groupLevel2Service.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return groupLevel2Service.findIdByName(value);
            }
        }

        return null;
    }
}
