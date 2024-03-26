package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Table(name = "equipment")
@Entity
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "equipment_id")
    private UUID equipmentId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @OneToMany(mappedBy = "equipment")
    private List<Workout> workouts;

}