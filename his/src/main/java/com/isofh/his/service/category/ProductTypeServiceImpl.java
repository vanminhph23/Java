package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductTypeDto;
import com.isofh.his.model.category.ProductType;
import com.isofh.his.repository.category.ProductTypeRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final static Logger logger = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @Autowired
    private ProductTypeRepository repository;

    @Override
    public ProductTypeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ProductType> getModelClass() {
        return ProductType.class;
    }

    @Override
    public Class<ProductTypeDto> getDtoClass() {
        return ProductTypeDto.class;
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
