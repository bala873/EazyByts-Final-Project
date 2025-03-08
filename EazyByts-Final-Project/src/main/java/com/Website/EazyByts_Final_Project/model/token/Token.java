package com.Website.EazyByts_Final_Project.model.token;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.Website.EazyByts_Final_Project.model.BaseEntity;
import com.Website.EazyByts_Final_Project.model.User;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING)
public abstract class Token extends BaseEntity {

	private static final long serialVersionUID = 4144147332782838684L;
	private static final int EXPIRATION = 60; //min

	private String token;
	@ManyToOne
	private User user;
	private Instant expirationDate;
	
	public Token(String token) {
		super();
		this.token=token;
		expirationDate=calculateExpiryDate(EXPIRATION);
	}

	private Instant calculateExpiryDate(int expiryTimeInMinutes) {
	
		Instant instant=Instant.now();
		return instant.plus(EXPIRATION, ChronoUnit.MINUTES);
		
	}
}