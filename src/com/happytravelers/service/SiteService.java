package com.happytravelers.service;

import java.util.List;

import com.happytravelers.bean.Site;

public interface SiteService
{
	public void save(Site site);
	
	public List<Site> getSitesList();
	
	public Site getSiteById(Integer id);
	
	public void update(Site site);
	
	public void remove(Site site);
	
	public Integer getSitesCount();
	
	public String getRealData(Integer id);
}
