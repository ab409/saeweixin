package com.using.weixin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ApiTools {

	
	public static void main(String[] args) {
		jokeApi();
	}
	
	/**
	 * 笑话api
	 * @return
	 */
	public static String jokeApi() {
		String json = HttpRequestTools.getHttpClientHtml("http://api.xiaojianjian.net/api/show.action?m=joke");
		JSONObject obj = (JSONObject) JSON.parse(json);
		return obj.get("contextText").toString();
	}
	
	/**
	 * 段子api
	 * @return
	 */
	public static String duanziApi() {
		String json = HttpRequestTools.getHttpClientHtml("http://api.xiaojianjian.net/api/show.action?m=duanzi");
		JSONObject obj = (JSONObject) JSON.parse(json);
		return obj.get("context").toString();
	}
}
