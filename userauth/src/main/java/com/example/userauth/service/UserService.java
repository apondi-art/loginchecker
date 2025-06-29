package com.example.userauth.service;

import com.example.userauth.model.User;
import com.example.userauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🔹 Registers a new user
    public boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false; // email already used
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    // 🔹 Finds a user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
