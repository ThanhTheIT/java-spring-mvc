package com.theer.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/homeClient")
    public String getHomePage() {
        return "client/homepage/show";

    }
}
