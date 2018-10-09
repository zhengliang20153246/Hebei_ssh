package com.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Juesebean;
import com.bean.Userbean;
import com.uer.dao.Quanxiandao;

@Transactional
public class QuanxianserviceIpl implements Quanxianservice {
	private Quanxiandao quanxiandao;

	public void setQuanxiandao(Quanxiandao quanxiandao) {
		this.quanxiandao = quanxiandao;
	}

	public List<Juesebean> jueselist() {
		List<Juesebean> jList =quanxiandao.jueselist();
		return jList;
	}

	public Userbean sesearchusershenfen(int stringToInt) {
		Userbean userbean =quanxiandao.sesearchusershenfen(stringToInt);
		return userbean;
	}

	public Juesebean searchquanxian(String shenfen) {
		Juesebean juesebean=quanxiandao.searchquanxian(shenfen);
		return juesebean;
	}

	public Juesebean searchquanxianid(int id) {
		Juesebean juesebean=quanxiandao.searchquanxianid(id);
		return juesebean;
	}

	public void fenpeiquan(int userid, String name) {
		quanxiandao.fenpeiquan( userid,  name);
		
	}

	public void addjuese(Juesebean juesebean) {
		quanxiandao.addjuese(juesebean);
		
	}

	public void feipeiquanxian(Juesebean juesebean) {
		quanxiandao.feipeiquanxian(juesebean);
		
	}
	public void deletejuese(int id) {
		quanxiandao.deletejuese(id);
		
	}

	

}
