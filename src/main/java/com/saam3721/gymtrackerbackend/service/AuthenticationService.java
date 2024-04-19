package com.saam3721.gymtrackerbackend.service;

import com.saam3721.gymtrackerbackend.entities.ApplicationUser;
import com.saam3721.gymtrackerbackend.entities.Role;
import com.saam3721.gymtrackerbackend.entities.auth.AuthenticationRequest;
import com.saam3721.gymtrackerbackend.entities.auth.AuthenticationResponse;
import com.saam3721.gymtrackerbackend.entities.auth.RegisterRequest;
import com.saam3721.gymtrackerbackend.repositories.ApplicationUserRepository;
import com.saam3721.gymtrackerbackend.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ApplicationUserRepository applicationUserRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        ApplicationUser applicationUser = ApplicationUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        applicationUserRepository.save(applicationUser);

        String jwt = jwtService.generateToken(applicationUser);

        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                ));
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(applicationUser);

        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
