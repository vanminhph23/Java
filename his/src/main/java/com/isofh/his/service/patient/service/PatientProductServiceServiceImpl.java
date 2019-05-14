package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientProductServiceDto;
import com.isofh.his.model.patient.service.PatientProductService;
import com.isofh.his.repository.patient.service.PatientProductServiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientProductServiceServiceImpl implements PatientProductServiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientProductServiceServiceImpl.class);

    @Autowired
    private PatientProductServiceRepository repository;

    @Override
    public PatientProductServiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientProductService> getModelClass() {
        return PatientProductService.class;
    }

    @Override
    public Class<PatientProductServiceDto> getDtoClass() {
        return PatientProductServiceDto.class;
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
