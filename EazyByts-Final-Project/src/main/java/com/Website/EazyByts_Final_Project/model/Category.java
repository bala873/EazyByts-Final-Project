package com.Website.EazyByts_Final_Project.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(exclude = {"feeds","webSites"})
public class Category extends BaseEntity {

	private static final long serialVersionUID = -4712248942889122528L;

	@Include
	private String name;

	@ManyToMany(mappedBy = "categories")
	private Set<Feed> feeds = new HashSet<>();


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private Set<WebSite> webSites = new HashSet<>();

}
