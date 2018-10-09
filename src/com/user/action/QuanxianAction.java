package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.Util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.bean.Juesebean;
import com.bean.Userbean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.user.service.Quanxianservice;

public class QuanxianAction extends ActionSupport implements ModelDriven<Juesebean>{
	
	private static final long serialVersionUID = 1L;
	private Quanxianservice quanxianservice;
	private Juesebean juesebean=new Juesebean();
	private String userid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setQuanxianservice(Quanxianservice quanxianservice) {
		this.quanxianservice = quanxianservice;
	}
	public Juesebean getModel() {
		return juesebean;
	}
	public String jueselist()
	{
		List<Juesebean> jList =quanxianservice.jueselist();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(jList));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
	}
	public  String showquanxian()
	{
		
		Userbean userbean =quanxianservice.sesearchusershenfen(StringUtil.StringToInt(userid));
		Juesebean juesebean=quanxianservice.searchquanxian(userbean.getShenfen());
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(juesebean));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String searchquanxian()
	{
		System.out.println(juesebean.getName());
		Juesebean juese=quanxianservice.searchquanxian(juesebean.getName());
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(juese));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String searchquanxianid()
	{
		Juesebean juese=quanxianservice.searchquanxianid(juesebean.getId());
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(juese));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String fenpeijuese()
	{
		Juesebean searchquanxianid = quanxianservice.searchquanxianid(juesebean.getId());
		quanxianservice.fenpeiquan(StringUtil.StringToInt(userid),searchquanxianid.getName());
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString("1"));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String addjuese()
	{
		quanxianservice.addjuese(juesebean);
		List<Juesebean> jList =quanxianservice.jueselist();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(jList));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String feipeiquanxian()
	{
		quanxianservice.feipeiquanxian(juesebean);
		List<Juesebean> jList =quanxianservice.jueselist();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(jList));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String deletejuese()
	{
		quanxianservice.deletejuese(juesebean.getId());
		List<Juesebean> jList =quanxianservice.jueselist();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(jList));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	

}
