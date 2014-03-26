package com.happytravelers.action;

import java.util.Map;

import com.happytravelers.service.SiteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListToUserAction extends ActionSupport
{
	private SiteService siteService;
	
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
		// TODO �Զ����ɵķ������
		Map request = (Map)ActionContext.getContext().get("request");
		
		request.put("list", this.siteService.getSitesList());
		
		return SUCCESS;
	}
}
