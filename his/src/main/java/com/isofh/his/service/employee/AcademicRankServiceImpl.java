package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.AcademicRankDto;
import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.model.employee.AcademicRank;
import com.isofh.his.model.employee.Qualification;
import com.isofh.his.repository.employee.AcademicRankRepository;
import com.isofh.his.repository.employee.CertificateRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicRankServiceImpl implements AcademicRankService {

    private final static Logger logger = LoggerFactory.getLogger(AcademicRankServiceImpl.class);

    @Autowired
    private AcademicRankRepository repository;

    @Override
    public AcademicRankRepository getRepository() {
        return repository;
    }

    @Override
    public Class<AcademicRank> getModelClass() {
        return AcademicRank.class;
    }

    @Override
    public Class<AcademicRankDto> getDtoClass() {
        return AcademicRankDto.class;
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
    public AcademicRank get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AcademicRank save(AcademicRank model) {
        return AcademicRankService.super.save(model);
    }
}
