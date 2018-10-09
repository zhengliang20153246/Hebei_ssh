package com.admin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.admin.dao.Admindao;
import com.bean.Userbean;

@Transactional
public class AdminserviceIpl implements Adminservice {
	private Admindao admindao;
	public void setAdmindao(Admindao admindao) {
		this.admindao = admindao;
	}



	public Userbean login(Userbean userbean) {
		Userbean userbean1 = admindao.login(userbean);
		return userbean1;
		
	}


	
	public void add(Userbean userbean) {
		
		
	}

	public List<Userbean> userlist() {
		List<Userbean> userlist=admindao.userlist();
		return userlist;
	}

	public void userdelete(Userbean userbean) {
		admindao.userdelete(userbean);
		
	}

}
