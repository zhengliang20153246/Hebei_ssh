package com.admin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bean.Hangyebean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

public class XuqiudaoIpl extends HibernateDaoSupport implements XuqiuDao {

	public List<Xuekebean> zhaoxueke() {
		List<Xuekebean> xList = (List<Xuekebean>) this.getHibernateTemplate().find("from Xuekebean");
		return xList;
	}
	public List<Hangyebean> zhaohangye() {
		// TODO 自动生成的方法存根
		List<Hangyebean> hList = (List<Hangyebean>) this.getHibernateTemplate().find("from Hangyebean");
		return hList;
	}
	public void addneed(Zhengjibean zhengjibean) {
		this.getHibernateTemplate().save(zhengjibean);
		
	}
	public List<Zhengjibean> needtiaojianlist(int userid, int status) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Zhengjibean.class);
		criteria.add(Restrictions.like("userid",userid));
		criteria.add(Restrictions.like("status",status));
		List<Zhengjibean> zhengjibeanlist = (List<Zhengjibean>) this.getHibernateTemplate().findByCriteria(criteria);
		return zhengjibeanlist;
	}
	
	public void needstatusupdate(int id, int i) {
		Zhengjibean zhengjibean = this.getHibernateTemplate().get(Zhengjibean.class, id);
		zhengjibean.setStatus(i);
		this.getHibernateTemplate().save(zhengjibean);
	}
	public void needdelete(int id) {
		Zhengjibean zhengjibean = this.getHibernateTemplate().get(Zhengjibean.class, id);
		this.getHibernateTemplate().delete(zhengjibean);
		
	}
	public Zhengjibean needliulan(int id) {
		Zhengjibean zhengjibean = this.getHibernateTemplate().get(Zhengjibean.class, id);
		return zhengjibean;
	}
	public void needupdate(Zhengjibean zhengjibean) {
		this.getHibernateTemplate().saveOrUpdate(zhengjibean);
		
	}
	public List<Zhengjibean> needneedtatuslist(int i) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Zhengjibean.class);
		criteria.add(Restrictions.like("status",i));
		List<Zhengjibean> zhengjibeanlist = (List<Zhengjibean>) this.getHibernateTemplate().findByCriteria(criteria);
		return zhengjibeanlist;
	}
	public void addtuihui(Tuihuibean tuihuibean) {
		this.getHibernateTemplate().save(tuihuibean);
		
	}
	
	public Tuihuibean findtuihui(int id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Tuihuibean.class);
		criteria.add(Restrictions.like("zhengjiid",id));
		List<Tuihuibean> tuihuibean = (List<Tuihuibean>) this.getHibernateTemplate().findByCriteria(criteria);
		return tuihuibean.get(0);
	}
	public Tongjibean tongji() {
		Tongjibean tongjibean=new Tongjibean();
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(*) from Zhengjibean where status = ?");
		query.setParameter(0, 0);
		List <Number> list= query.list();
		tongjibean.setWeishenhe(list.get(0).intValue());
		
		query.setParameter(0, 1);
		list= query.list();
		tongjibean.setShenhe(list.get(0).intValue());
		
		query.setParameter(0, 3);
		list= query.list();
		tongjibean.setTongguo(list.get(0).intValue());
		
		query.setParameter(0, 4);
		list= query.list();
		tongjibean.setTuihui(list.get(0).intValue());
		tongjibean.setZong();
		return tongjibean;
	}

}
