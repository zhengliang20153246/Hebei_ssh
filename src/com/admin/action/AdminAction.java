package com.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.admin.service.Adminservice;
import com.bean.Userbean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Userbean>{
	
	private static final long serialVersionUID = 3499302568688844630L;
	private Userbean userbean=new Userbean();
	private Adminservice adminservice;
	
	public void setAdminservice(Adminservice adminservice) {
		this.adminservice = adminservice;
	}
	public Userbean getModel() {
		// TODO 自动生成的方法存根
		return userbean;
	}
	public String login()
	{
		Userbean userbean1 = adminservice.login(userbean);
		if(userbean1==null)
		{
			return "no";
		}
		else {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userbean1);
			return "yes";
		}
		
	}
	public String userlist()
	{
		List<Userbean> userlist=adminservice.userlist();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Userlists", userlist);
		return "userlistok";
	}
	public String userdelete()
	{
		adminservice.userdelete(userbean);
		return "userdeleteok";
	}
	public String quanxian()
	{
		List<Userbean> userlist=adminservice.userlist();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Userlists", userlist);
		return "quanxian";
	}

}
