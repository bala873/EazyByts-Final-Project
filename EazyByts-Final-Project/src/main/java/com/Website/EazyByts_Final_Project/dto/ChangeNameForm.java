package com.Website.EazyByts_Final_Project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class ChangeNameForm {

	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;


}