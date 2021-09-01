package com.react.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.react.app.model.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
}
