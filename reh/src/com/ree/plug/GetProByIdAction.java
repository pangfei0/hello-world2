package com.ree.plug;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminProIntentionDict;

public class GetProByIdAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private GetProDao pDao = new GetProDao();
	private HashMap<String,Object> store = new HashMap<String,Object>();
	
	private List<RepAdminProIntentionDict> list = new ArrayList<RepAdminProIntentionDict>();
	
	public String execute() throws IOException, ParseException
	{
		list = pDao.Get_Projob_by_Id(id);
		store.put("data", list);
		return SUCCESS;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

