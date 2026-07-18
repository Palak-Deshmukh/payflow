package com.payflow.dto.request;

import com.payflow.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String name;

    private String email;

    private String password;

    private Role role;
}