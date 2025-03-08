package com.Website.EazyByts_Final_Project.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**", "/images/**", "/css/**","/fonts/**","/js/**","/favicon.ico")
		.addResourceLocations("classpath:/META-INF/resources/webjars/", "classpath:/static/images/",
				"classpath:/static/css/","classpath:/static/fonts/","classpath:/static/js/","classpath:/favicon.ico").resourceChain(false);

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login");
	}
}
