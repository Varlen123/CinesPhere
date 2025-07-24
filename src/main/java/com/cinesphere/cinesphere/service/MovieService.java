package com.cinesphere.cinesphere.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.entity.Movie;
import com.cinesphere.cinesphere.entity.Streaming;
import com.cinesphere.cinesphere.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final StreamingService streamingService;
    private final CategoryService categoryService;

    public Movie save(Movie movie){
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        movie.setCategories(this.findCategories(movie.getCategories()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> update (Long movieId, Movie movie){
        Optional<Movie> optbById = movieRepository.findById(movieId);
        if(optbById.isPresent()){
            Movie movieFound = optbById.get();
            movieFound.setTitle(movie.getTitle());
            movieFound.setDescription(movie.getDescription());
            movieFound.setReleaseDate(movie.getReleaseDate());
            movieFound.setRating(movie.getRating());
            movieFound.setStreamings(this.findStreamings(movie.getStreamings()));
            movieFound.setCategories(this.findCategories(movie.getCategories()));

            movieFound.getStreamings().clear();
            movieFound.getCategories().clear();

            movieFound.getStreamings().addAll(movie.getStreamings());
            movieFound.getCategories().addAll(movie.getCategories());

            movieRepository.save(movieFound);

            return Optional.of(movieFound);
        }
        return Optional.empty();
    }

    private List<CategoryEntity> findCategories(List<CategoryEntity> categories){
        List<CategoryEntity> categoriesFound = new ArrayList<>();
       categories.forEach(category -> categoryService.getCategoryById(category.getId()).ifPresent(categoriesFound::add));
       return categoriesFound;
    }

private List<Streaming> findStreamings(List<Streaming> streamings){
    List<Streaming> streamingsFound = new ArrayList<>();
    streamings.forEach(streaming -> streamingService.getStreamingById(streaming.getId()).ifPresent(streamingsFound::add));
    return streamingsFound;
}



}