package com.isofh.his.service.category;

import com.isofh.his.dto.category.JobDto;
import com.isofh.his.model.category.Job;
import com.isofh.his.repository.category.JobRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    private JobRepository repository;

    @Override
    public JobRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Job> getModelClass() {
        return Job.class;
    }

    @Override
    public Class<JobDto> getDtoClass() {
        return JobDto.class;
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
