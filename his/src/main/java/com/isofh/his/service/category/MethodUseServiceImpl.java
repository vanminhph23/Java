package com.isofh.his.service.category;

import com.isofh.his.dto.category.MethodUseDto;
import com.isofh.his.model.category.MethodUse;
import com.isofh.his.repository.category.MethodUseRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MethodUseServiceImpl implements MethodUseService {

    private final static Logger logger = LoggerFactory.getLogger(MethodUseServiceImpl.class);

    @Autowired
    private MethodUseRepository repository;

    @Override
    public MethodUseRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<MethodUse> getModelClass() {
        return MethodUse.class;
    }

    @Override
    public Class<MethodUseDto> getDtoClass() {
        return MethodUseDto.class;
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
