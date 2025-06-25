package com.theer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.theer.domain.User;
import com.theer.service.UserServive;

@Controller
public class UserController {

    private UserServive userServive;

    public UserController(UserServive userServive) {
        this.userServive = userServive;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userServive.handleHello();
        model.addAttribute("eric", test);
        model.addAttribute("theer", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        String test = this.userServive.handleHello();
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User theer) {
        System.out.println("run here " + theer);
        return "hello";
    }
}
