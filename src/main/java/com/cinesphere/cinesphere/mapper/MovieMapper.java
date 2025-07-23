package com.cinesphere.cinesphere.mapper;

import java.util.List;


import com.cinesphere.cinesphere.controller.request.MovieRequest;
import com.cinesphere.cinesphere.controller.response.CategoryResponse;
import com.cinesphere.cinesphere.controller.response.MovieResponse;
import com.cinesphere.cinesphere.controller.response.StreamingResponse;
import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.entity.Movie;
import com.cinesphere.cinesphere.entity.Streaming;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {
    
    public static Movie toMovie(MovieRequest movieRequest){

        List<CategoryEntity> listCategory = movieRequest.categories().stream()
           .map(category_id -> CategoryEntity.builder().id(category_id).build())
           .toList();

            List<Streaming> listStreaming = movieRequest.streamings().stream()
           .map(streaming_id -> Streaming.builder().id(streaming_id).build())
           .toList();

        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(listCategory)
                .streamings(listStreaming)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie){
      
       List<CategoryResponse> categories = movie.getCategories()
        .stream()
        .map(CategoryMapper::toCategoryResponse)
        .toList();

    List<StreamingResponse> streaming = movie.getStreamings()
        .stream()
        .map(StreamingMapper::toStreamingResponse)
        .toList();
      
        return MovieResponse
                .builder()
                .id(movie.getId())
                .name(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streaming)
                .build();
    }
}