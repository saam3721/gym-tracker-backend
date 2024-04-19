package com.saam3721.gymtrackerbackend.controllers;

import com.saam3721.gymtrackerbackend.entities.equipment.AddEquipmentRequest;
import com.saam3721.gymtrackerbackend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addEquipment(@RequestBody AddEquipmentRequest addEquipmentRequest) {
        equipmentService.addEquipment(addEquipmentRequest);
        return ResponseEntity.ok("Equipment " + addEquipmentRequest.getEquipmentName() + " added successfully");
    }

}
