package com.isofh.his.service.category;

import com.isofh.his.dto.category.BuildingDto;
import com.isofh.his.model.category.Building;
import com.isofh.his.repository.category.BuildingRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final static Logger logger = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private BuildingRepository repository;

    @Override
    public BuildingRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Building> getModelClass() {
        return Building.class;
    }

    @Override
    public Class<BuildingDto> getDtoClass() {
        return BuildingDto.class;
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
