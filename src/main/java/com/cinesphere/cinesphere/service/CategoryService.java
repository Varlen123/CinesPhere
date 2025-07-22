package com.cinesphere.cinesphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepositoy;

    public List<CategoryEntity> getCategories(){
        return categoryRepositoy.findAll();
    }
}
