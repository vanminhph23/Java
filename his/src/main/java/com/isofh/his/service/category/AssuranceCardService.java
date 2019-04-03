package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.service.base.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

public interface AssuranceCardService extends BaseService<AssuranceCard, AssuranceCardDto> {

    @Override
    default Class<AssuranceCard> getModelClass() {
        return AssuranceCard.class;
    }

    @Override
    default Class<AssuranceCardDto> getDtoClass() {
        return AssuranceCardDto.class;
    }
}
