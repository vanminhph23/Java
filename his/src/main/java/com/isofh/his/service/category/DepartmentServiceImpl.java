package com.isofh.his.service.category;

import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.Department;
import com.isofh.his.repository.category.DepartmentRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private MedicalRecordTypeService medicalRecordTypeService;

    @Override
    public DepartmentRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Department> getModelClass() {
        return Department.class;
    }

    @Override
    public Class<DepartmentDto> getDtoClass() {
        return DepartmentDto.class;
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
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Object getReference(Header header, String value) {
        if ("buildingId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return buildingService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return buildingService.findIdByName(value);
            }
        }

        if ("cashierBuildingId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return buildingService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return buildingService.findIdByName(value);
            }
        }

        if ("medicalRecordTypeId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return medicalRecordTypeService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return medicalRecordTypeService.findIdByName(value);
            }
        }

        return null;
    }
}
