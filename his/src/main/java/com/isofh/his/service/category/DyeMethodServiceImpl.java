package com.isofh.his.service.category;

import com.isofh.his.dto.category.DyeMethodDto;
import com.isofh.his.model.category.DyeMethod;
import com.isofh.his.repository.category.DyeMethodRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DyeMethodServiceImpl implements DyeMethodService {

    private final static Logger logger = LoggerFactory.getLogger(DyeMethodServiceImpl.class);

    @Autowired
    private DyeMethodRepository repository;

    @Override
    public DyeMethodRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<DyeMethod> getModelClass() {
        return DyeMethod.class;
    }

    @Override
    public Class<DyeMethodDto> getDtoClass() {
        return DyeMethodDto.class;
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
