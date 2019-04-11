package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.model.employee.Qualification;
import com.isofh.his.repository.employee.CertificateRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface CertificateService extends BaseCategoryService<Qualification, CertificateDto, CertificateRepository> {
}
