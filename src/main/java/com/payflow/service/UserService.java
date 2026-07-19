package com.payflow.service;

import com.payflow.dao.UserDao;
import com.payflow.dao.AuthDao;
import com.payflow.dto.request.UserRequest;
import com.payflow.dto.response.UserResponse;
import com.payflow.entity.Users;
import com.payflow.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthDao authDao;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder, AuthDao authDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.authDao = authDao;
    }

    public UserResponse createUser(UserRequest request) {

        if(authDao.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Users user = UserMapper.toEntity(request);

        user.setPassword(
            passwordEncoder.encode(request.getPassword())
        );

        Users saved = authDao.save(user);

        return UserMapper.toResponse(saved);
    }

    public UserResponse getUserById(Long id) {

        Users user = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toResponse(user);
    }

    public List<UserResponse> getAllUsers() {

        return userDao.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponse updateUser(Long id, UserRequest request) {

        Users existingUser = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        existingUser.setRole(request.getRole());

        Users updatedUser = userDao.save(existingUser);

        return UserMapper.toResponse(updatedUser);
    }

    public void deleteUser(Long id) {

        Users user = userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userDao.delete(user);
    }
}