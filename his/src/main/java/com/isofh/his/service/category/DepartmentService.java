package com.isofh.his.service.category;

import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.employee.User;
import com.isofh.his.repository.category.DepartmentRepository;
import com.isofh.his.service.base.BaseService;

public interface DepartmentService extends BaseService<Department, DepartmentDto, DepartmentRepository> {
}
