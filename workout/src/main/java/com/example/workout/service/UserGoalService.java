package com.example.workout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workout.entity.UserGoal;
import com.example.workout.repo.UserGoalRepository;

@Service
public class UserGoalService {
    
     @Autowired
    private UserGoalRepository userGoalRepository;

    // Method to add a new goal
    public UserGoal addGoal(UserGoal userGoal) {
        return userGoalRepository.save(userGoal);
    }

    public List<UserGoal> getAllGoals(){
        return userGoalRepository.findAll();
    }

    // Method to get a goal by its ID
    public Optional<UserGoal> getGoalById(int goalId) {
        return userGoalRepository.findById(goalId);
    }

}
