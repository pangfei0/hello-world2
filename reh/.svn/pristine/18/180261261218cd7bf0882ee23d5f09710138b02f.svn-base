package com.reh.newslist;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminNews;
import com.ree.news.NewsDao;

public class NewsListAction extends ActionSupport {
	private List<RepAdminNews> list = null;
	private HashMap<String, Object> store = new HashMap<String, Object>();

	public List<RepAdminNews> getList() {
		return list;
	}

	public void setList(List<RepAdminNews> list) {
		this.list = list;
	}

	private NewsDao nDao = new NewsDao();
	/*
	 * 输入
	 */
	private int listNo;
	/*
	 * 输出
	 */
	private String title;
	private String URL;
	private Date submitTime;
	private long count = 0;
	private String author;

	@Override
	public String execute() throws Exception {
		list = new ArrayList<RepAdminNews>();
		list = nDao.GetNewsItems_By_List_id(listNo, 1, 100, "NEWS_NO", "asc","");
		store.put("data", list);
		count = nDao.Count_By_ListNo(listNo);
		store.put("num", count);
		return SUCCESS;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}

}
