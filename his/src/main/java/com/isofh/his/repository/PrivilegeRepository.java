package com.isofh.his.repository;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);
}
