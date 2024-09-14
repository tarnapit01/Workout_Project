package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workout.entity.UserGoal;


public interface UserGoalRepository extends JpaRepository<UserGoal, Integer>  {
    Optional<UserGoal> findByGoalId(int goalId);
}
