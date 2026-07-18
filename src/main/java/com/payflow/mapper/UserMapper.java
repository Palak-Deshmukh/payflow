package com.payflow.mapper;

import com.payflow.dto.request.UserRequest;
import com.payflow.dto.response.UserResponse;
import com.payflow.entity.Users;

public class UserMapper {

    private UserMapper() {
    }

    public static Users toEntity(UserRequest request) {
        if (request == null) {
            return null;
        }

        return Users.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

    public static UserResponse toResponse(Users user) {
        if (user == null) {
            return null;
        }

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}