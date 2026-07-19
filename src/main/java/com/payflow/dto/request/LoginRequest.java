package com.payflow.dto.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String emailOrName;
    private String password;
}