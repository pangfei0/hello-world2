package com.ree.trainenter;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.news.NewsDao;
import com.ree.hibernate.RepAdminNews;
public class TrainAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 输入
	 */
	private int listno;
	private int c;
	private int p;
	private String orderField;
	private String orderDirection;
	private String keyword;
	private HashMap<String,Object> store = new HashMap<String,Object>();
	private NewsDao nDao = new NewsDao();
	List<RepAdminNews> list = new ArrayList<RepAdminNews>();
	/* public List<RepAdminNews> GetNewsItems_By_List_id(int list_id, int pageNum,
			int numPerPage, String orderField, String orderDirection , String keyword) { 
	 * */
	public String execute() throws IOException, ParseException
	{	
			list = nDao.GetNewsItems_By_List_id(listno,c,p,orderField,orderDirection,"");
			store.put("data", list);
	    	return SUCCESS;
	}
	public int getListno() {
		return listno;
	}
	public void setListno(int listno) {
		this.listno = listno;
	}
	public HashMap<String, Object> getStore() {
		return store;
	}
	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
  
					
}
	
	