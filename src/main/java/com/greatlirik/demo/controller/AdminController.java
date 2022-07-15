package com.greatlirik.demo.controller;

import com.greatlirik.demo.model.User;
import com.greatlirik.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminRESTController, available by admin endpoint
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    /**
     * Autowired field userService
     */
    private final UserService userService;

    /**
     * Find user with given id
     *
     * @param id
     * @return user and status
     */
    @Operation(
            summary = "Find user by id"
    )
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
