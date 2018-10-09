package com.admin.dao;

import java.util.List;

import com.bean.Hangyebean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

public interface XuqiuDao {

	public List<Xuekebean> zhaoxueke();

	public List<Hangyebean> zhaohangye();

	public void addneed(Zhengjibean zhengjibean);

	public List<Zhengjibean> needtiaojianlist(int userid, int status);

	public void needstatusupdate(int id, int i);

	public void needdelete(int id);

	public Zhengjibean needliulan(int id);

	public void needupdate(Zhengjibean zhengjibean);

	public List<Zhengjibean> needneedtatuslist(int i);

	public void addtuihui(Tuihuibean tuihuibean);

	public Tuihuibean findtuihui(int id);

	public Tongjibean tongji();

	

}
