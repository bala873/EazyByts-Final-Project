package com.Website.EazyByts_Final_Project.dto;

import com.Website.EazyByts_Final_Project.validation.PasswordMatches;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@PasswordMatches(field = "password", fieldMatch = "matchingPassword")
public class ChangePasswordForm {

	@NotBlank
	private String password;

	@NotBlank
	private String matchingPassword;
	
	private String token;
	
	
}
