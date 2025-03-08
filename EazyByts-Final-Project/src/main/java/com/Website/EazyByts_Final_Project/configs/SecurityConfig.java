package com.Website.EazyByts_Final_Project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/h2-console/**");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/settings/**", "/list/**").authenticated()
                .requestMatchers("/").permitAll()
            )
            .formLogin((form) -> form
                .loginPage("/login")
            )
            .logout((logout) -> logout
                .deleteCookies("JSESSIONID")
            )
            .rememberMe((rememberMe) -> rememberMe
                .key("uniqueAndSecret")
            );

        return http.build();
	}

}
