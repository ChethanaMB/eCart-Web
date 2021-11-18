package com.ecart.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.shop.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String name);
}
