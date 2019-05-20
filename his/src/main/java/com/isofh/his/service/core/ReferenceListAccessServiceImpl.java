package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceListAccessDto;
import com.isofh.his.model.core.ReferenceListAccess;
import com.isofh.his.repository.core.ReferenceListAccessRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceListAccessServiceImpl implements ReferenceListAccessService {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceListAccessServiceImpl.class);

    @Autowired
    private ReferenceListAccessRepository repository;

    @Override
    public ReferenceListAccessRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ReferenceListAccess> getModelClass() {
        return ReferenceListAccess.class;
    }

    @Override
    public Class<ReferenceListAccessDto> getDtoClass() {
        return ReferenceListAccessDto.class;
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
