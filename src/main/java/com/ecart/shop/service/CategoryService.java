package com.ecart.shop.service;

import java.util.List;

import com.ecart.shop.domain.Category;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
