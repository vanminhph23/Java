package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientGuardianDto;
import com.isofh.his.model.patient.PatientGuardian;
import com.isofh.his.repository.patient.PatientGuardianRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientGuardianServiceImpl implements PatientGuardianService {

    private final static Logger logger = LoggerFactory.getLogger(PatientGuardianServiceImpl.class);

    @Autowired
    private PatientGuardianRepository repository;

    @Override
    public PatientGuardianRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientGuardian> getModelClass() {
        return PatientGuardian.class;
    }

    @Override
    public Class<PatientGuardianDto> getDtoClass() {
        return PatientGuardianDto.class;
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
