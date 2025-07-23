package com.cinesphere.cinesphere.controller.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;

@Builder
public record MovieResponse(
Long id, 
String name, 
String description, 
LocalDate releaseDate,
double rating, 
List<CategoryResponse> categories, 
List<StreamingResponse> streamings) {
    
}
