package com.Website.EazyByts_Final_Project.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false,exclude = {"webSites"})
public class UserList extends BaseEntity {

	private static final long serialVersionUID = -1897286705997464492L;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]+{8}$")
	@Length(max = 8)
	private String name;
	
	@ManyToOne
	private User user;
	
	//list active as home page for user
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "userlist_webSite", joinColumns = @JoinColumn(name = "userlist_id"), inverseJoinColumns = @JoinColumn(name = "webSite_id"))
	private Set<WebSite> webSites = new HashSet<>();

}