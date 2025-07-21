package com.theer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theer.domain.Role;
import com.theer.domain.User;
import com.theer.repository.RoleReposiory;
import com.theer.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleReposiory roleReposiory;

    public UserService(UserRepository userRepository, RoleReposiory roleReposiory) {
        this.userRepository = userRepository;
        this.roleReposiory = roleReposiory;
    }

    public String handleHello() {
        return "hello from service";
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public User getUpdateUser(User user) {
        return this.userRepository.save(user);
    }

    public User handleSaverUser(User user) {
        User saveUser = this.userRepository.save(user);
        System.out.println(saveUser);
        return saveUser;
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleReposiory.findByName(name);
    }

    public List<Role> getAllRoles() {
        return this.roleReposiory.findAll();
    }

    public Role getRoleById(long id) {
        return this.roleReposiory.findById(id).orElse(null);
    }

}
