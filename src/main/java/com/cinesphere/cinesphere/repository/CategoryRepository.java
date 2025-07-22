package com.cinesphere.cinesphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinesphere.cinesphere.entity.CategoryEntity;

@Repository

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}