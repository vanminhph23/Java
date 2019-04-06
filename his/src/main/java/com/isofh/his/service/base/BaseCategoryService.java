package com.isofh.his.service.base;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.exception.DuplicateValueException;
import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.repository.base.BaseCategoryRepository;

public interface BaseCategoryService<X extends BaseCategoryModel, Y extends BaseCategoryDto, Z extends BaseCategoryRepository> extends BaseService<X, Y, Z> {

    @Override
    Z getRepository();

    @Override
    default X save(X model) {
        if (getRepository().existsByValue(model.getValue())) {
            throw new DuplicateValueException("value: " + model.getValue() + ", name: " + model.getName() + ", id: " + model.getId());
        }

        return (X) getRepository().save(model);
    }
}
