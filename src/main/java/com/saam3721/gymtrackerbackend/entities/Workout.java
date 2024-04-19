package com.saam3721.gymtrackerbackend.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.saam3721.gymtrackerbackend.entities.equipment.Equipment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Table(name = "workouts")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "workoutId")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "workout_id")
    private UUID workoutId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser applicationUser;

    @ManyToOne
    @JoinColumn(name = "equipment_name")
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