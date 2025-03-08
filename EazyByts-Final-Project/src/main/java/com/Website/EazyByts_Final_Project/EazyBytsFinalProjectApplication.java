package com.Website.EazyByts_Final_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class EazyBytsFinalProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EazyBytsFinalProjectApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EazyBytsFinalProjectApplication.class);
	}
}
