package com.theer.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderAdminController {

    @GetMapping("/admin/order")
    public String getHome() {
        return "admin/order/show";
    }

}
