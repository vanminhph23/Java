package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.map.PropertyMapPatientHistoryDtoToModel;
import com.isofh.his.map.PropertyMapPatientHistoryToDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryServiceImpl.class);

    @Autowired
    private PatientInsuranceService insuranceService;

    @Autowired
    private PatientAddressService addressService;

    @Autowired
    private PatientVitalSignService vitalSignService;

    @Autowired
    private PatientHistoryRepository repository;

    @Override
    public PatientHistoryRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientHistory> getModelClass() {
        return PatientHistory.class;
    }

    @Override
    public Class<PatientHistoryDto> getDtoClass() {
        return PatientHistoryDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.addMappings(new PropertyMapPatientHistoryToDto());
            modelMapper.addMappings(new PropertyMapPatientHistoryDtoToModel());
        }

        return modelMapper;
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistory model) {
        if (model.getPatientAddress() != null) {
            addressService.save(model.getPatientAddress());
        }

        if (model.getPatientInsurance() != null) {
            insuranceService.save(model.getPatientInsurance());
        }

        return save(model);
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistory model) {
        if (model.getPatientAddress() != null) {
            addressService.save(model.getPatientAddress());
        }

        if (model.getPatientInsurance() != null) {
            insuranceService.save(model.getPatientInsurance());
        }

        return save(model);
    }
}
