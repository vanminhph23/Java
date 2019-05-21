package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceTechnicalDto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.service.ServiceSource;
import com.isofh.his.model.category.service.ServiceTechnical;
import com.isofh.his.repository.category.service.ServiceTechnicalRepository;
import com.isofh.his.service.category.*;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceTechnicalServiceImpl implements ServiceTechnicalService {

    private final static Logger logger = LoggerFactory.getLogger(ServiceTechnicalServiceImpl.class);

    @Autowired
    private ServiceTechnicalRepository repository;

    @Autowired
    private UOMService uomService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private ServiceGroupLevel1Service groupLevel1Service;

    @Autowired
    private ServiceGroupLevel2Service groupLevel2Service;

    @Autowired
    private ServiceGroupLevel3Service groupLevel3Service;

    @Autowired
    private ReportTemplateService reportTemplateService;

    @Autowired
    private DyeMethodService dyeMethodService;

    @Override
    public ServiceTechnicalRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ServiceTechnical> getModelClass() {
        return ServiceTechnical.class;
    }

    @Override
    public Class<ServiceTechnicalDto> getDtoClass() {
        return ServiceTechnicalDto.class;
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
        if (value == null) {
            return null;
        }

        if ("uomId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return uomService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return uomService.findIdByName(value);
            }
        } else if ("departmentId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return departmentService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return departmentService.findIdByName(value);
            }
        } else if ("roomId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return roomService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return roomService.findIdByName(value);
            }
        } else if ("specialistId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return specialistService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return specialistService.findIdByName(value);
            }
        } else if ("serviceGroupLevel1Id".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return groupLevel1Service.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return groupLevel1Service.findIdByName(value);
            }
        } else if ("serviceGroupLevel2Id".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return groupLevel2Service.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return groupLevel2Service.findIdByName(value);
            }
        } else if ("serviceGroupLevel3Id".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return groupLevel3Service.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return groupLevel3Service.findIdByName(value);
            }
        } else if ("reportTemplateId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return reportTemplateService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return reportTemplateService.findIdByName(value);
            }
        } else if ("dyeMethodId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return dyeMethodService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return dyeMethodService.findIdByName(value);
            }
        }

        return null;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ServiceTechnical getModel(ServiceTechnicalDto dto) {
        ServiceTechnical technical = getModelMapper().map(dto, getModelClass());

        ServiceSource serviceSource = technical.getService();
        if (serviceSource == null) {
            serviceSource = new ServiceSource();
            technical.setService(serviceSource);
        }

        getModelMapper().map(dto, serviceSource);

        return technical;
    }

    @Override
    public ServiceTechnicalDto getDto(ServiceTechnical model) {
        ServiceTechnicalDto dto = getModelMapper().map(model, getDtoClass());
        getModelMapper().map(model.getService(), dto);

        return dto;
    }

    @Transactional
    @Override
    public ServiceTechnicalDto createDto(ServiceTechnicalDto technicalDto) {
        ServiceTechnical technical = getModel(technicalDto);

        technical = create(technical);

        ServiceTechnicalDto dto = getDto(technical);
        return dto;
    }

    @Transactional
    @Override
    public ServiceTechnical create(ServiceTechnical technical) {
        validateIdBeforeCreate(technical);

        createServiceSource(technical);

        technical = save(technical);

        return technical;
    }

    @Transactional
    @Override
    public ServiceTechnicalDto updateDto(ServiceTechnicalDto technicalDto) {
        ServiceTechnical technical = getModel(technicalDto);

        technical = update(technical);

        ServiceTechnicalDto dto = getDto(technical);
        return dto;
    }

    @Transactional
    @Override
    public ServiceTechnical update(ServiceTechnical technical) {
        validateIdBeforeUpdate(technical);

        technical = save(technical);

        return technical;
    }

    private void createServiceSource(ServiceTechnical serviceTechnical) {
        ServiceSource source = serviceTechnical.getService();

    }
}
