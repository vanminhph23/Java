package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductClassifyDto;
import com.isofh.his.model.category.ProductClassify;
import com.isofh.his.repository.category.ProductClassifyRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductClassifyServiceImpl implements ProductClassifyService {

    private final static Logger logger = LoggerFactory.getLogger(ProductClassifyServiceImpl.class);

    @Autowired
    private ProductClassifyRepository repository;

    @Override
    public ProductClassifyRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ProductClassify> getModelClass() {
        return ProductClassify.class;
    }

    @Override
    public Class<ProductClassifyDto> getDtoClass() {
        return ProductClassifyDto.class;
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
