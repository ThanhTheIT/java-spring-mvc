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

    public User handleSaverUser(User user) {
        User theer = this.userRepository.save(user);
        System.out.println(theer);
        return theer;
    }
}
