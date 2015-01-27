package com.ree.findpass.action;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.ree.common.DBHelper;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminInfo;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepUserInfo;
import com.ree.user.UserDao;

/**
 * <p>
 * Title: LoginDao<／p>
 * <p>
 * Description: <／p>
 * 
 * @author 李丁
 * @date 2014年7月15日 admin rep
 */
public class CheckDao {
	private String query_statement =null;
	private ResultSet result = null;
	private SessionHelper s = new SessionHelper();
	Query query=null;
	public CheckDao() {
		super();
	}	
	public List<RepUserInfo> findPass(String uname, String mail) {
		List<RepUserInfo> data = new ArrayList<RepUserInfo>();		
		query_statement = "from com.ree.hibernate.RepUserInfo where userName = ? and userEmail = ?";	
		try {
			
			 query = s.getQuery(query_statement);
			 query.setParameter(0, uname);
			 query.setParameter(1, mail);
				data = query.list();	

		} catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
	public List<RepEntInfo> entfindPass(String uname, String mail) {
		List<RepEntInfo> data = new ArrayList<RepEntInfo>();		
		query_statement = "from com.ree.hibernate.RepEntInfo where entName = ? and entEmail = ?";	
		try {
			
			 query = s.getQuery(query_statement);
			 query.setParameter(0, uname);
			 query.setParameter(1, mail);
				data = query.list();	

		} catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}

	public String resetPass(String uname, String randompass) throws SQLException {		
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		RepUserInfo rBean = (RepUserInfo)Get_Userbean_By_Name(uname);
		String rs = null;
		rBean.setUserName(uname);
		rBean.setUserPwd(DBHelper.MD5(randompass.length() == 0 ? "" : randompass));
		try {
			s.Update(rBean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String entresetPass(String uname, String randompass) throws SQLException {		
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		RepEntInfo rBean = (RepEntInfo)Get_Entbean_By_Name(uname);
		String rs = null;
		rBean.setEntName(uname);
		rBean.setEntPwd(DBHelper.MD5(randompass.length() == 0 ? "" : randompass));
		try {
			s.Update(rBean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	private RepEntInfo Get_Entbean_By_Name(String uname) {
		List<RepEntInfo> list = null;
		RepEntInfo data = null;
		query_statement = "from com.ree.hibernate.RepEntInfo where entName = ?";
		try {
			
			 query = s.getQuery(query_statement);
			 query.setParameter(0, uname);
			 list = query.list();
			 data = list.get(0);	

		} catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
	private RepUserInfo Get_Userbean_By_Name(String uname) {
		List<RepUserInfo> list = null;
		RepUserInfo data = null;
		query_statement = "from com.ree.hibernate.RepUserInfo where userName = ?";
		try {
			
			 query = s.getQuery(query_statement);
			 query.setParameter(0, uname);
			 list = query.list();
			 data = list.get(0);	

		} catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
}