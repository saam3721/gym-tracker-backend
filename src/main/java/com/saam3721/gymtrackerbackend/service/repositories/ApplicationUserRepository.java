package com.saam3721.gymtrackerbackend.service.repositories;

import com.saam3721.gymtrackerbackend.service.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, UUID> {
}
