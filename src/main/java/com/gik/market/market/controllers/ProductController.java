package com.gik.market.market.controllers;

import com.gik.market.market.entities.Product;
import com.gik.market.market.services.ProductService;
import com.gik.market.market.utils.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String allProducts(@RequestParam Map<String, String> requestParams, Model uiModel) {
        int pageNumber = Integer.parseInt(requestParams.getOrDefault("p", "1"));
        ProductFilter filter = new ProductFilter(requestParams);
        Page<Product> products = productService.allProducts(filter.getSpec(), pageNumber);
        uiModel.addAttribute("products", products);
        uiModel.addAttribute("filterDef", filter.getFilterDef());
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
