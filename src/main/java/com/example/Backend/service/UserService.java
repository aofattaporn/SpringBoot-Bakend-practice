package com.example.Backend.service;

import com.example.Backend.entity.User;
import com.example.Backend.exception.BaseException;
import com.example.Backend.exception.UserException;
import com.example.Backend.repository.UserRepoository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepoository repository;

    public UserService(UserRepoository repository) {
        this.repository = repository;
    }

    public User create(String email, String password, String name) throws BaseException {
        // validate
        if (Objects.isNull(email)){
            throw UserException.createEmailNull();
        }

        if (Objects.isNull(password)){
            throw UserException.createPasswordNull();
        }

        if (Objects.isNull(name)){
            throw UserException.createNameNull();
        }
        // verify
        if (repository.existsByEmail(email)) {
            throw UserException.createEmailDuplicate();
        }

        // save
        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);

        return repository.save(entity);
    }
}
