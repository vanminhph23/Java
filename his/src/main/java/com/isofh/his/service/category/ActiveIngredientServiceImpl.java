package com.isofh.his.service.category;

import com.isofh.his.dto.category.ActiveIngredientDto;
import com.isofh.his.model.category.ActiveIngredient;
import com.isofh.his.repository.category.ActiveIngredientRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    private final static Logger logger = LoggerFactory.getLogger(ActiveIngredientServiceImpl.class);

    @Autowired
    private ActiveIngredientRepository repository;

    @Override
    public ActiveIngredientRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ActiveIngredient> getModelClass() {
        return ActiveIngredient.class;
    }

    @Override
    public Class<ActiveIngredientDto> getDtoClass() {
        return ActiveIngredientDto.class;
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
