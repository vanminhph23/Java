package com.isofh.his.service.base;

import com.isofh.his.dto.base.BaseDto;
import com.isofh.his.exception.BaseException;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.importdata.Header;
import com.isofh.his.importdata.ImportUtil;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.base.BaseRepository;
import com.isofh.his.security.UserPrincipal;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.ExcelUtil;
import com.isofh.his.util.Util;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BaseService<X extends BaseModel, Y extends BaseDto, Z extends BaseRepository> {

    StorageService getStorageService();

    ModelMapper getModelMapper();

    Logger getLogger();

    Z getRepository();

    default X create(X model) {
        return save(model);
    }

    default X update(X model) {
        return save(model);
    }

    default X create(Y dto) {
        return create(getModel(dto));
    }

    default Y createDto(X model) {
        return getDto(create(model));
    }

    default Y createDto(Y dto) {
        return createDto(getModel(dto));
    }

    default X update(Y dto) {
        return update(getModel(dto));
    }

    default Y updateDto(X model) {
        return getDto(update(model));
    }

    default Y updateDto(Y dto) {
        return updateDto(getModel(dto));
    }

    @Transactional
    default X save(X model) {
        return (X) getRepository().save(model);
    }

    default X save(Y dto) {
        return save(getModel(dto));
    }

    default Y saveDto(X model) {
        return getDto(save(model));
    }

    default Y saveDto(Y dto) {
        return saveDto(getModel(dto));
    }

    default X findById(Long id) {
        return (X) getRepository().findById(id).orElse(null);
    }

    default Y findDtoById(Long id) {
        return getDto(findById(id));
    }

    default void validateIdBeforeUpdate(X model) {
        Long id = model.getId();

        if (id == null || id <= 0) {
            throw new InvalidDataException("Cannot update entity with id null");
        }
    }

    default void validateIdBeforeCreate(X model) {
        Long id = model.getId();

        if (id != null && id > 0) {
            throw new InvalidDataException("Cannot create entity with id " + id);
        }
    }

    Class<X> getModelClass();

    Class<Y> getDtoClass();

    default X getModel(Y dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, getModelClass());
    }

    default Long getDepartment() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return userPrincipal.getDepartmentId();
    }

    default List<SimpleGrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return userPrincipal.getAuthorities();
    }

    default Y getDto(X model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, getDtoClass());
    }

    default Object getReference(Header header, String value) {
        return null;
    }

    default Map<String, Object> getOld(Map<String, Object> newObj, Map<String, Object> keys) {
        for (String key : keys.keySet()) {
            if ("id".equals(key)) {
                Y dto = getDto(findById(Long.valueOf((String) keys.get("id"))));
                return Util.convertValue(dto);
            }
        }
        return null;
    }

    @Transactional
    default String importExcel(MultipartFile file, int sheetNo, int startLineNo) {
        String fileName = getStorageService().store(file);

        List<List<String>> result = ExcelUtil.readFile(fileName, sheetNo, startLineNo);
        List<Map<String, Object>> objs = ImportUtil.convertValue(result, this);

        List<Y> dtos = Util.convertValues(objs, getDtoClass());

        List<String> mes = new ArrayList<>();
        for (Y dto : dtos) {
            try {
                X model = importExcel(dto);

                mes.add(String.valueOf(model.getId()));
            } catch (BaseException e) {
                mes.add("Error " + e.getCode() + ": " + e.getMessage());
            }
        }

        return ExcelUtil.appendLog(fileName, sheetNo, startLineNo + 2, mes);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    default X importExcel(Y dto) {
        X model;

        if (dto.getId() != null && dto.getId() > 0) {
            model = update(dto);
        } else {
            model = create(dto);
        }

        return model;
    }
}
