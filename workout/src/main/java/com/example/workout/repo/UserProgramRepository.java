package com.example.workout.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workout.entity.UserProgram;


public interface UserProgramRepository extends JpaRepository<UserProgram, Integer>{
    Optional<UserProgram> findByUserProgramId(int userProgramId);
}
