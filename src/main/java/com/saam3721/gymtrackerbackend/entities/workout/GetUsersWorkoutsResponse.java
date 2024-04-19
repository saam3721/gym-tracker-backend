package com.saam3721.gymtrackerbackend.entities.workout;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class GetUsersWorkoutsResponse {

    private String equipmentName;
    private String equipmentDescription;
    private int repetitions;
    private int sets;
    private float weight;
    private Instant workoutDate;

}