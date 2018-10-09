package com.admin.action;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.service.Adminservice;
import com.bean.Userbean;

//这是Spring框架集成了JUNIt测试框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminActionTest {
	
	//首先得加载已经写好的adminservice，然后测试里面的login模块
	@Resource(name="adminservice")
	private Adminservice adminservice;

	@Before
	public void setUp() throws Exception {
		System.out.println("登录模块测试开始");
	}

	@Test
	public void testLogin() {
		//环境运行良好，开始测试
		//首先得新建一个用户，设置好用户名和密码
		Userbean userbean=new Userbean();
		userbean.setUsername("admin");
		userbean.setPassword("123456");
		//从数据库查找用户名为admin密码为123456的用户
		//如果找到就输出该用户的信息
		//如果没有找到就输出空
		Userbean login = adminservice.login(userbean);
		System.out.println("信息为："+login);
	}

}
