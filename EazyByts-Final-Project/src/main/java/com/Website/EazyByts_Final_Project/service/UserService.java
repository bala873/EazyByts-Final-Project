package com.Website.EazyByts_Final_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Website.EazyByts_Final_Project.exception.NotFoundException;
import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	// username==email
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));

	}

	public User findUserByEmail(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email).orElseThrow(() -> new NotFoundException("User " + email + " not found"));
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public boolean checkIfUserExists(User user) {

		if (repository.findByEmail(user.getUsername()).isPresent()) {
			return true;
		}

		return false;
	}

}