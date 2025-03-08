package com.Website.EazyByts_Final_Project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Website.EazyByts_Final_Project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<Category> findByName(String name);
}
