package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.service.Searchservice;
import com.admin.service.Xuqiuservice;
import com.bean.Tiaojianbean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Zhengjibean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	
	@Resource(name="xuqiuservice")
	private Xuqiuservice xuqiuservice;
	@Resource(name="searchservice")
	private Searchservice searchservice;

	@Test
	public void addneed()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setJiname("Ê¯¼Ò×¯ÌúµÀ´óÑ§");
		xuqiuservice.addneed(zhengjibean);
	}
	@Test
	public void needshangchuang()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setId(14);;
		xuqiuservice.needshangchuang(zhengjibean.getId());
	}
	@Test
	public void needdelete()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setId(14);;
		xuqiuservice.needdelete(zhengjibean.getId());
	}
	@Test
	public void needxiugai()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setId(14);;
		xuqiuservice.needupdate(zhengjibean);
	}
	@Test
	public void needlist()
	{
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtatuslist(1);
		for (Zhengjibean zhengjibean : zhengjibeanlis) {
			System.out.println(zhengjibean);
		}
	}
	@Test
	public void zhengjishenehe()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setId(14);
		xuqiuservice.needtongguo(zhengjibean.getId());
	}
	@Test
	public void zhengjituihui()
	{
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setId(50);
		Tuihuibean tuihuibean=new Tuihuibean();
		tuihuibean.setZhengjiid(zhengjibean.getId());
		tuihuibean.setTuihui("¼ò½éÌ«·±Ëö");
		xuqiuservice.addtuihui(tuihuibean);
	}
	@Test
	public void tongji()
	{
		Tongjibean tongjibean=xuqiuservice.tongji();
		tongjibean.setWeishenhe1(tongjibean.jiussuan(tongjibean.getWeishenhe(), tongjibean.getZong()));
		tongjibean.setShenhe1(tongjibean.jiussuan(tongjibean.getShenhe(), tongjibean.getZong()));
		tongjibean.setTongguo1(tongjibean.jiussuan(tongjibean.getTongguo(), tongjibean.getZong()));
		tongjibean.setTuihui1(tongjibean.jiussuan(tongjibean.getTuihui(), tongjibean.getZong()));
		System.out.println(tongjibean);
	}
	@Test
	public void needjiansuo()
	{
		Tiaojianbean tiaojianbean=new Tiaojianbean();
		tiaojianbean.setXuqiuname("°¢Àï°Í°Í");
		List<Zhengjibean> zhengjibeanlist=searchservice.needjiansuo(tiaojianbean);
		for (Zhengjibean zhengjibean : zhengjibeanlist) {
			System.out.println(zhengjibean);
		}
	}
	
	

}
