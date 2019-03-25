package com.isofh.his.service.user;

import com.isofh.his.dto.UserDto;
import com.isofh.his.model.User;
import com.isofh.his.repository.UserRepository;
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
    public User create(User user) {
        return repository.save(user);
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
    public User getModel(UserDto dto) {
        return getModelMapper().map(dto, User.class);
    }

    @Override
    public UserDto getDto(User model) {
        return getModelMapper().map(model, UserDto.class);
    }
}
