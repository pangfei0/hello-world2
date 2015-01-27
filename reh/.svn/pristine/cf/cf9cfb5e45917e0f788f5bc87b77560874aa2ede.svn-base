package com.reh.newslist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminList;
import com.ree.list.ListDao;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private List<RepAdminList> list = null;
	private HashMap<String, Object> store = new HashMap<String, Object>();
	private ListDao lDao = new ListDao();

	@Override
    public String execute() throws Exception {
    	 list=new ArrayList<RepAdminList>();
    	 list=lDao.GetList_By_All();
    	 store.put("data", list);
    	return SUCCESS;
    }

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}

	public List<RepAdminList> getList() {
		return list;
	}

	public void setList(List<RepAdminList> list) {
		this.list = list;
	}

}
