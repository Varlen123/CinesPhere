package com.cinesphere.cinesphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinesphere.cinesphere.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
