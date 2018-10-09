package com.admin.dao;

import java.util.List;

import com.bean.Userbean;

public interface Admindao {
	public Userbean login(Userbean userbean);
	public void add(Userbean userbean);
	public List<Userbean> userlist();
	public void userdelete(Userbean userbean);

}
