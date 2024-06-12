package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Login;

public interface UserRepository extends MongoRepository<Login, String> {
    Login findByUsername(String username);
}
