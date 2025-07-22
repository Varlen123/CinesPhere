package com.cinesphere.cinesphere.mapper;

import com.cinesphere.cinesphere.controller.request.CategoryRequest;
import com.cinesphere.cinesphere.controller.response.CategoryResponse;
import com.cinesphere.cinesphere.entity.CategoryEntity;

import lombok.experimental.UtilityClass;
@UtilityClass
public class CategoryMapper {
    public static CategoryEntity toCategory(CategoryRequest categoryRequest){
        return CategoryEntity
        .builder()
        .name(categoryRequest.name())
        .build();
    } 

    public static CategoryResponse toCategoryResponse(CategoryEntity category){
    return new CategoryResponse(
        category.getId(),
        category.getName()
    );
}

}