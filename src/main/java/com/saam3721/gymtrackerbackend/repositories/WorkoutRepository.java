package com.saam3721.gymtrackerbackend.repositories;

import com.saam3721.gymtrackerbackend.entities.ApplicationUser;
import com.saam3721.gymtrackerbackend.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutRepository extends JpaRepository<Workout, UUID> {

    List<Workout> findWorkoutsByApplicationUser(ApplicationUser applicationUser);

}
