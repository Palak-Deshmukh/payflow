package com.payflow.service;

import com.payflow.dao.AuthDao;
import com.payflow.dto.request.LoginRequest;
import com.payflow.dto.request.UserRequest;
import com.payflow.dto.response.LoginResponse;
import com.payflow.dto.response.UserResponse;
import com.payflow.entity.Users;
import com.payflow.security.JwtService;
import com.payflow.validator.AuthValidator;

import com.payflow.mapper.UserMapper;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    private final AuthDao authDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthValidator authValidator;

    public AuthService(AuthDao authDao, PasswordEncoder passwordEncoder, 
        JwtService jwtService, AuthValidator authValidator) {
        this.authDao = authDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authValidator = authValidator;
    }

    public UserResponse signup(UserRequest request) {

        authValidator.validateSignup(request);

        if(authDao.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Users user = UserMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Users saved = authDao.save(user);

        return UserMapper.toResponse(saved);
    }

    public LoginResponse login(LoginRequest request) {

        Users user = authDao.findByEmailOrName(request.getEmailOrName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(token, "Login Successful");
    }
}