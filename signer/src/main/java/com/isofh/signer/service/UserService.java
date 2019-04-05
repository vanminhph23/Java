package com.isofh.signer.service;

import com.isofh.signer.dto.UserDto;
import com.isofh.signer.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    User getByName(String name) throws UsernameNotFoundException;

    User save(User user);

    User get(Long id);

    UserDto getDto(User user);

    User getModel(UserDto dto);
}