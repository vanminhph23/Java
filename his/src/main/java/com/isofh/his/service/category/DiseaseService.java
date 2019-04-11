package com.isofh.his.service.category;

import com.isofh.his.dto.category.DiseaseDto;
import com.isofh.his.model.category.Disease;
import com.isofh.his.repository.category.DiseaseRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface DiseaseService extends BaseCategoryService<Disease, DiseaseDto, DiseaseRepository> {
}
