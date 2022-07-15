package com.greatlirik.demo.service.impl;

import com.greatlirik.demo.exception.ResourceNotFoundException;
import com.greatlirik.demo.model.Coin;
import com.greatlirik.demo.model.Record;
import com.greatlirik.demo.model.Role;
import com.greatlirik.demo.model.User;
import com.greatlirik.demo.repository.UserRepository;
import com.greatlirik.demo.service.CoinService;
import com.greatlirik.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * User service implementation
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final CoinService coinService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        final List<User> result = (List<User>) userRepository.findAll();

        log.info("In getAll - {} users found", result.size());
        return result;
    }

    @Override
    public void userNotify(final Long userId, final Long coinId) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("not found user with id " + userId));
        final Coin coin = coinService.findByID(coinId);
        final List<Record> records = user.getRecords();
        records.add(new Record(1L, userId, coin.getSymbol(), LocalDateTime.now(), coin.getPrice_usd()));
        userRepository.save(user);
    }

    @Override
    public User register(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singletonList(Role.USER));

        User registerAccount = userRepository.save(user);

        log.info("In register - user: {} successfully registered", registerAccount);

        return registerAccount;
    }

    @Override
    public User findByName(final String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("not found user with username " + name));
        log.info("In findByName - user: {} found by name: {}", user, name);
        return user;
    }

    @Override
    public User findById(final Long id) {
        User account = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found user with id " + id));
        log.info("In findById - user: {} found by id: {}", account, id);
        return account;
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
        log.info("In delete - user with id: {} successfully deleted", id);
    }
}
