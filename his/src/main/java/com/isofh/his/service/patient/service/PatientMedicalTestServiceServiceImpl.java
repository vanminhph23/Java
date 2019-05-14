package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientCheckUpServiceDto;
import com.isofh.his.dto.patient.service.PatientMedicalTestServiceDto;
import com.isofh.his.model.patient.service.PatientCheckUpService;
import com.isofh.his.model.patient.service.PatientMedicalTestService;
import com.isofh.his.repository.patient.service.PatientCheckUpServiceRepository;
import com.isofh.his.repository.patient.service.PatientMedicalTestServiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMedicalTestServiceServiceImpl implements PatientMedicalTestServiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientMedicalTestServiceServiceImpl.class);

    @Autowired
    private PatientMedicalTestServiceRepository repository;

    @Override
    public PatientMedicalTestServiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientMedicalTestService> getModelClass() {
        return PatientMedicalTestService.class;
    }

    @Override
    public Class<PatientMedicalTestServiceDto> getDtoClass() {
        return PatientMedicalTestServiceDto.class;
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
