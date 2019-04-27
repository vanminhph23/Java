package com.isofh.his.service.category;

import com.isofh.his.dto.category.CountryDto;
import com.isofh.his.model.category.Country;
import com.isofh.his.repository.category.CountryRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository repository;

    @Override
    public CountryRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Country> getModelClass() {
        return Country.class;
    }

    @Override
    public Class<CountryDto> getDtoClass() {
        return CountryDto.class;
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
