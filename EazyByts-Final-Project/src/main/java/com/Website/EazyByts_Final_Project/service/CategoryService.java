package com.Website.EazyByts_Final_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Website.EazyByts_Final_Project.exception.NotFoundException;
import com.Website.EazyByts_Final_Project.model.Category;
import com.Website.EazyByts_Final_Project.repo.CategoryRepository;

@Service
public class CategoryService{

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	
	public Category findByName(String name) {
		return categoryRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Category " + name + " not found."));
	}

}