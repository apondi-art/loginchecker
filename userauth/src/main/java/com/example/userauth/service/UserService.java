package com.example.userauth.service;

import com.example.userauth.model.User;
import com.example.userauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Marks this class as a service layer 
@Service
public class UserService {
//Injects the UserRepository so we can talk to the database
    @Autowired
    private UserRepository userRepository;

    //Injects a built-in Spring class for hashing passwords securely
    @Autowired
    private PasswordEncoder passwordEncoder;
// Checks if a user with that email already exists 
    public boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false; // email already used
        }

        // encode (hash) the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user); // save user in DB
        return true;
    }
}
