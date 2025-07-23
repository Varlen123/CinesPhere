package com.cinesphere.cinesphere.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinesphere.cinesphere.entity.Movie;
import com.cinesphere.cinesphere.mapper.MovieMapper;
import com.cinesphere.cinesphere.controller.request.MovieRequest;
import com.cinesphere.cinesphere.controller.response.MovieResponse;
import com.cinesphere.cinesphere.service.MovieService;

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
    
}