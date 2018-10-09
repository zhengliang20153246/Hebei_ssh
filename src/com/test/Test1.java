package com.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.admin.service.Adminservice;
import com.bean.Userbean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {
	
	@Resource(name="adminservice")
	Adminservice adminservice;

	
	
	@Test
	public void login()
	{
		Userbean userbean=new Userbean();
		userbean.setUsername("admin");
		userbean.setPassword("123456");
		Userbean login = adminservice.login(userbean);
		System.out.println(login);
	}
	@Test
	public void delete()
	{
		Userbean userbean=new Userbean();
		userbean.setId(13);
		adminservice.userdelete(userbean);
	}
	@Test
	public void list()
	{
		List<Userbean> userlist=adminservice.userlist();
		for (Userbean userbean : userlist) {
			System.out.println(userbean);
		}
	}
	
		
		
}
