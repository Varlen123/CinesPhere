package com.cinesphere.cinesphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cinesphere.cinesphere.controller.request.CategoryRequest;
import com.cinesphere.cinesphere.controller.response.CategoryResponse;
import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.mapper.CategoryMapper;
import com.cinesphere.cinesphere.service.CategoryService;

@RestController
@RequestMapping("/cinesphere/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<CategoryEntity> categories = categoryService.getCategories();
        List<CategoryResponse> responseList = categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(responseList);
    }



    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request){
       CategoryEntity newCategory = CategoryMapper.toCategory(request);
       CategoryEntity category = categoryService.saveCategory(newCategory);
       return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id){
    return categoryService.getCategoryById(id)
    .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
    .orElse(ResponseEntity.notFound().build());
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
