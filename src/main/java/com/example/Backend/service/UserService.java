package com.example.Backend.service;

import com.example.Backend.entity.User;
import com.example.Backend.repository.UserRepoository;

import java.util.Objects;

public class UserService {

    private final UserRepoository repository;

    public UserService(UserRepoository repository) {
        this.repository = repository;
    }

    public User create(String email, String password, String name){
        // validate
        if (Objects.isNull(email)){
//            throw error email
        }

        if (Objects.isNull(password)){
//            throw
        }

        if (Objects.isNull(name)){
//            throw
        }




        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);

        return repository.save(entity);
    }
}
