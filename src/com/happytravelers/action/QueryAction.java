package com.happytravelers.action;

import org.apache.struts2.ServletActionContext;

import com.happytravelers.service.WeixinService;
import com.opensymphony.xwork2.ActionSupport;
import com.using.weixin.wxtools.WeiXinTools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.using.weixin.wxtools.vo.send.WxSendMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvMsg;

public class QueryAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	// token±Í ∂
	private static final String TOKEN = "weixin";
	
	private WeixinService weixinService;
	
	public WeixinService getWeixinService()
	{
		return weixinService;
	}

	public void setWeixinService(WeixinService weixinService)
	{
		this.weixinService = weixinService;
	}

	@Override
	public String execute() throws Exception
	{
		String method = org.apache.struts2.ServletActionContext.getRequest()
				.getMethod();

		boolean isPostMethod = "POST".equalsIgnoreCase(method);
		
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpServletResponse response = ServletActionContext.getResponse();

		if (isPostMethod)
		{
			WxRecvMsg msg = WeiXinTools.recv(request.getInputStream());
			WxSendMsg sendMsg = weixinService.doMsg(msg);
			WeiXinTools.send(sendMsg, response.getOutputStream());
		} else
		{
			confirm(request, response);
		}

		return null;
	}

	public void confirm(HttpServletRequest request, HttpServletResponse response)
	{
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		if (null != timestamp && null != nonce && null != echostr
				&& null != signature)
		{
			if (WeiXinTools.access(TOKEN, signature, timestamp, nonce))
			{
				try
				{
					response.getWriter().write(echostr);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				return;
			}
			return;
		} else
		{
			return;
		}
	}
}
