package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductGroupDto;
import com.isofh.his.model.category.ProductGroup;
import com.isofh.his.repository.category.ProductGroupRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {

    private final static Logger logger = LoggerFactory.getLogger(ProductGroupServiceImpl.class);

    @Autowired
    private ProductGroupRepository repository;

    @Override
    public ProductGroupRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ProductGroup> getModelClass() {
        return ProductGroup.class;
    }

    @Override
    public Class<ProductGroupDto> getDtoClass() {
        return ProductGroupDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
