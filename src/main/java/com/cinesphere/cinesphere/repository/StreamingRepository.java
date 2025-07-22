package com.cinesphere.cinesphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinesphere.cinesphere.entity.Streaming;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
    
}
