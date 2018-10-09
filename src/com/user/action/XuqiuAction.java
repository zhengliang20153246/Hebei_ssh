package com.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.admin.service.Xuqiuservice;
import com.bean.Hangyebean;
import com.bean.Tongjibean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class XuqiuAction extends ActionSupport implements ModelDriven<Zhengjibean>{
	
	private static final long serialVersionUID = 1L;
	private Xuqiuservice xuqiuservice;
	private Zhengjibean zhengjibean=new Zhengjibean();
	private String tuihui;
	
	public void setXuqiuservice(Xuqiuservice xuqiuservice) {
		this.xuqiuservice = xuqiuservice;
	}
	public Zhengjibean getModel() {
		return zhengjibean;
	}
	
	
	public String getTuihui() {
		return tuihui;
	}
	public void setTuihui(String tuihui) {
		this.tuihui = tuihui;
	}
	public String tianbao()
	{
		List<Xuekebean> xuekebeanlist=xuqiuservice.zhaoxueke();
		List<Hangyebean> hangyelist=xuqiuservice.zhaohangye();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("xuekeBeans", xuekebeanlist);
		request.setAttribute("hangyeBeans", hangyelist);
		return "tianbao";
		
	}
	public String addneed()
	{
		xuqiuservice.addneed(zhengjibean);
		return "addok";
	}
	public String needhecha()
	{
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtiaojianlist(zhengjibean.getUserid(),zhengjibean.getStatus());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "hechalistok";
	}
	public String needshangchuang()
	{
		xuqiuservice.needshangchuang(zhengjibean.getId());
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtiaojianlist(zhengjibean.getUserid(),0);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
        return "shangchuangok";
        
	}
	public String needdelete()
	{
		xuqiuservice.needdelete(zhengjibean.getId());
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtiaojianlist(zhengjibean.getUserid(),0);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "deleteneedok";
	}
	public String needhechadetail()
	{
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "liulanok";
		
	}
	public String needxiugai()
	{
		xuqiuservice.needupdate(zhengjibean);
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "needxiugaiok";
	}
	public String needlist()
	{
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtatuslist(1);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "listok";
	}
	public String needsearch()
	{
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "searchok";
		
	}
	public String shenhe()
	{
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtatuslist(zhengjibean.getStatus());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "shenhelistok";
	}
	public String shenhedetail()
	{
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "shenhedetailok";
	}
	public String zhengjituihui()
	{
		xuqiuservice.needtuihui(zhengjibean.getId());
		Tuihuibean tuihuibean=new Tuihuibean();
		tuihuibean.setZhengjiid(zhengjibean.getId());
		tuihuibean.setTuihui(tuihui);
		xuqiuservice.addtuihui(tuihuibean);
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "tuihuiok";
	}
	public String zhengjishenehe()
	{
		xuqiuservice.needtongguo(zhengjibean.getId());
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		return "passok";
	}
	public String tuihuiliulan()
	{
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtiaojianlist(zhengjibean.getUserid(),zhengjibean.getStatus());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "tuihuiliulanok";
	}
	public String tuihuineeddelete()
	{
		xuqiuservice.needdelete(zhengjibean.getId());
		List<Zhengjibean>zhengjibeanlis=xuqiuservice.needtiaojianlist(zhengjibean.getUserid(),4);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibeanlist", zhengjibeanlis);
		return "tuihuideleteok";
	}
	public String tuihuiliulandetail()
	{
		Zhengjibean zbean=xuqiuservice.needliulan(zhengjibean.getId());
		Tuihuibean tuihuibean=xuqiuservice.findtuihui(zhengjibean.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("zhengjibean", zbean);
		request.setAttribute("tuihuibean", tuihuibean);
		return "tuihuidetailok";
	}
	public String tongji()
	{
		Tongjibean tongjibean=xuqiuservice.tongji();
		tongjibean.setWeishenhe1(tongjibean.jiussuan(tongjibean.getWeishenhe(), tongjibean.getZong()));
		tongjibean.setShenhe1(tongjibean.jiussuan(tongjibean.getShenhe(), tongjibean.getZong()));
		tongjibean.setTongguo1(tongjibean.jiussuan(tongjibean.getTongguo(), tongjibean.getZong()));
		tongjibean.setTuihui1(tongjibean.jiussuan(tongjibean.getTuihui(), tongjibean.getZong()));
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("tongjibean", tongjibean);
		return "tongjiok";
		
	}
	

}
