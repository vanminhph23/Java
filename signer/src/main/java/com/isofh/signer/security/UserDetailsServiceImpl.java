package com.isofh.signer.security;

import com.isofh.signer.model.User;
import com.isofh.signer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserDetails loadUserById(Long id) {
        User user = userService.get(id);

        return UserPrincipal.get(user);
    }
}