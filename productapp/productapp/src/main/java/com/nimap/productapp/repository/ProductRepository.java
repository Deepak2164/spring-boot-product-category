package com.nimap.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.productapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
