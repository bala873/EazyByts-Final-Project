package com.Website.EazyByts_Final_Project.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Website.EazyByts_Final_Project.model.Feed;
import com.Website.EazyByts_Final_Project.model.WebSite;
import com.Website.EazyByts_Final_Project.service.FeedService;
import com.Website.EazyByts_Final_Project.service.WebSiteService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FetchNewsScheduledTask {

	private final FeedService feedService;
	private final WebSiteService webSiteService;
	private final static int UPDATETIME = 30 * 60000;// 30 min to ms

	@Autowired
	public FetchNewsScheduledTask(FeedService feedService, WebSiteService webSiteService) {
		super();
		this.feedService = feedService;
		this.webSiteService = webSiteService;
	}

	@Scheduled(fixedRate = UPDATETIME)
	public void fetchFeed() {
		// get all websites that we get data from
		
		List<WebSite> sites = webSiteService.findAll();
		try {
			// iterate through all sites
			for (WebSite site : sites) {
				log.debug("Fetching new news from : "+site.getUrl());
				// fetch only new news from particular site

				List<Feed> feeds = feedService.readNewFeeds(site);
				log.debug("Number of news from : "+site.getUrl()+" " + feeds.size());
				// save every new feed in DB
				for (Feed f : feeds) {
					feedService.save(f);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}