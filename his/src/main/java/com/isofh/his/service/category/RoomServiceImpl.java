package com.isofh.his.service.category;

import com.isofh.his.dto.category.RoomDto;
import com.isofh.his.dto.category.ZoneDto;
import com.isofh.his.model.category.Room;
import com.isofh.his.model.category.Zone;
import com.isofh.his.repository.category.RoomRepository;
import com.isofh.his.repository.category.ZoneRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    private RoomRepository repository;

    @Override
    public RoomRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Room> getModelClass() {
        return Room.class;
    }

    @Override
    public Class<RoomDto> getDtoClass() {
        return RoomDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public Room get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Room save(Room model) {
        return RoomService.super.save(model);
    }
}
