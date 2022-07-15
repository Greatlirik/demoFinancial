package com.greatlirik.demo.service.impl;

import com.greatlirik.demo.jwt.JwtUser;
import com.greatlirik.demo.jwt.JwtUserFactory;
import com.greatlirik.demo.model.User;
import com.greatlirik.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JwtUserDetailsService
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Primary
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException("User with username:" + name + "not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        log.info("In loadByUsername - user with name : {} successfully loaded", name);
        return jwtUser;
    }
}
