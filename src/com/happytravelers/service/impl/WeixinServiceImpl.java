package com.happytravelers.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.happytravelers.bean.Site;
import com.happytravelers.dao.SiteDao;
import com.happytravelers.service.WeixinService;
import com.using.weixin.common.ApiTools;
import com.using.weixin.wxtools.WeiXinTools;
import com.using.weixin.wxtools.vo.recv.WxRecvEventMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvGeoMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvPicMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvTextMsg;
import com.using.weixin.wxtools.vo.recv.WxRecvVoiceMsg;
import com.using.weixin.wxtools.vo.send.WxSendMsg;
import com.using.weixin.wxtools.vo.send.WxSendMusicMsg;
import com.using.weixin.wxtools.vo.send.WxSendNewsMsg;
import com.using.weixin.wxtools.vo.send.WxSendTextMsg;

public class WeixinServiceImpl implements WeixinService
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
	public WxSendMsg doMsg(WxRecvMsg msg)
	{
		WxSendMsg sendMsg = WeiXinTools.builderSendByRecv(msg);
		sendMsg = new WxSendTextMsg(sendMsg, "回复mm查看文章列表,回复对应的文章编号，如9，查看文章内容");
		try {
			/** -------------------1.接受到的文本消息，回复处理-------------------------- */
			if (msg instanceof WxRecvTextMsg) {
				WxRecvTextMsg recvMsg = (WxRecvTextMsg) msg;
				// 用户输入的内容
				String text = recvMsg.getContent().trim();
				
				/** ----------- 消息回复示例：文字回复、单(多)图文回复、音乐回复 begin------------- */
				if (text.equals("mm")) {
					sendMsg = new WxSendNewsMsg(sendMsg).addItem("文章列表", "点击查看文章列表", 
							"http://happytravelers.qiniudn.com/liebiao.jpg", 
							"http://happytravelers.sinaapp.com/1/happytravelers/listToUser.action");					
				} 
				
				else if (!Pattern.compile("^\\D$").matcher(text).find()) {
					// 文本消息回复
					Integer input = Integer.parseInt(text);
					Site site = siteDao.getSiteById(input);
					if(site != null)
						sendMsg = new WxSendNewsMsg(sendMsg).addItem(site.getName(), site.getTitle(), 
								site.getPicture(), "http://happytravelers.sinaapp.com/1/happytravelers/readArticle.action?site.id=" + site.getId());
					else {
						sendMsg = new WxSendTextMsg(sendMsg, "找不到该文章，请确认后查看。回复mm查看文章列表,回复对应的文章编号，如9，查看文章内容");
					}
				} 
				
//				else if (text.equals("mm")) {
//					sendMsg = new WxSendNewsMsg(sendMsg).addItem("图文标题", "图文描述", "http://www.baidu.com/img/bdlogo.gif", "http://www.baidu.com/");
//					
//					// 多图文内容 --示例
//					// .addItem("图文标题", "图文描述" ,
//					// "http://www.baidu.com/img/bdlogo.gif",
//					// "http://www.baidu.com/");
//				} 			
			}

			/** -------------------2.接受到的事件消息-------------------------- */
			else if (msg instanceof WxRecvEventMsg) {
				WxRecvEventMsg recvMsg = (WxRecvEventMsg) msg;
				String event = recvMsg.getEvent();

				if ("subscribe".equals(event)) {
					// 订阅消息
					sendMsg = new WxSendNewsMsg(sendMsg).addItem("谢谢您的订阅", "点击查看文章列表，回复相应文章编号，如9，查看文章内容", 
							"http://happytravelers.qiniudn.com/liebiao.jpg", 
							"http://happytravelers.sinaapp.com/1/happytravelers/listToUser.action");
				} 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendMsg;
	}

}
