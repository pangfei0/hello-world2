/** 
 * Project Name:rep 
 * File Name:TrainAdapter.java 
 * Package Name:com.rep.train.TrainAction 
 * Date:2014年7月24日下午5:12:38 
 * 
 */  
package com.ree.train;

import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainNewsViewId;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.hibernate.RepUserInfo;


public class TrainAdapter {

	private TrainDao tDao = new TrainDao();

	private List<RepEntTrainUser> list = new ArrayList<RepEntTrainUser>();

	public List<RepEntTrainUser> GetTrainBeans_By_All(int pageNum,
			int numPerPage, String orderField, String orderDirection,String keyword){
		list = tDao.GetTrainBeans_By_All(pageNum, numPerPage, orderField, orderDirection,keyword);
		return list;
	}
	public List<RepTrainUserViewId> GetTrainBeans_By_User(int user_id){
		List<RepTrainUserViewId> list = new ArrayList<RepTrainUserViewId>();
		list = tDao.GetTrainBeans_By_User(user_id);
		return list;
	}
	public List<RepTrainUserViewId> GetUsersItems_By_News_Id(int news_id,int pageNum,
			int numPerPage, String orderField, String orderDirection,String keyword){
		List<RepTrainUserViewId> list = new ArrayList<RepTrainUserViewId>();
		list = tDao.GetUsersItems_By_News_Id(news_id,pageNum, numPerPage, orderField, orderDirection,keyword);
		return list;
	}
	public int GetTotalCount_By_News_Id(int news_id){
		int count=0;
		count = tDao.GetTotalCount_By_News_Id(news_id);
		return count;
	}
	public List<RepTrainNewsViewId> GetTrainBeans_By_All(int list_id,String orderField, String orderDirection){
		List<RepTrainNewsViewId> list = null;
		list = tDao.GetTrainBeans_By_All(list_id,orderField, orderDirection);
		return list;
	}
	public List<RepTrainUserViewId> GetUserBeans_By_All(int news_id,String orderField, String orderDirection) {
		List<RepTrainUserViewId> list = null;
		list = tDao.GetUserBeans_By_All(news_id,orderField, orderDirection);
		return list;
	}
	
	
}
