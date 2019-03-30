package com.isofh.his.service.user;

import com.isofh.his.dto.UserDto;
import com.isofh.his.model.employee.User;
import com.isofh.his.service.base.BaseService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends BaseService<User, UserDto> {
    public User getByName(String name) throws UsernameNotFoundException;
}
