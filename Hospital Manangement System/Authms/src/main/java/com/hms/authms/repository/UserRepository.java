package com.hms.authms.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hms.authms.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByEmail(String email);
}