package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceTechnicalDto;
import com.isofh.his.model.category.service.ServiceSource;
import com.isofh.his.model.category.service.ServiceTechnical;
import com.isofh.his.repository.category.service.ServiceTechnicalRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTechnicalServiceImpl implements ServiceTechnicalService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceTechnicalServiceImpl.class);

    @Autowired
    private ServiceTechnicalRepository repository;

    @Autowired
    private ServiceSourceService serviceSourceService;

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
    public ServiceTechnical getModel(ServiceTechnicalDto dto) {
        ServiceTechnical technical = getModelMapper().map(dto, getModelClass());

        ServiceSource serviceSource = technical.getService();
        if (serviceSource == null) {
            serviceSource = new ServiceSource();
            technical.setService(serviceSource);
        }

        getModelMapper().map(dto, serviceSource);

        return technical;
    }

    @Override
    public ServiceTechnicalDto getDto(ServiceTechnical model) {
        return null;
    }

    @Transactional
    @Override
    public ServiceTechnicalDto createDto(ServiceTechnicalDto technicalDto) {
        ServiceTechnical technical = getModel(technicalDto);

        technical = create(technical);

        ServiceTechnicalDto dto = getDto(technical);
        return dto;
    }

    @Transactional
    @Override
    public ServiceTechnical create(ServiceTechnical technical) {
        validateIdBeforeCreate(technical);

        createServiceSource(technical);

        technical = save(technical);

        return technical;
    }

    @Transactional
    @Override
    public ServiceTechnicalDto updateDto(ServiceTechnicalDto technicalDto) {
        ServiceTechnical technical = getModel(technicalDto);

        technical = update(technical);

        ServiceTechnicalDto dto = getDto(technical);
        return dto;
    }

    @Transactional
    @Override
    public ServiceTechnical update(ServiceTechnical technical) {
        validateIdBeforeUpdate(technical);

        technical = save(technical);

        return technical;
    }

    private void createServiceSource(ServiceTechnical serviceTechnical) {
        ServiceSource source = serviceTechnical.getService();

    }
}
