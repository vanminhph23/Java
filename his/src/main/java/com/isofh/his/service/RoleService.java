package com.isofh.his.service;

import com.isofh.his.model.Role;
import com.isofh.his.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role createRole(Role role) {
        return repository.save(role);
    }

    public Role get(Long id) {
        return repository.findById(id).orElse(null);
    }

}
