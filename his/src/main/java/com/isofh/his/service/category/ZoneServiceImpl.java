package com.isofh.his.service.category;

import com.isofh.his.dto.category.ZoneDto;
import com.isofh.his.model.category.Zone;
import com.isofh.his.repository.category.ZoneRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.importdata.Header;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Autowired
    private StorageService storageService;

    @Autowired
    private DistrictService districtService;

    @Override
    public StorageService getStorageService() {
        return storageService;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Long getReferenceId(Header header, String value) {
        if (value == null) {
            return null;
        }

        if ("districtId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return districtService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return districtService.findIdByName(value);
            }
        }

        return null;
    }
}
