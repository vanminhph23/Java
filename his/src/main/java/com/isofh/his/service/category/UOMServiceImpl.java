package com.isofh.his.service.category;

import com.isofh.his.dto.category.UOMDto;
import com.isofh.his.model.category.UOM;
import com.isofh.his.repository.category.UOMRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UOMServiceImpl implements UOMService {

    private final static Logger logger = LoggerFactory.getLogger(UOMServiceImpl.class);

    @Autowired
    private UOMRepository repository;

    @Override
    public UOMRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<UOM> getModelClass() {
        return UOM.class;
    }

    @Override
    public Class<UOMDto> getDtoClass() {
        return UOMDto.class;
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
