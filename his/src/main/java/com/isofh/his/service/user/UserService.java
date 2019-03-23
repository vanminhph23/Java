package com.isofh.his.service.user;

import com.isofh.his.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends BaseService {

    public boolean checkLogin(User user);

    public User create(User user);

    public User update(User user);

    public User getById(Long id);

    public User getByUsername(String username) throws UsernameNotFoundException;
}
