package com.isofh.his.service.category;

import com.isofh.his.dto.category.DistrictDto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.District;
import com.isofh.his.repository.category.DistrictRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProvinceService provinceService;

    @Override
    public StorageService getStorageService() {
        return storageService;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Long getReferenceId(Header header, String value) {
        if (value == null) {
            return null;
        }

        if ("provinceId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return provinceService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return provinceService.findIdByName(value);
            }
        }

        return null;
    }
}
