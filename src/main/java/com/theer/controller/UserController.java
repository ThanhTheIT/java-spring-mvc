package com.theer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.theer.domain.User;
import com.theer.repository.UserRepository;
import com.theer.service.UserServive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserServive userServive;

    public UserController(UserServive userServive, UserRepository userRepository) {
        this.userServive = userServive;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userServive.getAllUsersByEmail("theer@gmail.com");
        System.out.println(arrUsers);
        model.addAttribute("eric", "test");
        model.addAttribute("theer", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userServive.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table_user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userServive.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/user_detail";
    }

    @RequestMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        this.userServive.handleSaverUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update_user/{id}") // GET
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        User currentUser = userServive.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update_user";
    }

    @PostMapping("admin/user/update_user")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = userServive.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            this.userServive.handleSaverUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        // User user = new User();
        // user.setId(id);
        model.addAttribute("newUser", new User());
        return "/admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        this.userServive.handleDeleteUser(user.getId());
        return "redirect:/admin/user";
    }

}
