package com.example.mapstruct.repository;


import com.example.mapstruct.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {
    Optional<User> findFirstByEmail(String email);
}
