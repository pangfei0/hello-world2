package com.reh.newsinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminNews;
import com.reh.newsinfo.NewsDao;

@SuppressWarnings("serial")
public class NewsInfoAction extends ActionSupport {
	private List<RepAdminNews> list = null;
	private HashMap<String, Object> store = new HashMap<String, Object>();
	private NewsDao nDao = new NewsDao();
	/*
	 * 输入
	 */
	private int newsNo;

	public int getNewsNo() {
		return newsNo;
	}

	public void setNewsNo(int newsNo) {
		this.newsNo = newsNo;
	}

	@Override
	public String execute() throws Exception {
		list = new ArrayList<RepAdminNews>();
		list = nDao.GetNewsItem_By_NewsId(1470);
		store.put("data", list);
		return SUCCESS;
	}

	public List<RepAdminNews> getList() {
		return list;
	}

	public void setList(List<RepAdminNews> list) {
		this.list = list;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
}
