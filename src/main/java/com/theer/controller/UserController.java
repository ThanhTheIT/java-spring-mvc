package com.theer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theer.service.UserServive;

@Controller
public class UserController {

    private UserServive userServive;

    public UserController(UserServive userServive) {
        this.userServive = userServive;
    }

    @RequestMapping("/")
    public String getHomePage() {
        String test = this.userServive.handleHello();
        return "eric";
    }
}

// @RestController
// public class UserController {

// private UserServive userServive;

// public UserController(UserServive userServive) {
// this.userServive = userServive;
// }

// @GetMapping("/")
// public String getHomePage() {
// return this.userServive.handleHello();
// }
// }