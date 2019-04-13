package com.isofh.his.service.category;

import com.isofh.his.dto.category.JobDto;
import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.model.category.Job;
import com.isofh.his.model.category.Province;
import com.isofh.his.repository.category.JobRepository;
import com.isofh.his.repository.category.ProvinceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private final static Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    @Autowired
    private ProvinceRepository repository;

    @Override
    public ProvinceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Province> getModelClass() {
        return Province.class;
    }

    @Override
    public Class<ProvinceDto> getDtoClass() {
        return ProvinceDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public Province get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Province save(Province model) {
        return ProvinceService.super.save(model);
    }
}
