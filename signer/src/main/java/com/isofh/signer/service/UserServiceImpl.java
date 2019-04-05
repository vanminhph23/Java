package com.isofh.signer.service;

import com.isofh.signer.dto.UserDto;
import com.isofh.signer.model.User;
import com.isofh.signer.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    private static ModelMapper modelMapper = null;
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            modelMapper.addMappings(new PropertyMap<UserDto, User>() {
                @Override
                protected void configure() {
                    map().setName(source.getUsername());
                }
            });

        }

        return modelMapper;
    }

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

    @Override
    public UserDto getDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getModel(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }
}
