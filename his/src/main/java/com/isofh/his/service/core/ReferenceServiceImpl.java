package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.model.core.Reference;
import com.isofh.his.repository.core.ReferenceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceServiceImpl.class);

    @Autowired
    private ReferenceRepository repository;

    @Override
    public ReferenceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Reference> getModelClass() {
        return Reference.class;
    }

    @Override
    public Class<ReferenceDto> getDtoClass() {
        return ReferenceDto.class;
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
