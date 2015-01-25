/** 
 * Project Name:rep 
 * File Name:TrainBean.java 
 * Package Name:com.rep.train.bean 
 * Date:2014年7月24日下午5:13:06 
 * 
 */  
package com.ree.train;

import java.util.Date;

/**
 * <p>Title: TrainBean<／p>
 * <p>Description: <／p> 
 * @author 李丁
 * @date 2014年7月24日
 */
public class TrainBean {
	private int id;
	private int user_id;
	private int news_id;
	private int state;
	private Date submittime;
	private String memo;	
	private String newsname;
	//user_train
	private int usercount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getSubmittime() {
		return submittime;
	}
	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getUsercount() {
		return usercount;
	}
	public void setUsercount(int usercount) {
		this.usercount = usercount;
	}
	public String getNewsname() {
		return newsname;
	}
	public void setNewsname(String newsname) {
		this.newsname = newsname;
	}
	
}
