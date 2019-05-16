package com.isofh.his.service.category;

import com.isofh.his.dto.category.ProductClassifyDto;
import com.isofh.his.model.category.ProductClassify;
import com.isofh.his.repository.category.ProductClassifyRepository;
import com.isofh.his.service.base.BaseCategoryService;

public interface ProductClassifyService extends BaseCategoryService<ProductClassify, ProductClassifyDto, ProductClassifyRepository> {
}
