package com.example.workout.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userPrograms")
public class UserProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userProgramId; // Primary key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign key from User table

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private WorkoutProgram workoutProgram; // Foreign key from WorkoutProgram table

    // @Temporal(TemporalType.DATE)
    // private Date startDate;

    // @Temporal(TemporalType.DATE)
    // private Date endDate;

    @Column(nullable = false)
    private String goal;

    @Override
    public String toString() {
        return "UserProgram [userProgramId=" + userProgramId + ", user=" + user + ", workoutProgram=" + workoutProgram
                + ", goal=" + goal + "]";
    }

    public int getUserProgramId() {
        return userProgramId;
    }

    public void setUserProgramId(int userProgramId) {
        this.userProgramId = userProgramId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkoutProgram getWorkoutProgram() {
        return workoutProgram;
    }

    public void setWorkoutProgram(WorkoutProgram workoutProgram) {
        this.workoutProgram = workoutProgram;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    // Getters and Setters
}
