package com.gik.market.market.controllers;

import com.gik.market.market.entities.Product;
import com.gik.market.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String allProducts(Model uiModel) {
        uiModel.addAttribute("products", productService.allProducts());
        return "/products";
    }

    @GetMapping("/add")
    public String newProductForm() {
        return "product_add";
    }

    @PostMapping("/add")
    public String productAdd(@ModelAttribute Product product) {
        productService.editProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model uiModel) {
        uiModel.addAttribute("product", productService.findById(id));
        return "/product_edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.editProduct(product);
        return "redirect:/products";
    }
}
