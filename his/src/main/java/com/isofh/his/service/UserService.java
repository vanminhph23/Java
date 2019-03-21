package com.isofh.his.service;

import com.isofh.his.model.User;
import com.isofh.his.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean checkLogin(User user) {

        User userExist = repository.findByUsername(user.getUsername());

        if (userExist != null && StringUtils.equals(user.getUsername(), userExist.getUsername())
                && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
            return true;
        }

        return false;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        User userExist = repository.findByUsername(user.getUsername());
        if (userExist == null) {
            return createUser(user);
        }

        userExist.setPassword(user.getPassword());

        return repository.save(userExist);
    }

    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

}
