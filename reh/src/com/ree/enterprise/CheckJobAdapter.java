package com.ree.enterprise;

import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.enterprise.EntDao;

public class CheckJobAdapter {
	
	public List<RepEntJobInfoViewId> GetEntJobItems_By_All(int pageNum,int numPerPage,String orderField,String orderDirection,String keyword) {
		EntJobDao eDao=new EntJobDao();
		List<RepEntJobInfoViewId> list = new ArrayList<RepEntJobInfoViewId>();
		list = eDao.GetEntJobItems_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
		return list;
	}
	public int GetEntJobTotalcount_By_All(int pageNum,int numPerPage,String orderField,String orderDirection,String keyword) {
		EntJobDao eDao=new EntJobDao();
		List<RepEntJobInfoViewId> list = new ArrayList<RepEntJobInfoViewId>();
		int count = eDao.GetEntJobTotalCount_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
		return count;
	}
	public List<RepEntInfoViewId> GetEntBeans_By_All() {
		EntDao eDao=new EntDao();
		List<RepEntInfoViewId> list = new ArrayList<RepEntInfoViewId>();
		list = eDao.GetEntBeans_By_All();
		return list;
	}
}
