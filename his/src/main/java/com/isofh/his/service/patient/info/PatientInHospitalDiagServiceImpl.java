package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientInHospitalDiagDto;
import com.isofh.his.model.patient.info.PatientInHospitalDiag;
import com.isofh.his.repository.patient.info.PatientInHospitalDiagRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientInHospitalDiagServiceImpl implements PatientInHospitalDiagService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInHospitalDiagServiceImpl.class);

    @Autowired
    private PatientInHospitalDiagRepository repository;

    @Override
    public PatientInHospitalDiagRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInHospitalDiag> getModelClass() {
        return PatientInHospitalDiag.class;
    }

    @Override
    public Class<PatientInHospitalDiagDto> getDtoClass() {
        return PatientInHospitalDiagDto.class;
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
