package com.isofh.his.service.base;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.exception.data.DuplicateValueException;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.exception.data.NullValueException;
import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.repository.base.BaseCategoryRepository;
import com.isofh.his.util.Util;
import org.hibernate.exception.ConstraintViolationException;

import java.util.Map;

public interface BaseCategoryService<X extends BaseCategoryModel, Y extends BaseCategoryDto, Z extends BaseCategoryRepository> extends BaseService<X, Y, Z> {

    @Override
    Z getRepository();

    @Override
    default X create(X model) {
        validateIdBeforeCreate(model);

        validateFields(model);

        autoFillFields(model);

        validateDuplicateData(model);

        return save(model);
    }

    @Override
    default X update(X model) {
        validateIdBeforeUpdate(model);

        validateFields(model);

        autoFillFields(model);

        validateDuplicateData(model);

        return save(model);
    }

    default String findNameById(Long id) {
        return (String) getRepository().findNameById(id).orElse(null);
    }

    default String findValueById(Long id) {
        return (String) getRepository().findValueById(id).orElse(null);
    }

    default String findNameByValue(String value) {
        return (String) getRepository().findNameByValue(value).orElse(null);
    }

    default X findByValue(String value) {
        return (X) getRepository().findByValue(value).orElse(null);
    }

    default X findByName(String name) {
        return (X) getRepository().findByName(name).orElse(null);
    }

    default Y findDtoByValue(String value) {
        return getDto(findByValue(value));
    }

    default Y findDtoByName(String name) {
        return getDto(findByName(name));
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

    default X findById(Long id) {
        return (X) getRepository().findById(id).orElse(null);
    }

    default void validateFields(X model) {
        if (model.getValue() == null) {
            throw new NullValueException("Field 'Value' cannot be null");
        }

        if (model.getName() == null) {
            throw new NullValueException("Field 'Name' cannot be null");
        }
    }

    default void autoFillFields(X model) {
    }

    default void validateDuplicateData(X model) {
        validateDuplicateValue(model);

        validateDuplicateName(model);
    }

    default void validateDuplicateValue(X model) {
        Long id = findIdByValue(model.getValue(), model.getId());

        if (id != null && id > 0) {
            throw new DuplicateValueException("Duplicate value, value: " + model.getValue() + ", name: " + model.getName() + ", id: " + id);
        }
    }

    default void validateDuplicateName(X model) {
    }

    @Override
    default Map<String, Object> getOld(Map<String, Object> newObj, Map<String, Object> keys) {
        Map<String, Object> oldObj = BaseService.super.getOld(newObj, keys);
        if (oldObj != null) {
            return oldObj;
        }

        for (String key : keys.keySet()) {
            if ("value".equals(key)) {
                Y dto = getDto(findByValue((String) keys.get("value")));
                return Util.convertValue(dto);
            }
        }
        return newObj;
    }
}
