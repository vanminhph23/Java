package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServicePurposeDto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.service.ServicePurpose;
import com.isofh.his.repository.category.service.ServicePurposeRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePurposeServiceImpl implements ServicePurposeService {

    private final static Logger logger = LoggerFactory.getLogger(ServicePurposeServiceImpl.class);

    @Autowired
    private ServicePurposeRepository repository;

    @Autowired
    private ServicePurposeService serviceSourceService;

    @Override
    public ServicePurposeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServicePurpose> getModelClass() {
        return ServicePurpose.class;
    }

    @Override
    public Class<ServicePurposeDto> getDtoClass() {
        return ServicePurposeDto.class;
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
    public Object getReference(Header header, String value) {
        if ("serviceId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return serviceSourceService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return serviceSourceService.findIdByName(value);
            }
        }

        return null;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
