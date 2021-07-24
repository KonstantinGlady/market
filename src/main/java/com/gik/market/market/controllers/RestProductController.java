package com.gik.market.market.controllers;

import com.gik.market.market.entities.Product;
import com.gik.market.market.entities.dto.ProductDto;
import com.gik.market.market.exceptions.ProductNotFoundException;
import com.gik.market.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/products")
public class RestProductController {

    private ProductService productService;

    @Autowired
    public RestProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getAll() {
        return productService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        if (!productService.existsById(id)) {
            throw new ProductNotFoundException("product not exists " + id);
        }
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/dto")
    public List<ProductDto> getAllProductsDto() {
        return productService.getAllBy();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "OK";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        return productService.save(product);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
