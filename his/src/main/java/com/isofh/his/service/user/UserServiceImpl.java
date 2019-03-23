package com.isofh.his.service.user;

import com.isofh.his.dto.BaseDto;
import com.isofh.his.dto.UserDto;
import com.isofh.his.model.User;
import com.isofh.his.model.base.BaseModel;
import com.isofh.his.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User getByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username : " + username)
        );
    }

    @Override
    public boolean checkLogin(User user) {

        User userExist = getByUsername(user.getUsername());
        if (StringUtils.equals(user.getUsername(), userExist.getUsername()) && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
            return true;
        }

        return false;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User userExist = getByUsername(user.getUsername());
        userExist.setPassword(user.getPassword());
        userExist.setEmail(user.getEmail());

        return repository.save(userExist);
    }

    @Override
    public User getById(Long id) {
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
