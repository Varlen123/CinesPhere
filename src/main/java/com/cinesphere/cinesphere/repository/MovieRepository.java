package com.cinesphere.cinesphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinesphere.cinesphere.entity.CategoryEntity;
import com.cinesphere.cinesphere.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<Movie> findMovieByCategories(List <CategoryEntity> categories);

}
