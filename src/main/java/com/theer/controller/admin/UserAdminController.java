package com.theer.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.theer.domain.Role;
import com.theer.domain.User;
import com.theer.repository.UserRepository;
import com.theer.service.UploadService;
import com.theer.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAdminController {

    private final UserService userServive;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserAdminController(PasswordEncoder passwordEncoder, UploadService uploadService,
            UserService userServive, UserRepository userRepository) {
        this.userServive = userServive;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
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
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userServive.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create") // GET
    public String getUserCreatePage(Model model) {
        model.addAttribute("newUser", new User());

        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") User user,
            @RequestParam("avatarFile") MultipartFile file) {

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());

        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userServive.getRoleByName(user.getRole().getName()));

        // save
        this.userServive.handleSaverUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}") // GET
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        User currentUser = userServive.getUserById(id);
        model.addAttribute("newUser", currentUser);
        model.addAttribute("roles", userServive.getAllRoles());
        return "admin/user/update";
    }

    @PostMapping("admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = userServive.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            if (user.getRole() != null && user.getRole().getId() != 0L) {
                Role selectedRole = userServive.getRoleById(user.getRole().getId());
                currentUser.setRole(selectedRole);
            }
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
