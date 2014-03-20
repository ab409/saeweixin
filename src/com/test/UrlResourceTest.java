package com.test;

import com.happytravelers.util.UrlResource;

public class UrlResourceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		UrlResource urlResource = new UrlResource("http://happytravelers.qiniudn.com/beijing.txt");
		String text = urlResource.getUrlResource();
		System.out.println(text);
	}

}
