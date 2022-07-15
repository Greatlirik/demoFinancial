package com.greatlirik.demo.controller;

import com.greatlirik.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * UserRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Allows to perform operations on the user")
public class UserController {

    private final UserService userService;

    /**
     * notify user
     *
     * @param userId
     * @param coinId
     */
    @Operation(
            summary = "Fixing the user and the rate of cryptocurrency in the record"
    )
    @PostMapping("{id}")
    public void userNotify(final @PathVariable("id") Long userId, final @RequestParam(value = "coinId")
    @Parameter(description = "coin id for fixing") Long coinId) {
        userService.userNotify(userId, coinId);
    }

}
