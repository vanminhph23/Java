package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceSourceDto;
import com.isofh.his.model.category.service.ServiceSource;
import com.isofh.his.repository.category.service.ServiceSourceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSourceServiceImpl implements ServiceSourceService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceSourceServiceImpl.class);

    @Autowired
    private ServiceSourceRepository repository;

    @Override
    public ServiceSourceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceSource> getModelClass() {
        return com.isofh.his.model.category.service.ServiceSource.class;
    }

    @Override
    public Class<ServiceSourceDto> getDtoClass() {
        return ServiceSourceDto.class;
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
}
