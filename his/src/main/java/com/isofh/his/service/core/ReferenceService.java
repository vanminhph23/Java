package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.model.base.Reference;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.service.base.BaseService;

public interface ReferenceService extends BaseService<Reference, ReferenceDto> {
    @Override
    default Class<Reference> getModelClass() {
        return Reference.class;
    }

    @Override
    default Class<ReferenceDto> getDtoClass() {
        return ReferenceDto.class;
    }
}
