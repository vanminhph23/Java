package com.isofh.his.service.user;

import com.isofh.his.dto.RoleDto;
import com.isofh.his.model.Role;

public interface RoleService extends BaseService<Role, RoleDto> {
    public Role create(Role role);

    public Role get(Long id);
}
