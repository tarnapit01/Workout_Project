package com.example.workout.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.entity.User;
import com.example.workout.entity.UserGoal;
import com.example.workout.entity.WorkoutProgram;
import com.example.workout.service.UserGoalService;
import com.example.workout.service.UserService;
import com.example.workout.service.WorkoutProgramService;



@RestController
@RequestMapping("/api/workoutprograms")
public class WebController {

    @Autowired
    private WorkoutProgramService workoutProgramService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserGoalService userGoalService;


    // Get workout program by program name
    @GetMapping("/workouts")
    public ResponseEntity<WorkoutProgram> getProgramByName(@RequestParam String programName) {
        Optional<WorkoutProgram> program = workoutProgramService.getProgramByName(programName);
        if (program.isPresent()) {
            return ResponseEntity.ok(program.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET endpoint to retrieve all workout programs
    @GetMapping("/workouts/all")
    public ResponseEntity<List<WorkoutProgram>> getAllWorkoutPrograms() {
        List<WorkoutProgram> programs = workoutProgramService.getAllPrograms();
        return ResponseEntity.ok(programs);
    }
    
    // POST endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET endpoint to retrieve user by username
    @GetMapping("/GET/register")
    public ResponseEntity<User> getUserById(@RequestParam String username) {
        Optional<User> user = userService.getProgramByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if user is not found
        }
    }

    // GET endpoint to retrieve all users
    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllusers();
        return ResponseEntity.ok(users);
    }

    // POST endpoint to add a new user goal
    @PostMapping("/addGoal")
    public ResponseEntity<UserGoal> addGoal(@RequestBody UserGoal userGoal) {
        try {
            UserGoal savedGoal = userGoalService.addGoal(userGoal);
            return ResponseEntity.ok(savedGoal);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Handle exceptions accordingly
        }
    }

    // GET endpoint to retrieve a user goal by ID
    @GetMapping("/GET/goal")
    public ResponseEntity<UserGoal> getGoalById(@RequestParam int goalId) {
        Optional<UserGoal> userGoal = userGoalService.getGoalById(goalId);
        if (userGoal.isPresent()) {
            return ResponseEntity.ok(userGoal.get());
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if goal is not found
        }
    }

     // GET endpoint to retrieve all user goals
     @GetMapping("/goals/all")
     public ResponseEntity<List<UserGoal>> getAllGoals() {
         List<UserGoal> goals = userGoalService.getAllGoals();
         return ResponseEntity.ok(goals);
     }
}
