package com.cinesphere.cinesphere.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoy extends JpaRepository<Category, Long> {
    
}