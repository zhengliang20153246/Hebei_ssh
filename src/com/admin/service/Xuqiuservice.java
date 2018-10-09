package com.admin.service;

import java.util.List;

import com.bean.Hangyebean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

public interface Xuqiuservice {

	public List<Xuekebean> zhaoxueke();

	public List<Hangyebean> zhaohangye();

	public void addneed(Zhengjibean zhengjibean);

	public List<Zhengjibean> needtiaojianlist(int userid, int status);

	public void needshangchuang(int id);

	public void needdelete(int id);

	public Zhengjibean needliulan(int id);

	public void needupdate(Zhengjibean zhengjibean);

	public List<Zhengjibean> needtatuslist(int i);

	public void needtuihui(int id);

	public void addtuihui(Tuihuibean tuihuibean);

	public void needtongguo(int id);

	public Tuihuibean findtuihui(int id);

	public Tongjibean tongji();

}
