package com.happytravelers.service.impl;

import java.util.List;

import com.happytravelers.bean.Site;
import com.happytravelers.dao.SiteDao;
import com.happytravelers.service.SiteService;

public class SiteServiceImpl implements SiteService
{
	private SiteDao siteDao;
	
	
	public SiteDao getSiteDao()
	{
		return siteDao;
	}

	public void setSiteDao(SiteDao siteDao)
	{
		this.siteDao = siteDao;
	}

	@Override
	public void save(Site site)
	{
		// TODO �Զ����ɵķ������
		siteDao.save(site);
	}

	@Override
	public List<Site> getSitesList()
	{
		// TODO �Զ����ɵķ������
		return siteDao.getSitesList();
	}

	@Override
	public Site getSiteById(Integer id)
	{
		// TODO �Զ����ɵķ������
		return siteDao.getSiteById(id);
	}

	@Override
	public void update(Site site)
	{
		// TODO �Զ����ɵķ������
		siteDao.update(site);
	}

	@Override
	public void remove(Site site)
	{
		// TODO �Զ����ɵķ������
		siteDao.remove(site);
	}

	@Override
	public Integer getSitesCount()
	{
		// TODO �Զ����ɵķ������
		return siteDao.getSitesCount();
	}
	
	@Override
	public String getRealData(Integer id)
	{
		// TODO �Զ����ɵķ������
		Site site = siteDao.getSiteById(id);
		
//		UrlResource urlResource = new UrlResource(site.getContent());
//		
//		return urlResource.getUrlResource();
		
		String content = site.getContent();
		
		return content;
	}

}
