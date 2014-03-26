package com.happytravelers.bean;

public class Site
{
	private Integer id;
	
	private String name;
	
	private String title;
	
	private String picture;
	
	private String content;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getPicture()
	{
		return picture;
	}

	public void setPicture(String picture)
	{
		this.picture = picture;
	}

	public String getContent()
	{		
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
