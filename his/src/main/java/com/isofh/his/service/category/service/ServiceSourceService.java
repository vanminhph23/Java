package com.isofh.his.service.category.service;

import com.isofh.his.dto.category.service.ServiceSourceDto;
import com.isofh.his.model.category.service.ServiceSource;
import com.isofh.his.repository.category.service.ServiceSourceRepository;
import com.isofh.his.service.base.BaseCategoryService;
import com.isofh.his.service.base.IEnum;

public interface ServiceSourceService extends BaseCategoryService<ServiceSource, ServiceSourceDto, ServiceSourceRepository> {

    enum ServiceTypeEnum implements IEnum {
        KHAM(10), XET_NGHIEM(20), CDHA_TDCN(30),
        PHAU_THUAT_THU_THUAT(40), SUAT_AN(50), KHAC(60),
        GOI(70), GIUONG(80),
        THUOC(90), VAT_TU(100), HOA_CHAT(110), MAU(120);

        private int value;

        ServiceTypeEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
}
