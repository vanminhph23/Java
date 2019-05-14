package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryCollectionDto;
import com.isofh.his.model.patient.PatientHistoryCollection;
import com.isofh.his.repository.patient.PatientHistoryCollectionRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryCollectionImpl implements PatientHistoryCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryCollectionImpl.class);

    @Autowired
    private PatientHistoryCollectionRepository repository;

    @Override
    public PatientHistoryCollectionRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientHistoryCollection> getModelClass() {
        return PatientHistoryCollection.class;
    }

    @Override
    public Class<PatientHistoryCollectionDto> getDtoClass() {
        return PatientHistoryCollectionDto.class;
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
