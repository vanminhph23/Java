package com.isofh.his.service.category;

import com.isofh.his.dto.category.DistrictDto;
import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.model.category.District;
import com.isofh.his.model.category.Province;
import com.isofh.his.repository.category.DistrictRepository;
import com.isofh.his.repository.category.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    private final static Logger logger = LoggerFactory.getLogger(DistrictServiceImpl.class);

    @Autowired
    private DistrictRepository repository;

    @Override
    public DistrictRepository getRepository() {
        return repository;
    }

    @Override
    public Class<District> getModelClass() {
        return District.class;
    }

    @Override
    public Class<DistrictDto> getDtoClass() {
        return DistrictDto.class;
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
    public District get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public District save(District model) {
        return DistrictService.super.save(model);
    }
}
