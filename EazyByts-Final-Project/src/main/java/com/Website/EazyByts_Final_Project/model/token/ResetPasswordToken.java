package com.Website.EazyByts_Final_Project.model.token;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ResetPasswordToken extends Token {
	 
	private static final long serialVersionUID = -4066530423262438566L;

	public ResetPasswordToken(String token) {
		super(token);
		
	}
}