package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceMedicalTestDto;
import com.isofh.his.model.patient.service.PatientServiceMedicalTest;
import com.isofh.his.repository.patient.service.PatientServiceMedicalTestRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceMedicalTestServiceImpl implements PatientServiceMedicalTestService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceMedicalTestServiceImpl.class);

    @Autowired
    private PatientServiceMedicalTestRepository repository;

    @Override
    public PatientServiceMedicalTestRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceMedicalTest> getModelClass() {
        return PatientServiceMedicalTest.class;
    }

    @Override
    public Class<PatientServiceMedicalTestDto> getDtoClass() {
        return PatientServiceMedicalTestDto.class;
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
