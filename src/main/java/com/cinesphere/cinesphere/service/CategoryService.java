package com.cinesphere.cinesphere.service;

import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategories(){
        return categoryRepository.findAll();
    }

    public CategoryEntity saveCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }


    public Optional<CategoryEntity> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
