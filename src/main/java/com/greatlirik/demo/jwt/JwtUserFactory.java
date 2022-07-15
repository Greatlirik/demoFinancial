package com.greatlirik.demo.jwt;

import com.greatlirik.demo.model.Role;
import com.greatlirik.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Jwt user factory
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    /**
     * create new jwtUser
     *
     * @param account
     * @return new jwtUser
     */
    public static JwtUser create(User account) {
        return new JwtUser(
                account.getId(),
                account.getName(),
                account.getPassword(),
                account.isActive(),
                mapToGrantedAuthorities(new ArrayList<>(account.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
