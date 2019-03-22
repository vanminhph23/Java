package com.isofh.his.dto;

import com.isofh.his.model.BaseModel;
import org.modelmapper.ModelMapper;

public interface BaseDto {

    <T extends BaseModel> T getModel();

    ModelMapper getModelMapper();
}
