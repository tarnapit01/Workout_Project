package com.example.workout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workout.entity.User;
import com.example.workout.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public Optional<User> registerUser(User user) {
        // Check if username or email is already taken
        Optional<User> existingUsername = userRepository.findByUsername(user.getUsername());
        Optional<User> existingEmail = userRepository.findByEmail(user.getEmail());

        if (existingUsername.isPresent()) {
            throw new IllegalStateException("Username already taken");
        }
        
        if (existingEmail.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        // Save the new user if both username and email are unique
        return Optional.of(userRepository.save(user));
    }

    public List<User> getAllusers(){
        return userRepository.findAll();
    }

    public Optional<User> getProgramByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
