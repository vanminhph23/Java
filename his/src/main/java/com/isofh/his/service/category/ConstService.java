package com.isofh.his.service.category;

import com.isofh.his.dto.category.ConstDto;
import com.isofh.his.model.category.Const;
import com.isofh.his.repository.category.ConstRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface ConstService extends BaseCategoryService<Const, ConstDto, ConstRepository> {

    Long getCurrentHospital();

    int getExtraInsurancePercent();

    String getInsuranceUsername();

    String getInsurancePassword();
}
