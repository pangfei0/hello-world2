package com.news.spider;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminNews;

public class SpiderDao extends SessionHelper {
	private String query_statement = null;
	private SessionHelper s = new SessionHelper();
	private List<RepAdminNews> list = null;

	public boolean Get_News_By_Title(String newsTitle) {
		// TODO Auto-generated method stub
		query_statement = "from com.ree.hibernate.RepAdminNews where newsTitle = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, newsTitle);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		if(list.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

	public List<RepAdminNews> Get_News_By_All(int list_id) {
		// TODO Auto-generated method stub
		query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo =?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, list_id);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}
	
	public List<RepAdminNews> Get_News_By_Spider(int list_id) {
		// TODO Auto-generated method stub
		query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo =? and reserved01 is not null and newsAuthor = '抓取' order by newsSubmittime desc";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, list_id);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}

}
