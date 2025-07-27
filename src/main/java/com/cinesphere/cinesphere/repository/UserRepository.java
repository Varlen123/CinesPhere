package com.cinesphere.cinesphere.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinesphere.cinesphere.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findUserByEmail(String email);
}
