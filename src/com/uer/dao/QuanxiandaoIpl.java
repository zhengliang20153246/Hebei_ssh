package com.uer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bean.Juesebean;
import com.bean.Userbean;

public class QuanxiandaoIpl extends HibernateDaoSupport implements Quanxiandao {

	public List<Juesebean> jueselist() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Juesebean.class);
		List<Juesebean> jList = (List<Juesebean>) this.getHibernateTemplate().findByCriteria(criteria);
		return jList;
	}

	public Userbean sesearchusershenfen(int stringToInt) {
		System.out.println(stringToInt);
		Userbean userbean = this.getHibernateTemplate().get(Userbean.class, stringToInt);
		return userbean;
	}

	public Juesebean searchquanxian(String shenfen) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Juesebean.class);
		criteria.add(Restrictions.like("name",shenfen));
		List<Juesebean> jList = (List<Juesebean>) this.getHibernateTemplate().findByCriteria(criteria);
		System.out.println("sss"+jList.get(0));
		return jList.get(0);
	}
	public Juesebean searchquanxianid(int id) {
		Juesebean juesebean = this.getHibernateTemplate().get(Juesebean.class, id);
		return juesebean;
	}

	public void fenpeiquan(int userid, String name) {
		Userbean userbean = this.getHibernateTemplate().get(Userbean.class, userid);
		userbean.setShenfen(name);
		this.getHibernateTemplate().saveOrUpdate(userbean);
		
	}

	public void addjuese(Juesebean juesebean) {
		this.getHibernateTemplate().save(juesebean);
		
	}

	public void feipeiquanxian(Juesebean juesebean) {
		this.getHibernateTemplate().saveOrUpdate(juesebean);
		
	}
	public void deletejuese(int id) {
		Juesebean juesebean = this.getHibernateTemplate().get(Juesebean.class, id);
		this.getHibernateTemplate().delete(juesebean);
		
	}
	

}
