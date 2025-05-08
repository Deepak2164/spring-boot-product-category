package com.nimap.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.productapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
