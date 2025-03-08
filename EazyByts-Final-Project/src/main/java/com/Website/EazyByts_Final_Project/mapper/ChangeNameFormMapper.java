package com.Website.EazyByts_Final_Project.mapper;

import org.springframework.stereotype.Component;

import com.Website.EazyByts_Final_Project.dto.ChangeNameForm;
import com.Website.EazyByts_Final_Project.model.User;

@Component
public class ChangeNameFormMapper {

	public ChangeNameForm userToChangeNameForm(User user) {

		ChangeNameForm nameForm=new ChangeNameForm();
		nameForm.setFirstName(user.getFirstName());
		nameForm.setLastName(user.getLastName());

		return nameForm;
	}

}