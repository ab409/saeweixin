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
		sendMsg = new WxSendTextMsg(sendMsg, "�ظ�mm�鿴�����б�,�ظ���Ӧ�����±�ţ���9���鿴��������");
		try {
			/** -------------------1.���ܵ����ı���Ϣ���ظ�����-------------------------- */
			if (msg instanceof WxRecvTextMsg) {
				WxRecvTextMsg recvMsg = (WxRecvTextMsg) msg;
				// �û����������
				String text = recvMsg.getContent().trim();
				
				/** ----------- ��Ϣ�ظ�ʾ�������ֻظ�����(��)ͼ�Ļظ������ֻظ� begin------------- */
				if (text.equals("mm")) {
					sendMsg = new WxSendNewsMsg(sendMsg).addItem("�����б�", "����鿴�����б�", 
							"http://happytravelers.qiniudn.com/liebiao.jpg", 
							"http://happytravelers.sinaapp.com/1/happytravelers/listToUser.action");					
				} 
				
				else if (!Pattern.compile("^\\D$").matcher(text).find()) {
					// �ı���Ϣ�ظ�
					Integer input = Integer.parseInt(text);
					Site site = siteDao.getSiteById(input);
					if(site != null)
						sendMsg = new WxSendNewsMsg(sendMsg).addItem(site.getName(), site.getTitle(), 
								site.getPicture(), "http://happytravelers.sinaapp.com/1/happytravelers/readArticle.action?site.id=" + site.getId());
					else {
						sendMsg = new WxSendTextMsg(sendMsg, "�Ҳ��������£���ȷ�Ϻ�鿴���ظ�mm�鿴�����б�,�ظ���Ӧ�����±�ţ���9���鿴��������");
					}
				} 
				
//				else if (text.equals("mm")) {
//					sendMsg = new WxSendNewsMsg(sendMsg).addItem("ͼ�ı���", "ͼ������", "http://www.baidu.com/img/bdlogo.gif", "http://www.baidu.com/");
//					
//					// ��ͼ������ --ʾ��
//					// .addItem("ͼ�ı���", "ͼ������" ,
//					// "http://www.baidu.com/img/bdlogo.gif",
//					// "http://www.baidu.com/");
//				} 			
			}

			/** -------------------2.���ܵ����¼���Ϣ-------------------------- */
			else if (msg instanceof WxRecvEventMsg) {
				WxRecvEventMsg recvMsg = (WxRecvEventMsg) msg;
				String event = recvMsg.getEvent();

				if ("subscribe".equals(event)) {
					// ������Ϣ
					sendMsg = new WxSendNewsMsg(sendMsg).addItem("лл���Ķ���", "����鿴�����б��ظ���Ӧ���±�ţ���9���鿴��������", 
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
