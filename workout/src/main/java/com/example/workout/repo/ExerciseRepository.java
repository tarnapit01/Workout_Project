package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workout.entity.Exercise;


public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
    Optional<Exercise> findByExerciseName(String exerciseName);
    
}
