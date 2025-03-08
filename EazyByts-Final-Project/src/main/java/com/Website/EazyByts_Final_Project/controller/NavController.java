package com.Website.EazyByts_Final_Project.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.UserList;
import com.Website.EazyByts_Final_Project.service.UserListService;

@ControllerAdvice
public class NavController {

	private final UserListService userListService;

	@Autowired
	public NavController(UserListService userListService) {
		super();
		this.userListService = userListService;
	}
	
	
	
	@ModelAttribute("userLists")
	public Set<UserList> getLists(@AuthenticationPrincipal User user) {
		if (user != null) {
			return userListService.findListByUser(user);
		}
		return null;
	}

}