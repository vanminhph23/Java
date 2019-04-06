package com.isofh.his.service.base;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.storage.FileSystemStorageService;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.ExcelUtil;
import com.isofh.his.util.Util;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseModel, Y extends BaseDto> {

    StorageService storageService = new FileSystemStorageService();

    ModelMapper getModelMapper();

    T save(T model);

    T get(Long id);

    Class<T> getModelClass();
    Class<Y> getDtoClass();

    default T getModel(Y dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, getModelClass());
    }

    default Y getDto(T model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, getDtoClass());
    }

    default String importExcel(MultipartFile file, int sheetNo, int startLineNo) {
        String fileName = storageService.store(file);

        List<Map<String, Object>> result = ExcelUtil.readFile(fileName, sheetNo, startLineNo);

        List<Y> dtos = Util.convertValues(result, getDtoClass());

        List<String> mes = new ArrayList<>();
        for (Y dto : dtos) {
            try {
                T model = save(getModel(dto));
                mes.add("OK: " + model.getId());
            } catch (Exception e) {
                mes.add("Fail: " + e.getMessage());
            }
        }

        return ExcelUtil.appendLog(fileName, sheetNo, startLineNo, mes);
    }
}
