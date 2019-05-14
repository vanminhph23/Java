package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientMedicalHistoryDto;
import com.isofh.his.model.patient.info.PatientMedicalHistory;
import com.isofh.his.repository.patient.PatientMedicalHistoryRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMedicalHistoryServiceImpl implements PatientMedicalHistoryService {

    private final static Logger logger = LoggerFactory.getLogger(PatientMedicalHistoryServiceImpl.class);

    @Autowired
    private PatientMedicalHistoryRepository repository;

    @Override
    public PatientMedicalHistoryRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientMedicalHistory> getModelClass() {
        return PatientMedicalHistory.class;
    }

    @Override
    public Class<PatientMedicalHistoryDto> getDtoClass() {
        return PatientMedicalHistoryDto.class;
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
