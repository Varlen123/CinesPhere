package com.cinesphere.cinesphere.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.repository.CategoryRepositoy;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepositoy categoryRepositoy;
    public List<Category> getCategories(){
        return categoryRepositoy.findAll();
    }
}