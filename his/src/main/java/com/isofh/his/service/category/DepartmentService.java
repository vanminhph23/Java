package com.isofh.his.service.category;

import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.model.category.Department;
import com.isofh.his.repository.category.DepartmentRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface DepartmentService extends BaseCategoryService<Department, DepartmentDto, DepartmentRepository> {
}
