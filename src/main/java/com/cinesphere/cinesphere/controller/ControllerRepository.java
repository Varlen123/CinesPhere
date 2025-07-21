package com.cinesphere.cinesphere.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinesphere.cinesphere.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("*/cinesphere/category")
@RequiredArgsConstructor
public class ControllerRepository {

    @Autowired
    private CategoryService categoryService;


    //Mostra as categorias
    @GetMapping()
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    
}