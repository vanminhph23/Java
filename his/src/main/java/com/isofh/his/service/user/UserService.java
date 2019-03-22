package com.isofh.his.service.user;

import com.isofh.his.model.User;

public interface UserService {

    public boolean checkLogin(User user);

    public User createUser(User user);

    public User updateUser(User user);

    public User get(Long id);

}
