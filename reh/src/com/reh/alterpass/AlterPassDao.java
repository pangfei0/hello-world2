package com.reh.alterpass;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepUserInfo;

public class AlterPassDao {
	private String query_statement = null;
	private SessionHelper s = new SessionHelper();

	@SuppressWarnings("unchecked")
	public boolean Check_Users(int userNo, String oldpass) {
		query_statement ="from com.ree.hibernate.RepUserInfo where userNo = ? and userPwd = ?";
		List<RepUserInfo> list = null; 
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			query.setParameter(1, oldpass);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		if(list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean Check_Ent(int entNo, String oldpass) {
		query_statement ="from com.ree.hibernate.RepEntInfo where entNo = ? and entPwd = ?";
		List<RepUserInfo> list = null; 
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
			query.setParameter(1, oldpass);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		if(list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}

	public void Update_Bean(RepUserInfo uBean) {
		try {
			s.Update(uBean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}		
	}
	public void Update_ent_Bean(RepEntInfo eBean) {
		try {
			s.Update(eBean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}		
	}

}
