package com.Website.EazyByts_Final_Project.model.token;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class VerificationToken extends Token  {

	
	private static final long serialVersionUID = 1906905585385535587L;

	public VerificationToken(String token) {
		super(token);
		
	}
}