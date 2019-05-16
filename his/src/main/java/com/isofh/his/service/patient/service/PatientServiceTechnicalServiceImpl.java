package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceTechnicalDto;
import com.isofh.his.model.patient.service.PatientServiceTechnical;
import com.isofh.his.repository.patient.service.PatientServiceTechnicalRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceTechnicalServiceImpl implements PatientServiceTechnicalService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceTechnicalServiceImpl.class);

    @Autowired
    private PatientServiceTechnicalRepository repository;

    @Override
    public PatientServiceTechnicalRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceTechnical> getModelClass() {
        return PatientServiceTechnical.class;
    }

    @Override
    public Class<PatientServiceTechnicalDto> getDtoClass() {
        return PatientServiceTechnicalDto.class;
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
