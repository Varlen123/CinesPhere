package com.cinesphere.cinesphere.controller.request;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;

@Builder
public record MovieRequest (String title,
String description,
LocalDate releaseDate,
double rating,
List<Long> categories,
List<Long> streamings) {
    
}
