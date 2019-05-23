package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceBedDto;
import com.isofh.his.model.patient.service.PatientServiceBed;
import com.isofh.his.repository.patient.service.PatientServiceBedRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceBedServiceImpl implements PatientServiceBedService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceBedServiceImpl.class);

    @Autowired
    private PatientServiceBedRepository repository;

    @Override
    public PatientServiceBedRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceBed> getModelClass() {
        return PatientServiceBed.class;
    }

    @Override
    public Class<PatientServiceBedDto> getDtoClass() {
        return PatientServiceBedDto.class;
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
