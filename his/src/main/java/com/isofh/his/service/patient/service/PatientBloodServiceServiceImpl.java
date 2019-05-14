package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientBloodServiceDto;
import com.isofh.his.model.patient.service.PatientBloodService;
import com.isofh.his.repository.patient.service.PatientBloodServiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientBloodServiceServiceImpl implements PatientBloodServiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientBloodServiceServiceImpl.class);

    @Autowired
    private PatientBloodServiceRepository repository;

    @Override
    public PatientBloodServiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientBloodService> getModelClass() {
        return PatientBloodService.class;
    }

    @Override
    public Class<PatientBloodServiceDto> getDtoClass() {
        return PatientBloodServiceDto.class;
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
