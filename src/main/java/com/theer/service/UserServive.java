package com.theer.service;

import org.springframework.stereotype.Service;

@Service
public class UserServive {
    public String handleHello() {
        return "hello from service";
    }
}
