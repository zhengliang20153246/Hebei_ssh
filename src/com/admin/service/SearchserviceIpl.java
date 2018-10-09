package com.admin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.admin.dao.Searchdao;
import com.bean.Tiaojianbean;
import com.bean.Zhengjibean;

@Transactional
public class SearchserviceIpl implements Searchservice {
	private Searchdao searchdao;

	public void setSearchdao(Searchdao searchdao) {
		this.searchdao = searchdao;
	}

	public List<Zhengjibean> needjiansuo(Tiaojianbean tiaojianbean) {
		List<Zhengjibean> zList=searchdao.needjiansuo(tiaojianbean);
		return zList;
	}

	
	

}
