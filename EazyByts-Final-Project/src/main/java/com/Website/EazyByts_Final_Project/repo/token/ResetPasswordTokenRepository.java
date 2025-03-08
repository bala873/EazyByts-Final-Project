package com.Website.EazyByts_Final_Project.repo.token;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.token.ResetPasswordToken;

@Repository
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Long> {

	Optional<ResetPasswordToken> getByToken(String token);
	ResetPasswordToken findByUser(User user);
	
}