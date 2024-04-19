package com.saam3721.gymtrackerbackend.controllers;

import com.saam3721.gymtrackerbackend.entities.workout.AddWorkoutRequest;
import com.saam3721.gymtrackerbackend.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/add")
    private ResponseEntity<String> addWorkout(@RequestBody AddWorkoutRequest addWorkoutRequest) {
        workoutService.addWorkout(addWorkoutRequest);
        return ResponseEntity.ok("New workout added successfully");
    }
}
