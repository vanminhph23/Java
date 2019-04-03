package com.isofh.his.service.core;

import com.isofh.his.model.base.Reference;
import com.isofh.his.repository.core.ReferenceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    @Autowired
    private ReferenceRepository repository;

    private final StorageService storageService;

    @Autowired
    public ReferenceServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Reference save(Reference model) {
        return repository.save(model);
    }

    @Override
    public Reference get(Long id) {
        return repository.findById(id).orElse(null);
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
