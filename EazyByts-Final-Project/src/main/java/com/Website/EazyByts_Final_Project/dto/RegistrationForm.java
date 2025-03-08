package com.Website.EazyByts_Final_Project.dto;

import com.Website.EazyByts_Final_Project.validation.PasswordMatches;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@PasswordMatches(field = "password", fieldMatch = "matchingPassword")
public class RegistrationForm {

	
	@Email(regexp = ".+@.+\\..+")
    private String email;

	@NotBlank
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
	private String password;

	@NotBlank
	private String matchingPassword;

	private String firstName;

	
	private String lastName;


}
