package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientGuardianDto;
import com.isofh.his.model.patient.info.PatientGuardian;
import com.isofh.his.repository.patient.info.PatientGuardianRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.PatientUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    public void validateInfo(PatientGuardian guardian) {
        validatePatientName(guardian);
        validatePhone(guardian);
    }

    private void validatePatientName(PatientGuardian guardian) {
        guardian.setName(PatientUtil.formatName(guardian.getName()));
    }

    private void validatePhone(PatientGuardian guardian) {
        guardian.setPhone(PatientUtil.formatPhone(guardian.getPhone()));
    }
}
