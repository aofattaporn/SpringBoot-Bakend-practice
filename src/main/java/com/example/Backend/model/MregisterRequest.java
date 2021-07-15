package com.example.Backend.model;

import lombok.Data;

@Data
public class MregisterRequest {
    private String email;

    private String password;

    private String name;
}
