package com.saam3721.gymtrackerbackend.controllers;

import com.saam3721.gymtrackerbackend.entities.ApplicationUser;
import com.saam3721.gymtrackerbackend.repositories.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class ApplicationUserController {

    private ApplicationUserRepository applicationUserRepository;


    @PostMapping("register")
    public ResponseEntity<?> createUser(@RequestBody ApplicationUser newUser) {
        try {
            applicationUserRepository.save(newUser); // TODO: Hash the password before saving it
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}