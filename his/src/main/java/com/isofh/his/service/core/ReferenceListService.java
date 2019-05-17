package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.repository.core.ReferenceListRepository;
import com.isofh.his.service.base.BaseService;

public interface ReferenceListService extends BaseService<ReferenceList, ReferenceListDto, ReferenceListRepository> {

    ReferenceList findByReferenceValueAndValue(String referenceValue, int value);

    ReferenceListDto findDtoByReferenceValueAndValue(String referenceValue, int value);

    ReferenceListDto createDto(ReferenceListDto dto);

    ReferenceListDto updateDto(ReferenceListDto dto);
}
