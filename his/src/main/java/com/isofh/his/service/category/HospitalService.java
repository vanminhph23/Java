package com.isofh.his.service.category;

import com.isofh.his.dto.category.HospitalDto;
import com.isofh.his.model.category.Hospital;
import com.isofh.his.repository.category.HospitalRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface HospitalService extends BaseCategoryService<Hospital, HospitalDto, HospitalRepository> {
}
