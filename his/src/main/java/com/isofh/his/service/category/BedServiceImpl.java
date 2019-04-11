package com.isofh.his.service.category;

import com.isofh.his.dto.category.BedDto;
import com.isofh.his.dto.category.JobDto;
import com.isofh.his.model.category.Bed;
import com.isofh.his.model.category.Job;
import com.isofh.his.repository.category.BedRepository;
import com.isofh.his.repository.category.JobRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl implements BedService {

    private final static Logger logger = LoggerFactory.getLogger(BedServiceImpl.class);

    @Autowired
    private BedRepository repository;

    @Override
    public BedRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Bed> getModelClass() {
        return Bed.class;
    }

    @Override
    public Class<BedDto> getDtoClass() {
        return BedDto.class;
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
    public Bed get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Bed save(Bed model) {
        return BedService.super.save(model);
    }
}
