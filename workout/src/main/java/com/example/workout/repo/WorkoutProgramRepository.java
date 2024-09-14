package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workout.entity.WorkoutProgram;

public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Integer>{
    Optional<WorkoutProgram> findByprogramName (String programName);
    
}
