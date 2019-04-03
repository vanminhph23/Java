package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.service.base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AssuranceCardService extends BaseService<AssuranceCard, AssuranceCardDto> {

    String importExcel(MultipartFile file);
}
