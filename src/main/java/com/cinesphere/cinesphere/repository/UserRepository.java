package com.cinesphere.cinesphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinesphere.cinesphere.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
