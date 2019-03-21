package com.isofh.his.service;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.Role;
import com.isofh.his.repository.PrivilegeRepository;
import com.isofh.his.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    public Privilege createPrivilege(Privilege privilege) {
        return repository.save(privilege);
    }

    public Privilege get(Long id) {
        return repository.findById(id).orElse(null);
    }

}
