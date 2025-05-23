package com.example.springsecurity.service;

import com.example.springsecurity.controller.models.AuthResponse;
import com.example.springsecurity.controller.models.AuthenticationRequest;
import com.example.springsecurity.controller.models.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);
}
