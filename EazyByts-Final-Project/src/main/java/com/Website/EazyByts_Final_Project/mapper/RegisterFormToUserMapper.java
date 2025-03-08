package com.Website.EazyByts_Final_Project.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Website.EazyByts_Final_Project.dto.RegistrationForm;
import com.Website.EazyByts_Final_Project.model.User;

@Component
public class RegisterFormToUserMapper {

	public User registerFormToUser(RegistrationForm registerForm, PasswordEncoder encoder) {

		User user = new User();
		user.setEmail(registerForm.getEmail());
		user.setFirstName(registerForm.getFirstName());
		user.setLastName(registerForm.getLastName());
		user.setPassword(encoder.encode(registerForm.getPassword()));

		return user;
	}
}
