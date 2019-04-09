package com.isofh.his.service.base;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.exception.BaseException;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.base.BaseRepository;
import com.isofh.his.storage.FileSystemStorageService;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.ExcelUtil;
import com.isofh.his.util.Util;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BaseService<X extends BaseModel, Y extends BaseDto, Z extends BaseRepository> {

    StorageService storageService = new FileSystemStorageService();

    ModelMapper getModelMapper();

    Z getRepository();

    X save(X model);

    default X save(Y dto) {
        return save(getModel(dto));
    }

    default Y saveAndTransfer(X model) {
        return getDto(save(model));
    }

    default Y saveAndTransfer(Y dto) {
        return saveAndTransfer(getModel(dto));
    }

    X get(Long id);

    Class<X> getModelClass();
    Class<Y> getDtoClass();

    default X getModel(Y dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, getModelClass());
    }

    default Y getDto(X model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, getDtoClass());
    }

    default Long convert(String header, String value) {
        return Long.valueOf(0);
    }

    default String importExcel(MultipartFile file, int sheetNo, int startLineNo) {
        String fileName = storageService.store(file);

        List<Map<String, Object>> result = ExcelUtil.readFile(fileName, sheetNo, startLineNo, this);

        List<Y> dtos = Util.convertValues(result, getDtoClass());

        List<String> mes = new ArrayList<>();
        for (Y dto : dtos) {
            try {
                X model = save(dto);
                mes.add(String.valueOf(model.getId()));
            } catch (BaseException e) {
                mes.add("Error " + e.getCode() + ": " + e.getMessage());
            }
        }

        return ExcelUtil.appendLog(fileName, sheetNo, startLineNo, mes);
    }
}
