package com.theer.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello World with theer!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Nguoi dung";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Nguoi quan ly";
    }
}
