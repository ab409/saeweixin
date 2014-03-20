package com.happytravelers.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource
{
	private String urlString;
	
	public UrlResource(String urlString)
	{
		this.urlString = urlString;
	}
	
	public UrlResource()
	{
		
	}
		
	public String getUrlString()
	{
		return urlString;
	}

	public void setUrlString(String urlString)
	{
		this.urlString = urlString;
	}

	private URLConnection webUrlRequest(String requestUrl)
	{
		try
		{
			return new URL(requestUrl).openConnection();
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private String readLine(InputStream inputStream) throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();

		BufferedReader bufferReader = null;

		try
		{
			bufferReader = new BufferedReader(new InputStreamReader(inputStream));

			String readline;

			while ((readline = bufferReader.readLine()) != null)
			{
				stringBuilder.append(readline);
			}
		} finally
		{
			bufferReader.close();
		}
		
		return stringBuilder.toString();
	}
	
	public String getUrlResource()
	{
		URLConnection webUrlRequest = webUrlRequest(this.getUrlString());
		
		try
		{
			return readLine(webUrlRequest.getInputStream());
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "我尽力了，但是网络确实不给力";
	}
}
