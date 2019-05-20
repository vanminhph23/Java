package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientContractDto;
import com.isofh.his.model.patient.info.PatientContract;
import com.isofh.his.repository.patient.info.PatientContractRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientContractServiceImpl implements PatientContractService {

    private final static Logger logger = LoggerFactory.getLogger(PatientContractServiceImpl.class);

    @Autowired
    private PatientContractRepository repository;

    @Override
    public PatientContractRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientContract> getModelClass() {
        return PatientContract.class;
    }

    @Override
    public Class<PatientContractDto> getDtoClass() {
        return PatientContractDto.class;
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
