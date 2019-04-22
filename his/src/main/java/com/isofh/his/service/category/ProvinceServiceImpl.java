package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.model.category.Province;
import com.isofh.his.repository.category.ProvinceRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.importdata.Header;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Autowired
    private CountryService countryService;

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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Long getReferenceId(Header header, String value) {
        if (value == null) {
            return null;
        }

        if ("countryId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return countryService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return countryService.findIdByName(value);
            }
        }

        return null;
    }
}
