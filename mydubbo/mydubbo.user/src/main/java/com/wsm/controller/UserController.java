package com.wsm.controller;

import com.wsm.entity.User;
import com.wsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/info/{id}")
    public User info(@PathVariable Integer id){
        return userService.findUserByorder(id);
    }
}
