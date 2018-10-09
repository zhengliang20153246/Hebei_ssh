package com.admin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.admin.dao.XuqiuDao;
import com.bean.Hangyebean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

@Transactional
public class XuqiuserviceIpl implements Xuqiuservice {

	private XuqiuDao xuqiuDao;
	public void setXuqiuDao(XuqiuDao xuqiuDao) {
		this.xuqiuDao = xuqiuDao;
	}
	public List<Xuekebean> zhaoxueke() {
		return xuqiuDao.zhaoxueke();
	}
	public List<Hangyebean> zhaohangye() {
		return xuqiuDao.zhaohangye();
	}
	public void addneed(Zhengjibean zhengjibean) {
		xuqiuDao.addneed(zhengjibean);
		
	}
	public List<Zhengjibean> needtiaojianlist(int userid, int status) {
		List<Zhengjibean>zList= xuqiuDao.needtiaojianlist(userid,status);
		return zList;
	}
	public void needshangchuang(int id) {
		xuqiuDao.needstatusupdate(id, 1);
	}
	public void needdelete(int id) {
		xuqiuDao.needdelete(id);
		
	}
	public Zhengjibean needliulan(int id) {
		Zhengjibean zbean=xuqiuDao.needliulan(id);
		return zbean;
	}
	public void needupdate(Zhengjibean zhengjibean) {
		xuqiuDao.needupdate(zhengjibean);
		
	}
	public List<Zhengjibean> needtatuslist(int i) {
		List<Zhengjibean>zhengjibeanlis=xuqiuDao.needneedtatuslist(i);
		return zhengjibeanlis;
	}
	public void needtuihui(int id) {
		xuqiuDao.needstatusupdate(id, 4);
	}
	public void addtuihui(Tuihuibean tuihuibean) {
		xuqiuDao.addtuihui(tuihuibean);
		
	}
	public void needtongguo(int id) {
		xuqiuDao.needstatusupdate(id, 3);
	}
	public Tuihuibean findtuihui(int id) {
		Tuihuibean tuihuibean=xuqiuDao.findtuihui(id);
		return tuihuibean;
	}
	public Tongjibean tongji() {
		Tongjibean tongjibean=xuqiuDao.tongji();
		return tongjibean;
	}
	

}
