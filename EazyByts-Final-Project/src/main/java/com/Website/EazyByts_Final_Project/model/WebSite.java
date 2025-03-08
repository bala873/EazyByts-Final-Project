package com.Website.EazyByts_Final_Project.model;

import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.annotations.SortComparator;

import com.Website.EazyByts_Final_Project.comparator.DateComparator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(exclude = "feeds")
public class WebSite extends BaseEntity {

	private static final long serialVersionUID = -3011921260852414106L;
	@Include
	private URL url;
	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "webSite")
	@SortComparator(DateComparator.class)
	private Set<Feed> feeds = new TreeSet<>();
	
}

