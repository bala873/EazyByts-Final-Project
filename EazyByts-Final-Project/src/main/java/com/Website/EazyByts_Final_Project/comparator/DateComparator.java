package com.Website.EazyByts_Final_Project.comparator;

import java.util.Comparator;

import com.Website.EazyByts_Final_Project.model.Feed;

public class DateComparator implements Comparator<Feed> {
	
	@Override
	public int compare(Feed o1, Feed o2) {
		return o2.getInstant().compareTo(o1.getInstant());
	}

}
