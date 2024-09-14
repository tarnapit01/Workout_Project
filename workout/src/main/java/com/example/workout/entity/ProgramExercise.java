package com.example.workout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "programexercises")
public class ProgramExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programExId; // Primary key

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private WorkoutProgram workoutProgram; // Foreign key from WorkoutProgram table

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise; // Foreign key from Exercise table

    @Override
    public String toString() {
        return "ProgramExercise [programExId=" + programExId + ", workoutProgram=" + workoutProgram + ", exercise="
                + exercise + "]";
    }

    public int getProgramExId() {
        return programExId;
    }

    public void setProgramExId(int programExId) {
        this.programExId = programExId;
    }

    public WorkoutProgram getWorkoutProgram() {
        return workoutProgram;
    }

    public void setWorkoutProgram(WorkoutProgram workoutProgram) {
        this.workoutProgram = workoutProgram;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    // Getters and Setters
    
}
