package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workout.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(int userId);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
