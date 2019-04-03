package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.service.base.BaseService;

public interface PrivilegeService extends BaseService<Privilege, PrivilegeDto> {

    @Override
    default Class<Privilege> getModelClass() {
        return Privilege.class;
    }

    @Override
    default Class<PrivilegeDto> getDtoClass() {
        return PrivilegeDto.class;
    }
}
