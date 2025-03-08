package com.Website.EazyByts_Final_Project.service.token;

import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.token.Token;

public interface TokenService {

	Token createAndSaveToken(User user,String token);
	Token getToken(String token);
	boolean checkIfExpired(Token token);
	void deleteTokenById(Long Id);
}