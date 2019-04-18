package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.repository.employee.PrivilegeRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface PrivilegeService extends BaseCategoryService<Privilege, PrivilegeDto, PrivilegeRepository> {
}
