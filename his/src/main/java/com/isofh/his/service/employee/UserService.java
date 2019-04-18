package com.isofh.his.service.employee;

import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.model.employee.User;
import com.isofh.his.repository.employee.UserRepository;
import com.isofh.his.service.base.BaseCategoryService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends BaseCategoryService<User, UserDto, UserRepository> {
    User getByName(String name) throws UsernameNotFoundException;
}
