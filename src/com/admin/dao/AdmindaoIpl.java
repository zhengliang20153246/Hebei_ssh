package com.admin.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bean.Userbean;

public class AdmindaoIpl extends HibernateDaoSupport implements Admindao {

	
	public Userbean login(Userbean userbean) {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Userbean.class);
		dCriteria.add(Restrictions.like("username",userbean.getUsername()));
		dCriteria.add(Restrictions.like("password",userbean.getPassword()));
		List<Userbean> userbeans = (List<Userbean>) this.getHibernateTemplate().findByCriteria(dCriteria);
		if(userbeans.size()==0)
		{
			return null;
		}
		else {
			return userbeans.get(0);
		}
	}

	public void add(Userbean userbean) {
		

	}
	public List<Userbean> userlist() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(Userbean.class);
		List<Userbean> uList = (List<Userbean>) this.getHibernateTemplate().findByCriteria(dCriteria);
		return uList;
	}
	public void userdelete(Userbean userbean) {
		this.getHibernateTemplate().delete(userbean);
		
	}

}
