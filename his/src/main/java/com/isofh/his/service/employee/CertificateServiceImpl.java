package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.model.employee.Certificate;
import com.isofh.his.repository.employee.CertificateRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final static Logger logger = LoggerFactory.getLogger(CertificateServiceImpl.class);

    @Autowired
    private CertificateRepository repository;

    @Override
    public CertificateRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Certificate> getModelClass() {
        return Certificate.class;
    }

    @Override
    public Class<CertificateDto> getDtoClass() {
        return CertificateDto.class;
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
