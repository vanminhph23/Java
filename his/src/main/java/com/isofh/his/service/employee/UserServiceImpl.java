package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.model.employee.User;
import com.isofh.his.repository.employee.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User getByName(String name) {
        return repository.findByName(name).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username : " + name)
        );
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

    private static ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            modelMapper.addMappings(new PropertyMap<UserDto, User>() {
                @Override
                protected void configure() {
                    map().setName(source.getUsername());
                    map().setPassword(new BCryptPasswordEncoder().encode(source.getPassword()));
                }
            });

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
