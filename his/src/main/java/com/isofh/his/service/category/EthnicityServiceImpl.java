package com.isofh.his.service.category;

import com.isofh.his.dto.category.EthnicityDto;
import com.isofh.his.model.category.Ethnicity;
import com.isofh.his.repository.category.EthnicityRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EthnicityServiceImpl implements EthnicityService {

    private final static Logger logger = LoggerFactory.getLogger(EthnicityServiceImpl.class);

    @Autowired
    private EthnicityRepository repository;

    @Override
    public EthnicityRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Ethnicity> getModelClass() {
        return Ethnicity.class;
    }

    @Override
    public Class<EthnicityDto> getDtoClass() {
        return EthnicityDto.class;
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
