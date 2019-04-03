package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.dto.employee.RoleDto;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.model.employee.Role;
import com.isofh.his.service.base.BaseService;

public interface RoleService extends BaseService<Role, RoleDto> {

    @Override
    default Class<Role> getModelClass() {
        return Role.class;
    }

    @Override
    default Class<RoleDto> getDtoClass() {
        return RoleDto.class;
    }
}
