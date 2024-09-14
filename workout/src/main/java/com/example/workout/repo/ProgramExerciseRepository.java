package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workout.entity.ProgramExercise;

public interface ProgramExerciseRepository extends JpaRepository<ProgramExercise, Integer>{
    Optional<ProgramExercise> findByProgramExId (int programExId);
}
