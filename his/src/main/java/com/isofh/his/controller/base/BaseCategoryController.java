package com.isofh.his.controller.base;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.service.base.BaseCategoryService;

public abstract class BaseCategoryController<Y extends BaseCategoryDto, S extends BaseCategoryService> extends BaseController {

    @Override
    protected abstract S getService();
}
