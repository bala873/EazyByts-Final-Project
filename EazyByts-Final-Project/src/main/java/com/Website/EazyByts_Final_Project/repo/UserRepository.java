package com.Website.EazyByts_Final_Project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Website.EazyByts_Final_Project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}