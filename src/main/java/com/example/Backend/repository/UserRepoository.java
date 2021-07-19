package com.example.Backend.repository;

import com.example.Backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepoository extends CrudRepository<User, String> {


    Optional<User> findByEmail(String email);


    boolean existsByEmail(String email);
}
