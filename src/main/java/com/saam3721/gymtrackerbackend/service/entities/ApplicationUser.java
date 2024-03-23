package com.saam3721.gymtrackerbackend.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "application_users")
@Entity
public class ApplicationUser {

    @Id
    @Column(name = "user_id")
    private UUID UserId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}