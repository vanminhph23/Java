package com.isofh.his.service.user;

import com.isofh.his.model.Privilege;

public interface PrivilegeService extends BaseService {
    public Privilege createPrivilege(Privilege privilege);

    public Privilege get(Long id);
}
