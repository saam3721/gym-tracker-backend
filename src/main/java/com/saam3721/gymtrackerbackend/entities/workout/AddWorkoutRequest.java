package com.saam3721.gymtrackerbackend.entities.workout;

import com.saam3721.gymtrackerbackend.entities.equipment.Equipment;
import lombok.Data;

@Data
public class AddWorkoutRequest {

    private Equipment equipment;
    private int repetitions;
    private int sets;
    private float weight;

}
