package com.gik.market.market.services;

import com.gik.market.market.entities.Product;
import com.gik.market.market.entities.dto.ProductDto;
import com.gik.market.market.exceptions.ProductNotFoundException;
import com.gik.market.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> allProducts(Specification<Product> spec, int page) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found with id " + id));
    }

    public List<ProductDto> getAllBy() {
        return productRepository.getAllBy();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return  productRepository.save(product);
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}
