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
@Table(name = "userGoals")
public class UserGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId; // Primary key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign key from User table

    @Column(nullable = false)
    private String goalDescription;

    @Column(nullable = false)
    private String currentStatus;

    @Override
    public String toString() {
        return "UserGoal [goalId=" + goalId + ", user=" + user + ", goalDescription=" + goalDescription
                + ", currentStatus=" + currentStatus + "]";
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    
    // Getters and Setters
}
