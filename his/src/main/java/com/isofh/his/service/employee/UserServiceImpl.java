package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.exception.DuplicateNameException;
import com.isofh.his.model.employee.User;
import com.isofh.his.repository.employee.UserRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<User> getModelClass() {
        return User.class;
    }

    @Override
    public Class<UserDto> getDtoClass() {
        return UserDto.class;
    }

    @Override
    public User getByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + name));
    }

    @Override
    public void validateDuplicateName(User model) {
        Long id = findIdByName(model.getName(), model.getId());
        if (id != null && id > 0) {
            throw new DuplicateNameException("Duplicate name, value: " + model.getValue() + ", name: " + model.getName() + ", id: " + id);
        }
    }

    private static ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.addMappings(new PropertyMap<User, UserDto>() {
                @Override
                protected void configure() {
                    skip(destination.getPassword());
                }
            });
        }

        return modelMapper;
    }
}
