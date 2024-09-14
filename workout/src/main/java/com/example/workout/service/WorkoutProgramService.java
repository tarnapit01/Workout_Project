package com.example.workout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workout.entity.WorkoutProgram;
import com.example.workout.repo.WorkoutProgramRepository;

@Service
public class WorkoutProgramService {

    @Autowired
    private WorkoutProgramRepository workoutProgramRepository;

    // Get all workout programs
    public List<WorkoutProgram> getAllPrograms() {
        return workoutProgramRepository.findAll();
    }

    // Get a workout program by ID
    public Optional<WorkoutProgram> getProgramByName(int programName) {
        return workoutProgramRepository.findById(programName);
    }

    // Add or save a new workout program
    public WorkoutProgram saveProgram(WorkoutProgram workoutProgram) {
        return workoutProgramRepository.save(workoutProgram);
    }

    // Update a workout program by ID
    public Optional<WorkoutProgram> updateProgram(int programId, WorkoutProgram updatedProgram) {
        return workoutProgramRepository.findById(programId).map(program -> {
            program.setProgramName(updatedProgram.getProgramName());
            program.setDescription(updatedProgram.getDescription());
            program.setTargetMuscle(updatedProgram.getTargetMuscle());
            program.setWorkoutProgramscol(updatedProgram.getWorkoutProgramscol());
            program.setVideoUrl(updatedProgram.getVideoUrl());
            return workoutProgramRepository.save(program);
        });
    }

    // Delete a workout program by ID
    public boolean deleteProgramById(int programId) {
        if (workoutProgramRepository.existsById(programId)) {
            workoutProgramRepository.deleteById(programId);
            return true;
        }
        return false;
    }

    // Get workout program by program name
    public Optional<WorkoutProgram> getProgramByName(String programName) {
        return workoutProgramRepository.findByprogramName(programName);
    }
}

