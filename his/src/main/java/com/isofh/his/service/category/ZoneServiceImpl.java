package com.isofh.his.service.category;

import com.isofh.his.dto.category.ZoneDto;
import com.isofh.his.model.category.Zone;
import com.isofh.his.repository.category.ZoneRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final static Logger logger = LoggerFactory.getLogger(ZoneServiceImpl.class);

    @Autowired
    private ZoneRepository repository;

    @Override
    public ZoneRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Zone> getModelClass() {
        return Zone.class;
    }

    @Override
    public Class<ZoneDto> getDtoClass() {
        return ZoneDto.class;
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
    public Zone get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Zone save(Zone model) {
        return ZoneService.super.save(model);
    }
}
