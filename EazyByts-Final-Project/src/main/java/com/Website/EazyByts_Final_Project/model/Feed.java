package com.Website.EazyByts_Final_Project.model;

import java.net.URI;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class Feed extends BaseEntity {

	private static final long serialVersionUID = 3667506579600874791L;

	private String author;
	private Instant instant;
	private String title;
	@Lob
	private String entry;
	@Lob
	private URI uri;
	@ManyToOne
	private WebSite webSite;
	@Lob
	private String imageUrl;
	
	@ManyToMany
	@JoinTable(name = "feed_category", joinColumns = @JoinColumn(name = "feed_id"), inverseJoinColumns=@JoinColumn(name = "category_id"))
	private final Set<Category> categories=new HashSet<>();
	
	
}
