package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Table(name = "application_users")
@Entity
@Data
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "applicationUser")
    private List<Workout> workouts;

}