package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceOtherDto;
import com.isofh.his.model.patient.service.PatientServiceOther;
import com.isofh.his.repository.patient.service.PatientServiceOtherRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceOtherServiceImpl implements PatientServiceOtherService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceOtherServiceImpl.class);

    @Autowired
    private PatientServiceOtherRepository repository;

    @Override
    public PatientServiceOtherRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceOther> getModelClass() {
        return PatientServiceOther.class;
    }

    @Override
    public Class<PatientServiceOtherDto> getDtoClass() {
        return PatientServiceOtherDto.class;
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
