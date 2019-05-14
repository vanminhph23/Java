package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientOtherServiceDto;
import com.isofh.his.model.patient.service.PatientOtherService;
import com.isofh.his.repository.patient.service.PatientOtherServiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientOtherServiceServiceImpl implements PatientOtherServiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientOtherServiceServiceImpl.class);

    @Autowired
    private PatientOtherServiceRepository repository;

    @Override
    public PatientOtherServiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientOtherService> getModelClass() {
        return PatientOtherService.class;
    }

    @Override
    public Class<PatientOtherServiceDto> getDtoClass() {
        return PatientOtherServiceDto.class;
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
