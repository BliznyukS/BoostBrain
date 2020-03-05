package com.boost.brain.http.controller;

import com.boost.brain.http.entity.User;
import com.boost.brain.http.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public User create (String username) {
        return userService.createUser(username);
    }

}
