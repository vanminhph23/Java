package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientDiagDto;
import com.isofh.his.model.patient.info.PatientDiag;
import com.isofh.his.repository.patient.info.PatientDiagRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDiagServiceImpl implements PatientDiagService {

    private final static Logger logger = LoggerFactory.getLogger(PatientDiagServiceImpl.class);

    @Autowired
    private PatientDiagRepository repository;

    @Override
    public PatientDiagRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientDiag> getModelClass() {
        return PatientDiag.class;
    }

    @Override
    public Class<PatientDiagDto> getDtoClass() {
        return PatientDiagDto.class;
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
