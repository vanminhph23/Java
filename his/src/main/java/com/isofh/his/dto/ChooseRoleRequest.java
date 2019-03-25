package com.isofh.his.dto;

import java.util.List;

public class ChooseRoleRequest {

    List<Long> departmentIds;

    List<Long> roleIds;

    public ChooseRoleRequest() {
    }

    public List<Long> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
