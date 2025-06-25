package com.theer.service;

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

    public User handleSaverUser(User user) {
        User theer = this.userRepository.save(user);
        System.out.println(theer);
        return theer;
    }
}
