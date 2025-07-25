package com.theer.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.theer.domain.Product;

@Controller
public class ProductAdminController {

    @GetMapping("/admin/product")
    public String getProduct() {
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

}
