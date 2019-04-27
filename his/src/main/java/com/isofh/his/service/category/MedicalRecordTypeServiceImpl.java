package com.isofh.his.service.category;

import com.isofh.his.dto.category.MedicalRecordTypeDto;
import com.isofh.his.model.category.MedicalRecordType;
import com.isofh.his.repository.category.MedicalRecordTypeRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordTypeServiceImpl implements MedicalRecordTypeService {

    private final static Logger logger = LoggerFactory.getLogger(MedicalRecordTypeServiceImpl.class);

    @Autowired
    private MedicalRecordTypeRepository repository;

    @Override
    public MedicalRecordTypeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<MedicalRecordType> getModelClass() {
        return MedicalRecordType.class;
    }

    @Override
    public Class<MedicalRecordTypeDto> getDtoClass() {
        return MedicalRecordTypeDto.class;
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
