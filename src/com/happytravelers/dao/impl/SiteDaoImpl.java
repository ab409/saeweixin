package com.happytravelers.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.happytravelers.bean.Site;
import com.happytravelers.dao.SiteDao;

public class SiteDaoImpl extends HibernateDaoSupport implements SiteDao
{

	@Override
	public void save(Site site)
	{
		// TODO �Զ����ɵķ������
		this.getHibernateTemplate().save(site);		
	}

	@Override
	public List<Site> getSitesList()
	{
		// TODO �Զ����ɵķ������
		return this.getHibernateTemplate().find("from Site");
	}

	@Override
	public Site getSiteById(Integer id)
	{
		// TODO �Զ����ɵķ������
		return this.getHibernateTemplate().get(Site.class, id);
	}

	@Override
	public void update(Site site)
	{
		// TODO �Զ����ɵķ������
		this.getHibernateTemplate().update(site);
	}

	@Override
	public void remove(Site site)
	{
		// TODO �Զ����ɵķ������
		this.getHibernateTemplate().delete(site);
	}

	@Override
	public Integer getSitesCount()
	{
		// TODO �Զ����ɵķ������
		return (Integer)this.getHibernateTemplate().find("select count(*) from Site").get(0);
	}

}
