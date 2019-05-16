package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductTypeDto;
import com.isofh.his.model.category.ProductType;
import com.isofh.his.repository.category.ProductTypeRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface ProductTypeService extends BaseCategoryService<ProductType, ProductTypeDto, ProductTypeRepository> {
}
