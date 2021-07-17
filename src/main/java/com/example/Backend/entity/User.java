package com.example.Backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = "m_user")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

}
