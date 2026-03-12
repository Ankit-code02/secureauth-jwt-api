package com.ankit.ijams.service;

import com.ankit.ijams.entity.User;
import com.ankit.ijams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {

    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    return userRepository.save(user);
    }

    public boolean loginUser(String email, String password) {

    return userRepository.findByEmail(email)
            .map(user -> passwordEncoder.matches(password, user.getPassword()))
            .orElse(false);

}

}