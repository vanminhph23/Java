package com.isofh.his.service.category;

import com.isofh.his.dto.category.RoomDto;
import com.isofh.his.model.category.Room;
import com.isofh.his.repository.category.RoomRepository;
import com.isofh.his.service.base.BaseCategoryService;
import com.isofh.his.service.base.IEnum;

public interface RoomService extends BaseCategoryService<Room, RoomDto, RoomRepository> {

    enum RoomTypeEnum implements IEnum {
        KHAM(10), CAN_LAM_SANG(20), LAN_SANG(30), LAY_MAU(40), GIUONG(50), GIUONG_TU_CHON(60), KHAC(70);

        private int value;

        RoomTypeEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
}
