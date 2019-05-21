package com.isofh.his.service.category;

import com.isofh.his.dto.category.ResultTemplateDto;
import com.isofh.his.model.category.ResultTemplate;
import com.isofh.his.repository.category.ResultTemplateRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultTemplateServiceImpl implements ResultTemplateService {

    private final static Logger logger = LoggerFactory.getLogger(ResultTemplateServiceImpl.class);

    @Autowired
    private ResultTemplateRepository repository;

    @Override
    public ResultTemplateRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ResultTemplate> getModelClass() {
        return ResultTemplate.class;
    }

    @Override
    public Class<ResultTemplateDto> getDtoClass() {
        return ResultTemplateDto.class;
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
