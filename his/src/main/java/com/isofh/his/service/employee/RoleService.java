package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.RoleDto;
import com.isofh.his.model.employee.Role;
import com.isofh.his.repository.employee.RoleRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface RoleService extends BaseCategoryService<Role, RoleDto, RoleRepository> {
}
