package com.happytravelers.dao;

import java.util.List;

import com.happytravelers.bean.Site;

public interface SiteDao
{
	public void save(Site site);
	
	public List<Site> getSitesList();
	
	public Site getSiteById(Integer id);
	
	public void update(Site site);
	
	public void remove(Site site);
	
	public Integer getSitesCount();
}
