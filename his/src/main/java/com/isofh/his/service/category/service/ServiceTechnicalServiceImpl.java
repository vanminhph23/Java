package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceTechnicalDto;
import com.isofh.his.model.category.service.ServiceTechnical;
import com.isofh.his.repository.category.service.ServiceTechnicalRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTechnicalServiceImpl implements ServiceTechnicalService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceTechnicalServiceImpl.class);

    @Autowired
    private ServiceTechnicalRepository repository;

    @Override
    public ServiceTechnicalRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceTechnical> getModelClass() {
        return ServiceTechnical.class;
    }

    @Override
    public Class<ServiceTechnicalDto> getDtoClass() {
        return ServiceTechnicalDto.class;
    }

    @Override
    public ServiceTechnical getModel(ServiceTechnicalDto dto) {
        if (dto == null) {
            return null;
        }
        ServiceTechnical model = getModelMapper().map(dto, getModelClass());
        getModelMapper().map(dto, model.getService());

        return model;
    }

    @Override
    public ServiceTechnicalDto getDto(ServiceTechnical model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, getDtoClass());
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
