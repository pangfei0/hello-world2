package com.ree.enterprise;

import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepEntInfoViewId;
import com.ree.enterprise.EntDao;

public class EntAdapter {
	EntDao eDao=new EntDao();
	
	public EntMsgBoxBean GetBoxBean_By_EntNo(int entNo){
		EntDao eDao = new EntDao();
		return eDao.GetBoxBean_By_EntNo(entNo);
	}
	public List<RepEntInfoViewId> GetEntItems_By_All(int pageNum,int numPerPage,String orderField,String orderDirection,String keyword) {
		List<RepEntInfoViewId> list = new ArrayList<RepEntInfoViewId>();
		list = eDao.GetEntItems_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
		return list;
	}
	public int GetEntTotalCount_By_All(int pageNum,int numPerPage,String orderField,String orderDirection,String keyword) {
		List<RepEntInfoViewId> list = new ArrayList<RepEntInfoViewId>();
		int count = eDao.GetEntTotalCount_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
		return count;
	}
	public List<RepEntInfoViewId> GetEntBeans_By_All() {
		List<RepEntInfoViewId> list = new ArrayList<RepEntInfoViewId>();
		list = eDao.GetEntBeans_By_All();
		return list;
	}
}
