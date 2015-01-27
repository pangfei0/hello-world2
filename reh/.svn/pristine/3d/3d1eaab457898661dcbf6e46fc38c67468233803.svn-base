package com.ree.userTrain;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.news.NewsDao;
import com.ree.train.TrainDao;
import com.ree.user.UserDao;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.hibernate.RepUserInfo;

/**
 * 
 * <p>Title: NewsAction<／p>
 * <p>Description:处理新闻的增加，修改 <／p> 
 * @author 李丁
 * @date 2014年7月15日
 */
public class userTrainAction extends ActionSupport{
	
	/**
	 * 输入
	 */
	private int news_id;
	private int user_id;
	private int train_id;
	private String method;	
	private String message;
	private int statusCode;

	private String navTabId;
	
	List<RepTrainUserViewId> list=null;
	RepEntTrainUser tBean=new RepEntTrainUser();
    TrainDao tDao=new TrainDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String delTrainUser() throws IOException, ParseException
	{

		    list=tDao.Get_train_user_By_id(news_id,user_id);
		    int train_id=Integer.parseInt(String.valueOf(list.get(0).getTrainUserNo()));
			tDao.Del_train_By_id(train_id);
			this.setMessage("删除成功");
			this.setStatusCode(200);
			return SUCCESS;
	
}
	public String delUser() throws IOException, ParseException
	{

			UserDao dao1 = new UserDao();
			dao1.Del_User_By_id(user_id);
			this.setMessage("删除成功");
			this.setStatusCode(200);
			this.setNavTabId("nav");
			return SUCCESS;

	
}
	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	
}
