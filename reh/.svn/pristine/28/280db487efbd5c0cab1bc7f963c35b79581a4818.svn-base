package com.ree.plug;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.community.communityDao;
import com.ree.hibernate.RepAdminCommunityInfo;

public class GetCommunitybyall extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private communityDao cDao = new communityDao();
	private HashMap<String,Object> store = new HashMap<String,Object>();
	
	private List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
	
	public String execute() throws IOException, ParseException
	{
		list = cDao.GetCommunities_By_All();
		store.put("data", list);
		return SUCCESS;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	
}

