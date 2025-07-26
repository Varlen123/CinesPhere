package com.cinesphere.cinesphere.service;

import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.entity.User;
import com.cinesphere.cinesphere.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User save (User user) {
        return userRepository.save(user);
    }
}
