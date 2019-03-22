package com.isofh.his.service.user;

import com.isofh.his.dto.BaseDto;
import com.isofh.his.dto.RoleDto;
import com.isofh.his.dto.UserDto;
import com.isofh.his.model.BaseModel;
import com.isofh.his.model.Role;
import com.isofh.his.model.User;
import com.isofh.his.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean checkLogin(User user) {

        User userExist = repository.findByUsername(user.getUsername());

        if (userExist != null && StringUtils.equals(user.getUsername(), userExist.getUsername())
                && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
            return true;
        }

        return false;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userExist = repository.findByUsername(user.getUsername());
        if (userExist == null) {
            return createUser(user);
        }

        userExist.setPassword(user.getPassword());

        return repository.save(userExist);
    }

    @Override
    public User get(Long id) {
        return repository.findById(id).orElse(null);
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
    public User getModel(BaseDto source) {
        return getModelMapper().map(source, User.class);
    }

    @Override
    public UserDto getDto(BaseModel source) {
        return getModelMapper().map(source, UserDto.class);
    }
}
