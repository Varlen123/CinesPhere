package com.cinesphere.cinesphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.service.CategoryService;

@RestController
@RequestMapping("*/cinesphere/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryEntity> getCategories(){
        return categoryService.getCategories();
    }
}
