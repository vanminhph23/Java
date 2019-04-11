package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.model.employee.Qualification;
import com.isofh.his.repository.employee.CertificateRepository;
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

    @Override
    public Class<Qualification> getModelClass() {
        return Qualification.class;
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

    @Override
    public Qualification get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Qualification save(Qualification model) {
        return CertificateService.super.save(model);
    }
}
