package com.Website.EazyByts_Final_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.Website.EazyByts_Final_Project.model.Category;
import com.Website.EazyByts_Final_Project.model.WebSite;
import com.Website.EazyByts_Final_Project.repo.WebSiteRepository;

@Service
public class WebSiteService {

	private final WebSiteRepository webSiteRepository;

	@Autowired
	public WebSiteService(WebSiteRepository webSiteRepository) {
		super();
		this.webSiteRepository = webSiteRepository;
	}

	public List<WebSite> findAll() {
		return webSiteRepository.findAll();
	}

	public MultiValueMap<Category, WebSite> orderWebSitesByCategory() {
		List<WebSite> websites = webSiteRepository.findAll();
		MultiValueMap<Category, WebSite> map = new LinkedMultiValueMap<>();
		for (WebSite web : websites) {
			map.add(web.getCategory(), web);
		}
		
		return map;
	}
	

}