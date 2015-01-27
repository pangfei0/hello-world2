package com.ree.train;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.news.NewsDao;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainNewsViewId;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.hibernate.RepUserInfo;

/**
 * 
 * <p>Title: NewsAction<／p>
 * <p>Description:处理新闻的增加，修改 <／p> 
 * @author 李丁
 * @date 2014年7月15日
 */
public class TrainAction extends ActionSupport{
	
	/**
	 * 输入
	 */
	private int news_id;
	private int user_id;
	private int train_id;
	private int state;
	private String submittime;
	private String memo;
	private String message;
	private int statusCode;
	private String navTabId;
	private String method;
	private String sc = null;
	List<RepEntTrainUser> list=null;
	RepEntTrainUser tBean=new RepEntTrainUser();
    TrainDao tDao=new TrainDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date nowtime = new Date();
	RepAdminNews rBean = new RepAdminNews();
	public String execute() throws IOException, ParseException
	{	
		rBean = tDao.Get_TrainEndTime_By_News_Id(news_id);
		if(method!=null&&method.equals("del")){
			if(rBean.getNewsTrainEndtime()!=null && rBean.getNewsTrainEndtime().getTime()<nowtime.getTime()){
				sc="超过培训截止日期请不要退出培训";
				message=sc;
				System.out.println(sc);
				return ERROR;
			}else{
				tDao.Del_train_By_id(train_id);
				return ERROR;
			}			
			
		}		
		else if(tDao.Check_train_by_Id(news_id,user_id)){
			sc="您已报名该培训";
			message=sc;
			System.out.println(sc);
			return SUCCESS;
		}
		else if(rBean.getNewsTrainEndtime().getTime()<nowtime.getTime()){
			sc="报名时间已截止";
			message=sc;
			System.out.println(sc);
			return SUCCESS;
		}
		else{			
			tBean.setNewsNo(news_id);
			tBean.setUserNo(user_id);
			tBean.setState(1);
			tBean.setSubmittime(sdf.parse(submittime));
			tBean.setMemo("再就业");
	    	tDao.Add_train_By_Bean(tBean);		    	
	    	sc="报名成功";
	    	message=sc;
	    	return SUCCESS;
		}
  
					
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getSubmittime() {
		return submittime;
	}

	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
