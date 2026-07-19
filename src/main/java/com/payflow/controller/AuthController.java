package com.payflow.controller;

import com.payflow.dto.request.LoginRequest;
import com.payflow.dto.request.UserRequest;
import com.payflow.dto.response.LoginResponse;
import com.payflow.dto.response.UserResponse;
import com.payflow.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public UserResponse signup(@RequestBody UserRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}