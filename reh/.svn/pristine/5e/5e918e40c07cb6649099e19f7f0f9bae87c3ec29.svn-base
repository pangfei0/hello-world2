package com.ree.AlterUser;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminScoreDict;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepUserInfo;


public class AlterDao extends SessionHelper {
	private RepAdminScoreDict sBean;
	private SessionHelper s = new SessionHelper();
	private  String query_statement=null;
	private List<RepAdminScoreDict> list;
	public  RepUserInfo GetUserBean(int userNo) {
		RepUserInfo sBean=null;
		List<RepUserInfo> list;
		query_statement = "from com.ree.hibernate.RepUserInfo where userNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public  RepAdminCommunityInfo GetCommunityBean(Integer userAddrDisNo) {
		RepAdminCommunityInfo sBean=null;
		List<RepAdminCommunityInfo> list;
		query_statement = "from com.ree.hibernate.RepAdminCommunityInfo where communityNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userAddrDisNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public  RepAdminUserEducationDict GetEduBean(Integer userEducationNo) {
		RepAdminUserEducationDict sBean=null;
		List<RepAdminUserEducationDict> list;
		query_statement = "from com.ree.hibernate.RepAdminUserEducationDict where educationDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userEducationNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	

	
}
