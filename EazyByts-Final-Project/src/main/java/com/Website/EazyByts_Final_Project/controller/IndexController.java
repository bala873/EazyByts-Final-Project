package com.Website.EazyByts_Final_Project.controller;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.webjars.NotFoundException;

import com.Website.EazyByts_Final_Project.dto.FeedDTO;
import com.Website.EazyByts_Final_Project.model.Category;
import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.UserList;
import com.Website.EazyByts_Final_Project.service.CategoryService;
import com.Website.EazyByts_Final_Project.service.FeedService;
import com.Website.EazyByts_Final_Project.service.UserListService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
@Setter
@ConfigurationProperties(prefix = "feed")
public class IndexController {

	private final FeedService feedService;
	private final CategoryService categoryService;
	private final UserListService userListService;
	private int pageSize;

	@Autowired
	public IndexController(FeedService feedService, CategoryService categoryService, UserListService userListService) {
		super();
		this.feedService = feedService;
		this.categoryService = categoryService;
		this.userListService = userListService;

	}

	@GetMapping("/")
	public String index(Model model, @RequestParam(required = false, value = "tag") String cat_name,
			@RequestParam(required = false, value = "page") Integer page,
			@RequestParam(required = false, value = "list") Long list_id, HttpServletRequest request,
			@AuthenticationPrincipal User user) {

		if (page == null || page == 0) {
			page = 1;
		}
		Page<FeedDTO> results;
		Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("instant").descending());

		// list of websites specified, data fetched only from them
		if (list_id != null) {
			UserList userList = userListService.findListById(list_id);
			if (!userList.getUser().equals(user)) {
				throw new NotFoundException("List not Found");
			}
			results = feedService.fetchFromList(userList, pageable);

			// data fetched from all websites
		} else {
			// no category given
			if (cat_name == null) {
				// check if user has active list that will be shown on home page
				Optional<UserList> activeList=userListService.returnActiveList(user);
				if (activeList.isPresent()) {
					results = feedService.fetchFromList(activeList.get(), pageable);
				} else {
					results = feedService.fetchAll(pageable); // fetchall
				}

			} else {
				Category category = categoryService.findByName(cat_name);
				results = feedService.fetchByCategory(category, pageable); // fetchByCategory
			}
		}
		// calculate and add publishedAgo time to every feed
		feedService.publishedAgo(results, Locale.ENGLISH, ZoneId.systemDefault());

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", results.getTotalPages());
		model.addAttribute("results", results.getContent());

		return "index";
	}

}