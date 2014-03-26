package com.happytravelers.service;

import com.using.weixin.wxtools.vo.recv.WxRecvMsg;
import com.using.weixin.wxtools.vo.send.WxSendMsg;

public interface WeixinService
{
	WxSendMsg doMsg(WxRecvMsg msg);
}
