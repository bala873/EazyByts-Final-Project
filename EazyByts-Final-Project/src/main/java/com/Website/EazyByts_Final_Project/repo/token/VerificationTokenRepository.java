package com.Website.EazyByts_Final_Project.repo.token;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.token.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	Optional<VerificationToken> getByToken(String token);
	VerificationToken findByUser(User user);
	
}