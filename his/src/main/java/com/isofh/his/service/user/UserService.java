package com.isofh.his.service.user;

import com.isofh.his.dto.UserDto;
import com.isofh.his.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends BaseService<User, UserDto> {

    public User create(User user);

    public User get(Long id);

    public User getByUsername(String username) throws UsernameNotFoundException;
}
