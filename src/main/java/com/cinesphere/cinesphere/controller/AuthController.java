package com.cinesphere.cinesphere.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinesphere.cinesphere.controller.request.UserRequest;
import com.cinesphere.cinesphere.controller.response.UserResponse;
import com.cinesphere.cinesphere.entity.User;
import com.cinesphere.cinesphere.mapper.UserMapper;
import com.cinesphere.cinesphere.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register (@RequestBody UserRequest userRequest) {
       User savedUser = userService.save(UserMapper.toUser(userRequest));;
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

}
