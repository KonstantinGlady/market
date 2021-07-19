package com.gik.market.market.services;

import com.gik.market.market.entities.Product;
import com.gik.market.market.exceptions.ProductNotFoundException;
import com.gik.market.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product editProduct(Product product) {
      return   productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found with id " +id));
    }
}
