package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceTechnicalDto;
import com.isofh.his.model.category.service.ServiceTechnical;
import com.isofh.his.repository.category.service.ServiceTechnicalRepository;
import com.isofh.his.service.base.BaseService;

public interface ServiceTechnicalService extends BaseService<ServiceTechnical, ServiceTechnicalDto, ServiceTechnicalRepository> {

    ServiceTechnicalDto createDto(ServiceTechnicalDto technicalDto);

    ServiceTechnicalDto updateDto(ServiceTechnicalDto technicalDto);

    ServiceTechnical create(ServiceTechnical technical);

    ServiceTechnical update(ServiceTechnical technical);
}
