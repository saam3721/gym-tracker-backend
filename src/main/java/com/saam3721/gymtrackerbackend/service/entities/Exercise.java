package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "exercises")
@Entity
public class Exercise {

    @Id
    @Column(name = "exercise_id")
    private UUID exerciseId;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "exercise_description")
    private String exerciseDescription;
}