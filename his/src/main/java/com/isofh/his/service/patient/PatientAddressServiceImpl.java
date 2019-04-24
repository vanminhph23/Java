package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientAddressDto;
import com.isofh.his.model.patient.PatientAddress;
import com.isofh.his.repository.patient.PatientAddressRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientAddressServiceImpl implements PatientAddressService {

    private final static Logger logger = LoggerFactory.getLogger(PatientAddressServiceImpl.class);

    @Autowired
    private PatientAddressRepository repository;

    @Override
    public PatientAddressRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientAddress> getModelClass() {
        return PatientAddress.class;
    }

    @Override
    public Class<PatientAddressDto> getDtoClass() {
        return PatientAddressDto.class;
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
