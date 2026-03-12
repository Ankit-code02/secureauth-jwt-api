package com.ankit.ijams.controller;

import com.ankit.ijams.entity.User;
import com.ankit.ijams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ankit.ijams.dto.LoginRequest;
import com.ankit.ijams.security.JwtUtil;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
public String loginUser(@RequestBody LoginRequest loginRequest) {

    boolean isAuthenticated = userService.loginUser(
            loginRequest.getEmail(),
            loginRequest.getPassword()
    );

    if (isAuthenticated) {
        return jwtUtil.generateToken(loginRequest.getEmail());
    } else {
        return "Invalid email or password";
    }
}
@GetMapping("/profile")
public String getProfile() {
    return "This is a protected user profile endpoint";
}
}