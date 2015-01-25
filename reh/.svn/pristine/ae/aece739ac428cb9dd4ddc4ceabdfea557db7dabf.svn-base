package com.ree.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminIntentAddrDict;

public class communityJSONAction extends ActionSupport{

	private HashMap<String, Object> root = new LinkedHashMap<String, Object>();
	private java.util.List<RepAdminCommunityInfo> list;

	public java.util.List<RepAdminCommunityInfo> getList() {
		return list;
	}

	public void setList(java.util.List<RepAdminCommunityInfo> list) {
		this.list = list;
	}

	
	public communityJSONAction() {
		// TODO Auto-generated constructor stub
	}
	public String community()
	{
		 SessionHelper s = new SessionHelper();
		List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
		String query_statement = "from com.ree.hibernate.RepAdminCommunityInfo where communityNo!=0";
			Query query = s.getQuery(query_statement);
			list = query.list();
		 this.setList(list);
		 root.put("root", list);
		 s.closeSession();
		return SUCCESS;
	}
	
	public String intent()
	{
		 SessionHelper s = new SessionHelper();
		List<RepAdminIntentAddrDict> list = new ArrayList<RepAdminIntentAddrDict>();
		String query_statement = "from com.ree.hibernate.RepAdminIntentAddrDict where intentAddrNo!=0";
			Query query = s.getQuery(query_statement);
			list = query.list();
		 root.put("root", list);
		 s.closeSession();
		return SUCCESS;
	}

	public HashMap<String, Object> getRoot() {
		return root;
	}

	public void setRoot(HashMap<String, Object> root) {
		this.root = root;
	}

}
