package com.nimap.productapp.controller;

import com.nimap.productapp.model.Product;
import com.nimap.productapp.model.Category;
import com.nimap.productapp.repository.ProductRepository;
import com.nimap.productapp.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    // ✅ 1. Create Product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepo.findById(product.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        return productRepo.save(product);
    }

    // ✅ 2. Get all products with pagination
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepo.findAll(pageable);
    }
}
