package com.isofh.his.repository;

import com.isofh.his.model.Role;
import com.isofh.his.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
