package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceDetailDto;
import com.isofh.his.dto.category.service.ServiceGroupLevel1Dto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.service.ServiceDetail;
import com.isofh.his.model.category.service.ServiceGroupLevel1;
import com.isofh.his.repository.category.service.ServiceDetailRepository;
import com.isofh.his.repository.category.service.ServiceGroupLevel1Repository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailServiceImpl implements ServiceDetailService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceDetailServiceImpl.class);

    @Autowired
    private ServiceDetailRepository repository;

    @Autowired
    private ServiceSourceService serviceSourceService;

    @Override
    public ServiceDetailRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceDetail> getModelClass() {
        return ServiceDetail.class;
    }

    @Override
    public Class<ServiceDetailDto> getDtoClass() {
        return ServiceDetailDto.class;
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
    public Object getReference(Header header, String value) {
        if ("serviceId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return serviceSourceService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return serviceSourceService.findIdByName(value);
            }
        }

        return null;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
