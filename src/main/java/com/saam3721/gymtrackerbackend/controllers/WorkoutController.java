package com.saam3721.gymtrackerbackend.controllers;

import com.saam3721.gymtrackerbackend.entities.workout.AddWorkoutRequest;
import com.saam3721.gymtrackerbackend.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("myworkouts")
    private ResponseEntity<?> getMyWorkouts() {
        return ResponseEntity.ok(workoutService.getMyWorkouts());
    }
}
