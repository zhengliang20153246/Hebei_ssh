package com.user.service;

import java.util.List;

import com.bean.Juesebean;
import com.bean.Userbean;

public interface Quanxianservice {

	List<Juesebean> jueselist();

	Userbean sesearchusershenfen(int stringToInt);

	Juesebean searchquanxian(String shenfen);

	Juesebean searchquanxianid(int id);

	public void fenpeiquan(int userid, String name);

	public void addjuese(Juesebean juesebean);

	void feipeiquanxian(Juesebean juesebean);

	void deletejuese(int i);

}
