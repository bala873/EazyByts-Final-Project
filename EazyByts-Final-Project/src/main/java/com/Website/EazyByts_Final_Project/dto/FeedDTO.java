package com.Website.EazyByts_Final_Project.dto;

import java.net.URI;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.Website.EazyByts_Final_Project.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedDTO {
	
	private String title;
	private String entry;
	private URI uri;
	private Set<Category> categories=new HashSet<>();
	private String publishedAgo;
	private Instant instant;
	private String imageUrl;
}