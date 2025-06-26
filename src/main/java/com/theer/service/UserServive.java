package com.theer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.theer.domain.User;
import com.theer.repository.UserRepository;

@Service
public class UserServive {
    private final UserRepository userRepository;

    public UserServive(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
