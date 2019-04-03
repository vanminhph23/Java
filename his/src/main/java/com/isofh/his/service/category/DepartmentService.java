package com.isofh.his.service.category;

import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.employee.User;
import com.isofh.his.service.base.BaseService;

public interface DepartmentService extends BaseService<Department, DepartmentDto> {

    @Override
    default Class<Department> getModelClass() {
        return Department.class;
    }

    @Override
    default Class<DepartmentDto> getDtoClass() {
        return DepartmentDto.class;
    }
}
