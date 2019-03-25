package com.isofh.his.service.user;

import com.isofh.his.dto.PrivilegeDto;
import com.isofh.his.model.Privilege;

public interface PrivilegeService extends BaseService<Privilege, PrivilegeDto> {
    public Privilege create(Privilege privilege);

    public Privilege get(Long id);
}
