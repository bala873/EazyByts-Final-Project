package com.Website.EazyByts_Final_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Website.EazyByts_Final_Project.model.Feed;
import com.Website.EazyByts_Final_Project.model.WebSite;
import com.Website.EazyByts_Final_Project.service.FeedService;
import com.Website.EazyByts_Final_Project.service.WebSiteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FeedController {

	private final FeedService feedService;
	private final WebSiteService webSiteService;

	@Autowired
	public FeedController(FeedService feedService, WebSiteService webSiteService) {
		super();
		this.feedService = feedService;
		this.webSiteService = webSiteService;
	}

	@GetMapping("/fetch")
	public String fetchFeed() {
		// get all websites that we get data from
		List<WebSite> sites = webSiteService.findAll();
		
		try {
			// iterate through all sites
			for (WebSite site : sites) {
				// fetch only new news from particular site
				log.debug("Fetching new news from : "+site.getUrl());
				List<Feed> feeds = feedService.readNewFeeds(site);

				// fetch only new news from particular site

				log.debug("Number of news from : "+site.getUrl()+" " + feeds.size());
				// save every new feed in DB
				for (Feed f : feeds) {
					feedService.save(f);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}
}