package com.happytravelers.action;

import java.util.Map;

import com.happytravelers.bean.Site;
import com.happytravelers.service.SiteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReadArticleAction extends ActionSupport
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
		Map request = (Map)ActionContext.getContext().get("request");
		
		site = this.siteService.getSiteById(site.getId());
		
		request.put("picURL", site.getPicture());
		
		request.put("article", this.siteService.getRealData(site.getId()).replaceAll(" ", "&nbsp;").replaceAll("\r","<br/>"));
		
		return SUCCESS;
	}
}
