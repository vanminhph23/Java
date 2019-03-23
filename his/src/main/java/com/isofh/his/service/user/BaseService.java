package com.isofh.his.service.user;

import com.isofh.his.dto.BaseDto;
import com.isofh.his.model.base.BaseModel;
import org.modelmapper.ModelMapper;

public interface BaseService {

    ModelMapper getModelMapper();
    <T extends BaseModel> T getModel(BaseDto dto);
    <T extends BaseDto> T getDto(BaseModel model);
}
