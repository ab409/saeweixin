package com.using.weixin.wxtools.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.using.weixin.wxtools.vo.recv.WxRecvMsg;
import com.using.weixin.wxtools.vo.send.WxSendMsg;


public final class WxMsgKit {
	
	private static final Map<String, WxRecvMsgParser> recvParserMap = new HashMap<String, WxRecvMsgParser>();
	
	static {
		// �ı���Ϣ��������
		recvParserMap.put("text", new WxRecvTextMsgParser());
		// ������Ϣ��������
		recvParserMap.put("link", new WxRecvLinkMsgParser());
		// ��ַ��Ϣ��������
		recvParserMap.put("location", new WxRecvGeoMsgParser());
		// ͼƬ��Ϣ��������
		recvParserMap.put("image", new WxRecvPicMsgParser());
		// �¼���Ϣ��������
		recvParserMap.put("event", new WxRecvEventMsgParser());
		// ������Ϣ
		recvParserMap.put("voice", new WxRecvVoiceMsgParser());
		
	}
	
	public static WxRecvMsg parse(InputStream in) throws JDOMException, IOException {
		Document dom = new SAXBuilder().build(in);
		Element msgType = dom.getRootElement().getChild("MsgType");
		if(null != msgType) {
			String txt = msgType.getText().toLowerCase();
			WxRecvMsgParser parser = recvParserMap.get(txt);
			if(null != parser) {
				return parser.parser(dom);
			} else {
				System.out.println(txt);
			}
		}
		return null;
	}
	
	public static Document parse(WxSendMsg msg) throws JDOMException {
		return msg.toDocument();
	}
}
