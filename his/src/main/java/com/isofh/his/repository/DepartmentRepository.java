package com.isofh.his.repository;

import com.isofh.his.model.Department;
import com.isofh.his.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
