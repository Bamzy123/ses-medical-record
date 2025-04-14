package org.ses.controllers;

import org.ses.Dtos.LoginRequestDTO;
import org.ses.models.User;
import org.ses.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDTO loginDTO) {
        return userService.login(loginDTO);
    }
}