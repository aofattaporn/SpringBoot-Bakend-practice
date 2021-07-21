package com.example.Backend.service;

import com.example.Backend.entity.User;
import com.example.Backend.exception.BaseException;
import com.example.Backend.exception.UserException;
import com.example.Backend.repository.UserRepoository;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Data
public class UserService {
    // Dependency injection
    private final UserRepoository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepoository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // create table in register
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
        entity.setPassword(passwordEncoder.encode(password));
        entity.setName(name);

        return repository.save(entity);
    }

    // create
    public Optional<User> findByEmail(String email){
        return repository.findByEmail(email);
    }

    //
    public boolean matchPassword(String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
