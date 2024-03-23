package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Table(name = "workouts")
@Entity
public class Workout {

    @Id
    @Column(name = "workout_id")
    private UUID workoutId;

    @Column(name = "user_id")
    private UUID userId; // TODO: Use join instead of column in this table

    @Column(name = "workout_name")
    private UUID exerciseId; // TODO: Use join instead of column in this table

    @Column(name = "workout_date")
    private Instant workoutDate;
}