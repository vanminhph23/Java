package com.isofh.his.service.category;

import com.isofh.his.dto.category.RoomDto;
import com.isofh.his.importdata.Header;
import com.isofh.his.model.category.Room;
import com.isofh.his.repository.category.RoomRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Object getReference(Header header, String value) {
        if ("parentRoomId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return getRepository().findIdByValue(value, Long.valueOf(0)).orElse(null);
            } else if ("name".equals(header.getLinkColumnName())) {
                return getRepository().findIdByName(value, Long.valueOf(0)).orElse(null);
            }
        }

        if ("buildingId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return buildingService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return buildingService.findIdByName(value);
            }
        }

        if ("departmentId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return departmentService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return departmentService.findIdByName(value);
            }
        }

        if ("specialistId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return specialistService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return specialistService.findIdByName(value);
            }
        }

        return null;
    }
}
