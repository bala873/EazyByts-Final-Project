package com.Website.EazyByts_Final_Project.events;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.Website.EazyByts_Final_Project.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7074134939627530642L;

	private String appUrl;
	private Locale locale;
	private User user;

	public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
		super(user);

		this.user=user;
		this.locale = locale;
		this.appUrl = appUrl;
	}

}