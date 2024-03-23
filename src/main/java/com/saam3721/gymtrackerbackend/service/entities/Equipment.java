package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "equipment")
@Entity
public class Equipment {

    @Id
    @Column(name = "equipment_id")
    private UUID equipmentId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "exercise_id")
    private UUID exerciseId;
}