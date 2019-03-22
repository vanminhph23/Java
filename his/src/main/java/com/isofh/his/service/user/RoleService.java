package com.isofh.his.service.user;

import com.isofh.his.model.Role;

public interface RoleService {
    public Role createRole(Role role);

    public Role get(Long id);
}
