package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PHCollectionDto;
import com.isofh.his.model.patient.PHCollection;
import com.isofh.his.repository.patient.PHCollectionRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PHCollectionServiceImpl implements PHCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(PHCollectionServiceImpl.class);

    @Autowired
    private PHCollectionRepository repository;

    @Override
    public PHCollectionRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PHCollection> getModelClass() {
        return PHCollection.class;
    }

    @Override
    public Class<PHCollectionDto> getDtoClass() {
        return PHCollectionDto.class;
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
