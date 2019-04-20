package com.isofh.his.service.category;

import com.isofh.his.dto.category.HospitalDto;
import com.isofh.his.model.category.Hospital;
import com.isofh.his.repository.category.HospitalRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.importdata.Header;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final static Logger logger = LoggerFactory.getLogger(HospitalServiceImpl.class);

    @Autowired
    private HospitalRepository repository;

    @Override
    public HospitalRepository getRepository() {
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
    public Class<Hospital> getModelClass() {
        return Hospital.class;
    }

    @Override
    public Class<HospitalDto> getDtoClass() {
        return HospitalDto.class;
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
    public Long convert(Header header, String value) {
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
