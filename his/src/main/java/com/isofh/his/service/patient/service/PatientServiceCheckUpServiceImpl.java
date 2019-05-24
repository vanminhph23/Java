package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceCheckUpDto;
import com.isofh.his.model.patient.service.PatientServiceCheckUp;
import com.isofh.his.repository.patient.service.PatientServiceCheckUpRepository;
import com.isofh.his.service.patient.info.PatientHistoryService;
import com.isofh.his.service.patient.invoice.PatientInvoiceLineService;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceCheckUpServiceImpl implements PatientServiceCheckUpService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceCheckUpServiceImpl.class);

    @Autowired
    private PatientServiceCheckUpRepository repository;

    @Override
    public PatientServiceCheckUpRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientServiceCheckUp> getModelClass() {
        return PatientServiceCheckUp.class;
    }

    @Override
    public Class<PatientServiceCheckUpDto> getDtoClass() {
        return PatientServiceCheckUpDto.class;
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

    @Override
    public PatientServiceCheckUpDto createDto(PatientServiceCheckUpDto dto) {
        return dto;
    }

    @Override
    public PatientServiceCheckUp create(PatientServiceCheckUp checkUp) {

        checkUp = save(checkUp);
        return checkUp;
    }
}
