package com.saam3721.gymtrackerbackend.service;

import com.saam3721.gymtrackerbackend.entities.equipment.AddEquipmentRequest;
import com.saam3721.gymtrackerbackend.entities.equipment.Equipment;
import com.saam3721.gymtrackerbackend.repositories.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public void addEquipment(AddEquipmentRequest addEquipmentRequest) {
        Equipment equipment = Equipment
                .builder()
                .equipmentName(addEquipmentRequest.getEquipmentName())
                .description(addEquipmentRequest.getDescription())
                .build();

        equipmentRepository.save(equipment);
    }
}
