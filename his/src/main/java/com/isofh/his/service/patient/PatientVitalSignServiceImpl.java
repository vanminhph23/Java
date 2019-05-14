package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientVitalSignDto;
import com.isofh.his.model.patient.info.PatientVitalSign;
import com.isofh.his.repository.patient.PatientVitalSignRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientVitalSignServiceImpl implements PatientVitalSignService {

    private final static Logger logger = LoggerFactory.getLogger(PatientVitalSignServiceImpl.class);

    @Autowired
    private PatientVitalSignRepository repository;

    @Override
    public PatientVitalSignRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientVitalSign> getModelClass() {
        return PatientVitalSign.class;
    }

    @Override
    public Class<PatientVitalSignDto> getDtoClass() {
        return PatientVitalSignDto.class;
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
