/**
 * 
 */
package com.ree.user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;

import com.ree.common.DBHelper;
import com.ree.common.HQLScripts;
import com.ree.common.ResultHelper;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminSys;
import com.ree.hibernate.RepEntInfo;


/**
 * <p>
 * Title: LoginDao<／p>
 * <p>
 * Description: <／p>
 * 
 * @author 李丁
 * @date 2014年7月15日 admin rep
 */
public class LoginDao extends SessionHelper {
	Query query=null;
	private String query_statement =null;


	private SessionHelper s = new SessionHelper();
	public LoginDao() {
		super();
	
	}

	/**
	 * <p>
	 * Title: checkLogin<／p>
	 * <p>
	 * Description:检查登陆 <／p>
	 * <p>
	 * Return:LinkedHashMap<String,Object>
	 * </p>
	 * 
	 * @param id_tag
	 * @param password
	 * @return
	 */

	public LinkedHashMap<String, Object> checkLogin(String USER_UID,
			String USER_PWD,int u_type) {
		Query query1=null;
		String query_statement1 =null;
		String[] params = new String[] { USER_UID,USER_PWD};
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		query_statement1 = u_type==0?"from com.ree.hibernate.RepUserInfo where userUid = '%s' and userPwd = '%s'":
			"from com.ree.hibernate.RepEntInfo where entUid = '%s' and entPwd = '%s'";
		query1 = s.getQuery(String.format(query_statement1, params));
		try {
			List l = query1.list();
			
			
			
				Query query2=null;
				String query_statement2 =null;
				query_statement2 = "from com.ree.hibernate.RepAdminSys where sysNo = 2";
				query2 = s.getQuery(query_statement2);
				List<RepAdminSys> sysbean = (List<RepAdminSys>) query2.list();
				int m=sysbean.get(0).getSysState();
				
				
				
				if(m==1 && u_type!=0){//审核开关
					if (l.size()>=1) {
						List<RepEntInfo> entbean=(List<RepEntInfo>) query1.list();
						int n=entbean.get(0).getReserved02();
						if(n==0){
							data.put("success", "notpass");
							
						}else{
						data.put("success", "true");							
						data.put("bean",query1.list().get(0));
						query_statement = HQLScripts.GetScript("RepEntInfoView")+ " where id.entUid = ?";
						query = s.getQuery(query_statement);
						query.setParameter(0, USER_UID);
						l = query.list();
						if(l.size()>0)
							data.put("view",query.list().get(0));
						}
					} else
						data.put("success", "false");
				}else{
					if (l.size()>=1) {						
						data.put("success", "true");							
						data.put("bean",query1.list().get(0));
						query_statement = HQLScripts.GetScript("RepUserInfoView")+ " where id.userUid = ?";
						query = s.getQuery(query_statement);
						query.setParameter(0, USER_UID);
						l = query.list();
						if(l.size()>0)
							data.put("view",query.list().get(0));
						
					} else
						data.put("success", "false");
				}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			s.closeSession();
		}
		return data;
	}

	/**
	 * 
	 * <p>
	 * Title: checkRole<／p>
	 * <p>
	 * Description:通过用户名获得角色 <／p>
	 * <p>
	 * Return:LinkedHashMap<String,Object>
	 * </p>
	 * 
	 * @param username
	 * @return
	 */
	public LinkedHashMap<String ,Object> checkRole(String USER_UID)
	{
		
		
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		query_statement = "from com.ree.hibernate.RepUserInfo where USER_UID = ?";
		query=s.getQuery(query_statement);
		query.setParameter(0, USER_UID);
		try {
			if(query.list().size()>1||query.list().size()==1)
				data.put("success", true);
			else
				data.put("success", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			s.closeSession();
		}
		return data;
	  
	}
//	public LinkedHashMap<String, Object> checkRole(String username) {
//		String[] params = new String[] { username };
//		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
//		String typename = null;
//		query_statement = "select type from users where uid = '%s'";
//		result = r.getResult(query_statement,params);
//		try {
//			if (result.next()) {
//				data.put("success", true);
//				switch (result.getInt("type")) {
//				case 1:
//					typename = "系统管理员";
//					break;
//				case -3:
//					typename = "未审核申请人员";
//					break;
//				case -2:
//					typename = "未审核注册人员";
//					break;
//				case -1:
//					typename="再就业人员";
//					break;
//				case 2:
//					typename="供应单位发布人员";
//					break;
//				case 3:
//					typename="社区管理员";
//					break;
//				case 4:
//					typename="人社局管理员";
//					break;
//				default:
//					break;
//				}
//				data.put("type", typename);
//			} else
//				data.put("success", false);
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return null;
//		} 
//		finally {
//			result = null;
//			query_statement = null;
//			r.connStop();
//		}
//		return data;
//	}
//	
//	public LinkedHashMap<String, Object> findPass(String uname, String mail) {
//		String[] params = new String[] { uname, mail};
//		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
//		query_statement = "select * from users where uid = '%s' and email = '%s'";
//		result = r.getResult(query_statement, params);
//		try {
//			if (result.next()) {
//				data.put("success", true);
//			} else
//				data.put("success", false);
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
//		finally {
//			result = null;
//			query_statement = null;
//			r.connStop();
//		}
//		return data;
//	}
//
//	public String resetPass(String uname, String randompass) throws SQLException {
//		String rs=null;
//		String[] params=new String[]{DBHelper.MD5(randompass),uname};
//		query_statement="update users set pwd='%s' where uid='%s'";
//		rs=r.runSql(query_statement, params);
//		return rs;
//	}

	
	

}