package com.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.admin.service.Searchservice;
import com.bean.Tiaojianbean;
import com.bean.Zhengjibean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchAction extends ActionSupport implements ModelDriven<Tiaojianbean>{


	private static final long serialVersionUID = -3453281643929589788L;
	private Searchservice searchservice;
	private Tiaojianbean tiaojianbean=new Tiaojianbean();
	public void setSearchservice(Searchservice searchservice) {
		this.searchservice = searchservice;
	}

	public Tiaojianbean getModel() {
		return tiaojianbean;
	}
	public String needjiansuo()
	{
		List<Zhengjibean> zhengjibeanlist=searchservice.needjiansuo(tiaojianbean);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlist);
		return "needjiansuook";
	}
	

}
