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

//����Spring��ܼ�����JUNIt���Կ��
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminActionTest {
	
	//���ȵü����Ѿ�д�õ�adminservice��Ȼ����������loginģ��
	@Resource(name="adminservice")
	private Adminservice adminservice;

	@Before
	public void setUp() throws Exception {
		System.out.println("��¼ģ����Կ�ʼ");
	}

	@Test
	public void testLogin() {
		//�����������ã���ʼ����
		//���ȵ��½�һ���û������ú��û���������
		Userbean userbean=new Userbean();
		userbean.setUsername("admin");
		userbean.setPassword("123456");
		//�����ݿ�����û���Ϊadmin����Ϊ123456���û�
		//����ҵ���������û�����Ϣ
		//���û���ҵ��������
		Userbean login = adminservice.login(userbean);
		System.out.println("��ϢΪ��"+login);
	}

}
