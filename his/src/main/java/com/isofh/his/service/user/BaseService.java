package com.isofh.his.service.user;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.model.base.BaseModel;
import org.modelmapper.ModelMapper;

public interface BaseService<T extends BaseModel, Y extends BaseDto> {

    ModelMapper getModelMapper();

    T getModel(Y dto);

    Y getDto(T model);

    T create(T model);

    T get(Long id);
}
