package com.greatlirik.demo.service;

import com.greatlirik.demo.model.User;

import java.util.List;

/**
 * CRUD and simple logic operations on User
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface UserService {

    /**
     * Get all users
     *
     * @return list with all users
     */
    List<User> findAll();

    void userNotify(Long userId, Long coinId);

    /**
     * set user password, roles and save it in repository
     *
     * @param user
     * @return user
     */
    User register(User user);

    /**
     * find user with given name
     *
     * @param name
     * @return user
     */
    User findByName(String name);

    /**
     * find user with given id
     *
     * @param id
     * @return user
     */
    User findById(Long id);

    /**
     * delete user with given name
     *
     * @param id
     */
    void delete(Long id);
}
