package com.theer.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.theer.domain.Product;
import com.theer.service.ProductService;
import com.theer.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductAdminController {

    private final UploadService uploadService;
    private final ProductService productService;

    public ProductAdminController(
            UploadService uploadService,
            ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createProductPage(Model model,
            @RequestParam("imageProductFile") MultipartFile file,
            @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult) {
        // Validate
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }
        //
        String imageProduct = this.uploadService.handleSaveUploadFile(file, "product");

        product.setImage(imageProduct);

        // save
        this.productService.createProduct(product);
        return "redirect:/admin/product";
    }
}