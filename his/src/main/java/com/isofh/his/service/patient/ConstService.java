package com.isofh.his.service.patient;

import com.isofh.his.dto.core.ConstDto;
import com.isofh.his.model.core.Const;
import com.isofh.his.repository.core.ConstRepository;
import com.isofh.his.service.base.BaseCategoryService;
import com.isofh.his.service.base.BaseService;

public interface ConstService extends BaseCategoryService<Const, ConstDto, ConstRepository> {

    Long getCurrentHospital();

    int getExtraInsurancePercent();
}
