package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientTypeDto;
import com.isofh.his.model.patient.PatientType;
import com.isofh.his.repository.patient.PatientTypeRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatientTypeServiceImpl implements PatientTypeService {

    private final static Logger logger = LoggerFactory.getLogger(PatientTypeServiceImpl.class);

    @Autowired
    private PatientTypeRepository repository;

    @Override
    public PatientTypeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientType> getModelClass() {
        return PatientType.class;
    }

    @Override
    public Class<PatientTypeDto> getDtoClass() {
        return PatientTypeDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public PatientType getByActDate(int patientHistoryId, Date actDate) {
        return null;
    }
}
