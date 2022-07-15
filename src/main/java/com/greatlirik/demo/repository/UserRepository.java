package com.greatlirik.demo.repository;

import com.greatlirik.demo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository <User, Long> {
    /**
     * Find user with given username
     *
     * @param username
     * @return Optional<Account>
     */
    Optional<User> findByName(String username);
}
