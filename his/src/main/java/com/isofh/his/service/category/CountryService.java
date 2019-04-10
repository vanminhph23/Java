package com.isofh.his.service.category;

import com.isofh.his.dto.category.CountryDto;
import com.isofh.his.model.category.Country;
import com.isofh.his.repository.category.CountryRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface CountryService extends BaseCategoryService<Country, CountryDto, CountryRepository> {
}
