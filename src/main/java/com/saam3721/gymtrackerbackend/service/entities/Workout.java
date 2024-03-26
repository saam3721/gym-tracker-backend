package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Table(name = "workouts")
@Entity
public class Workout {

    @Id
    @Column(name = "workout_id")
    private UUID workoutId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser applicationUser;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column(name = "repetitions")
    private int repetitions;

    @Column(name = "sets")
    private int sets;

    @Column(name = "weight")
    private float weight;

    @Column(name = "workout_date")
    private Instant workoutDate;

}