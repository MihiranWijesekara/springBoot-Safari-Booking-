package com.example.demo.service.impl;

import com.example.demo.dto.SignInRequest;
import com.example.demo.dto.SignInResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SignUpResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new SignUpResponse("Username already exists", null);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new SignUpResponse("Email already exists", null);
        }


        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword()); // Storing plain text password (not recommended for production)
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());

        userRepository.save(user);

        return new SignUpResponse("User registered successfully", user.getUsername());
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findByUsername(signInRequest.getUsername())
                .orElse(null);

        if (user == null || !signInRequest.getPassword().equals(user.getPassword())) {
            return new SignInResponse("Invalid username or password", null, false);
        }

        return new SignInResponse("Login successful", user.getUsername(), true);
    }
}