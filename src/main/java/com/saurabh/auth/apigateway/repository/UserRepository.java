package com.saurabh.auth.apigateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.auth.apigateway.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Boolean existsByEmail(String email);

	Boolean existsByUsername(String username);

}
