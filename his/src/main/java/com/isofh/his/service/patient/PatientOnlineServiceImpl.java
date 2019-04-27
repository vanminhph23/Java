package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientOnlineDto;
import com.isofh.his.model.patient.PatientOnline;
import com.isofh.his.repository.patient.PatientOnlineRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientOnlineServiceImpl implements PatientOnlineService {

    private final static Logger logger = LoggerFactory.getLogger(PatientOnlineServiceImpl.class);

    @Autowired
    private PatientOnlineRepository repository;

    @Override
    public PatientOnlineRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientOnline> getModelClass() {
        return PatientOnline.class;
    }

    @Override
    public Class<PatientOnlineDto> getDtoClass() {
        return PatientOnlineDto.class;
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
