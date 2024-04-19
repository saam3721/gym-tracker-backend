package com.saam3721.gymtrackerbackend.repositories;

import com.saam3721.gymtrackerbackend.entities.equipment.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
