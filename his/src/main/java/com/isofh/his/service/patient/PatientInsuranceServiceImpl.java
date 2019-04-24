package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientInsuranceDto;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientInsuranceServiceImpl implements PatientInsuranceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInsuranceServiceImpl.class);

    @Autowired
    private PatientInsuranceRepository repository;

    @Override
    public PatientInsuranceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInsurance> getModelClass() {
        return PatientInsurance.class;
    }

    @Override
    public Class<PatientInsuranceDto> getDtoClass() {
        return PatientInsuranceDto.class;
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
