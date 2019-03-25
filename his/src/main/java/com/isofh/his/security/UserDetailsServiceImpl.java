package com.isofh.his.security;

import com.isofh.his.model.User;
import com.isofh.his.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByName(username);

        return UserPrincipal.get(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id, List<Long> roleIds, List<Long> departmentIds) {
        User user = userService.get(id);

        return UserPrincipal.get(user, roleIds, departmentIds);
    }
}