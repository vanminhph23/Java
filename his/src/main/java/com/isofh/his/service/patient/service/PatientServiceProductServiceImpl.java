package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceProductDto;
import com.isofh.his.model.patient.service.PatientServiceProduct;
import com.isofh.his.repository.patient.service.PatientServiceProductRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceProductServiceImpl implements PatientServiceProductService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceProductServiceImpl.class);

    @Autowired
    private PatientServiceProductRepository repository;

    @Override
    public PatientServiceProductRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceProduct> getModelClass() {
        return PatientServiceProduct.class;
    }

    @Override
    public Class<PatientServiceProductDto> getDtoClass() {
        return PatientServiceProductDto.class;
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
