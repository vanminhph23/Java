package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductGroupDto;
import com.isofh.his.model.category.ProductGroup;
import com.isofh.his.repository.category.ProductGroupRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface ProductGroupService extends BaseCategoryService<ProductGroup, ProductGroupDto, ProductGroupRepository> {
}
