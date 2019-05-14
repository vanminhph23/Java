package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientTechnicalServiceDto;
import com.isofh.his.model.patient.service.PatientTechnicalService;
import com.isofh.his.repository.patient.service.PatientTechnicalServiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientTechnicalServiceServiceImpl implements PatientTechnicalServiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientTechnicalServiceServiceImpl.class);

    @Autowired
    private PatientTechnicalServiceRepository repository;

    @Override
    public PatientTechnicalServiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientTechnicalService> getModelClass() {
        return PatientTechnicalService.class;
    }

    @Override
    public Class<PatientTechnicalServiceDto> getDtoClass() {
        return PatientTechnicalServiceDto.class;
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
