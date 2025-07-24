package com.cinesphere.cinesphere.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cinesphere.cinesphere.entity.Movie;
import com.cinesphere.cinesphere.mapper.MovieMapper;
import com.cinesphere.cinesphere.controller.request.MovieRequest;
import com.cinesphere.cinesphere.controller.response.MovieResponse;
import com.cinesphere.cinesphere.service.MovieService;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cinesphere/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    
    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest movieRequest){
       Movie savedMovie = movieService.save(MovieMapper.toMovie(movieRequest));
       return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(movieService.findAll()
        .stream()
        .map(MovieMapper::toMovieResponse)
        .toList());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable("id")Long id) {
        return movieService.findById(id)
        .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie))).
        orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id,@RequestBody MovieRequest movieRequest){
        return movieService.update(id, MovieMapper.toMovie(movieRequest))
        .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
        .orElse(ResponseEntity.notFound().build());
    }

     @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category) {
        return ResponseEntity.ok(movieService.findByCategory(category)
        .stream()
        .map(MovieMapper::toMovieResponse)
        .toList());
    }

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    Optional<Movie> optMovie = movieService.findById(id);
    if(optMovie.isPresent()){
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.notFound().build();
}
}