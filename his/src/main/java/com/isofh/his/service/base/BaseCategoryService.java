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
        validateFields(model);

        autoFillFields(model);

        validateDuplicateValue(model);

        validateDuplicateName(model);

        return (X) getRepository().save(model);
    }

    default void validateDuplicateValue(X model) {
        Long id = findIdByValue(model.getValue(), model.getId());

        if (id != null && id > 0) {
            throw new DuplicateValueException("Duplicate value, value: " + model.getValue() + ", name: " + model.getName() + ", id: " + id);
        }
    }

    default void autoFillFields(X model) {
    }

    default void validateDuplicateName(X model) {
    }

    default void validateFields(X model) {
    }

    default X findByValue(String value) {
        return (X) getRepository().findByValue(value).orElse(null);
    }

    default X findByName(String name) {
        return (X) getRepository().findByName(name).orElse(null);
    }

    default Long findIdByValue(String value) {
        return findIdByValue(value, Long.valueOf(0));
    }

    default Long findIdByValue(String value, Long id) {
        if (id == null) {
            id = Long.valueOf(0);
        }
        return (Long) getRepository().findIdByValue(value, id).orElse(null);
    }

    default Long findIdByName(String name, Long id) {
        if (id == null) {
            id = Long.valueOf(0);
        }
        return (Long) getRepository().findIdByName(name, id).orElse(null);
    }

    default Long findIdByName(String name) {
        return findIdByName(name, Long.valueOf(0));
    }
}
