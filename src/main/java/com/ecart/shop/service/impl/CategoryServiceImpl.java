package com.ecart.shop.service.impl;

import org.springframework.stereotype.Service;

import com.ecart.shop.domain.Category;
import com.ecart.shop.repository.CategoryRepository;
import com.ecart.shop.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
