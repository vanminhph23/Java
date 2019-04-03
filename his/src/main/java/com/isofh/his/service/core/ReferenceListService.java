package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.service.base.BaseService;

public interface ReferenceListService extends BaseService<ReferenceList, ReferenceListDto> {

    @Override
    default Class<ReferenceList> getModelClass() {
        return ReferenceList.class;
    }

    @Override
    default Class<ReferenceListDto> getDtoClass() {
        return ReferenceListDto.class;
    }
}
