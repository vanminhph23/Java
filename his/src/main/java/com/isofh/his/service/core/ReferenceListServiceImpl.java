package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.repository.core.ReferenceListRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceListServiceImpl implements ReferenceListService {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceListServiceImpl.class);

    @Autowired
    private ReferenceListRepository repository;

    @Override
    public ReferenceListRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ReferenceList> getModelClass() {
        return ReferenceList.class;
    }

    @Override
    public Class<ReferenceListDto> getDtoClass() {
        return ReferenceListDto.class;
    }

    @Override
    public ReferenceList save(ReferenceList model) {
        return repository.save(model);
    }

    @Override
    public ReferenceList get(Long id) {
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
