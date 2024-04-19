package com.saam3721.gymtrackerbackend.entities.equipment;

import com.saam3721.gymtrackerbackend.entities.Workout;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "equipment")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipment {

    @Id
    @Column(name = "equipment_name")
    private String equipmentName;

    private String description;

    @OneToMany(mappedBy = "equipment")
    private List<Workout> workouts;

}