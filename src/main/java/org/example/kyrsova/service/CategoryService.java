package org.example.kyrsova.service;

import org.example.kyrsova.model.Category;
import org.example.kyrsova.repository.AutoPartRepository;
import org.example.kyrsova.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<String> getAllCategoriesNames() {
        return categoryRepository.getAllCategoriesNames();
    }
    public int getCategoryIdByName(String categoryName) {
        return categoryRepository.getCategoryIdByName(categoryName);
    }
    public String getCategoryNameById(int categoryId) {
        return categoryRepository.getCategoryNameById(categoryId);
    }

}
