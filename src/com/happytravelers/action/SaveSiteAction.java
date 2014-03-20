package com.happytravelers.action;

import com.happytravelers.bean.Site;
import com.happytravelers.service.SiteService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveSiteAction extends ActionSupport
{
	private Site site;
	
	private SiteService siteService;

	public Site getSite()
	{
		return site;
	}

	public void setSite(Site site)
	{
		this.site = site;
	}

	public SiteService getSiteService()
	{
		return siteService;
	}

	public void setSiteService(SiteService siteService)
	{
		this.siteService = siteService;
	}
	
	@Override
	public String execute() throws Exception
	{
		// TODO 自动生成的方法存根
		this.siteService.save(site);
		return SUCCESS;
	}
}
