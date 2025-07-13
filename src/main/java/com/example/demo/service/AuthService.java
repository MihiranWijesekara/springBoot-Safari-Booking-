package com.example.demo.service;

import com.example.demo.dto.SignInRequest;
import com.example.demo.dto.SignInResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.SignUpResponse;

public interface AuthService {
    SignUpResponse signUp(SignUpRequest signUpRequest);
    SignInResponse signIn(SignInRequest signInRequest);
}