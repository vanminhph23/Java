package com.isofh.his.service.user;

import com.isofh.his.model.Role;
import com.isofh.his.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role createRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role get(Long id) {
        return repository.findById(id).orElse(null);
    }

}
