package com.saam3721.gymtrackerbackend.service;

import com.saam3721.gymtrackerbackend.entities.ApplicationUser;
import com.saam3721.gymtrackerbackend.entities.Workout;
import com.saam3721.gymtrackerbackend.entities.workout.AddWorkoutRequest;
import com.saam3721.gymtrackerbackend.entities.workout.GetUsersWorkoutsResponse;
import com.saam3721.gymtrackerbackend.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public void addWorkout(AddWorkoutRequest addWorkoutRequest) {
        ApplicationUser currentAuthenticatedUser = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Instant now = Instant.now();
        Workout workout = Workout
                .builder()
                .applicationUser(currentAuthenticatedUser)
                .equipment(addWorkoutRequest.getEquipment())
                .repetitions(addWorkoutRequest.getRepetitions())
                .sets(addWorkoutRequest.getSets())
                .weight(addWorkoutRequest.getWeight())
                .workoutDate(now)
                .build();

        workoutRepository.save(workout);
    }

    public List<GetUsersWorkoutsResponse> getMyWorkouts() {
        ApplicationUser currentAuthenticatedUser = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Workout> usersWorkouts = workoutRepository.findWorkoutsByApplicationUser(currentAuthenticatedUser);

        return usersWorkouts.stream()
                .map(workout -> new GetUsersWorkoutsResponse(
                        workout.getEquipment().getEquipmentName(),
                        workout.getEquipment().getDescription(),
                        workout.getRepetitions(),
                        workout.getSets(),
                        workout.getWeight(),
                        workout.getWorkoutDate()
                ))
                .toList();
    }

}
