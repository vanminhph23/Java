package com.isofh.his.service.user;

import com.isofh.his.model.Privilege;

public interface PrivilegeService {
    public Privilege createPrivilege(Privilege privilege);

    public Privilege get(Long id);
}
