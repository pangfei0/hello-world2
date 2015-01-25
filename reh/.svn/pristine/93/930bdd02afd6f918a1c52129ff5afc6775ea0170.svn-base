package com.ree.admin;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepAdminInfo;



public class LoginDao {
	Query query=null;
	private String query_statement =null;


	private SessionHelper s = new SessionHelper();
	public LoginDao() {
		super();
	
	}

	/**
	 * 
	* @Title: GetAdminList_by_AdminType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param adminType
	* @param @return    设定文件 
	* @return List<RepAdminInfo>    返回类型 
	* @throws
	 */
	public List<RepAdminInfo> GetAdminList_by_AdminType(int adminType){
		List<RepAdminInfo> result = null;
		query_statement ="from com.ree.hibernate.RepAdminInfo where adminType = ?";
		try {
			query = s.getQuery(query_statement);
			query.setParameter(0, adminType);
			result = query.list();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			s.closeSession();
		}
		return result;
	}
	/**
	 * 
	* @Title: GetAdminBean_by_AdminNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param adminNo
	* @param @return    设定文件 
	* @return RepAdminInfo    返回类型 
	* @throws
	 */
	public RepAdminInfo GetAdminBean_by_AdminNo(int adminNo){
		List<RepAdminInfo> list = null;
		RepAdminInfo result = null;
		query_statement ="from com.ree.hibernate.RepAdminInfo where adminNo = ? and adminType !=0";//不允许修改系统管理员
		try {
			query = s.getQuery(query_statement);
			query.setParameter(0, adminNo);
			list = query.list();
			if(list.size()>0)
				result = list.get(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			s.closeSession();
		}
		return result;
	}
	public RepAdminInfo GetAdminBean_by_AdminUid(String adminUid){
		List<RepAdminInfo> list = null;
		RepAdminInfo result = null;
		query_statement ="from com.ree.hibernate.RepAdminInfo where adminUid =? and adminType !=0";//不允许修改系统管理员
		try {
			query = s.getQuery(query_statement);
			query.setParameter(0, adminUid);
			list = query.list();
			if(list.size()>0)
				result = list.get(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			s.closeSession();
		}
		return result;
	}
	public LinkedHashMap<String, Object> checkLogin(String uname,String pwd) {
		String[] params = new String[] { uname,DBHelper.MD5(pwd.length() == 0 ? "" : pwd) };
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		query_statement ="from com.ree.hibernate.RepAdminInfo where adminUid = '%s' and adminPwd = '%s'";
		query = s.getQuery(String.format(query_statement, params));
		try {
			if (query.list().size()>1||query.list().size()==1) {
				data.put("success", true);
				data.put("bean",query.list().get(0));
				RepAdminInfo rbean=new RepAdminInfo();
				rbean=(RepAdminInfo)query.list().get(0);
				data.put("type",rbean.getAdminType());
				data.put("admin_uid", rbean.getAdminUid());
				data.put("admin_name", rbean.getAdminName());
				data.put("admin_list", rbean.getAdminList());
				data.put("admin_range", rbean.getAdminRange());
			} else
				data.put("success", false);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			s.closeSession();
		}
		return data;
	}

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
	public LinkedHashMap<String ,Object> checkAdminRole(String adminUid)
	{
		
		
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		query_statement = "from com.ree.hibernate.RepAdminInfo where adminUid = ?";
		query=s.getQuery(query_statement);
		query.setParameter(0, adminUid);
		try {
			List<RepAdminInfo> list = query.list();
			String typename = "";
			if(list.size()>1||list.size()==1)
			{
				RepAdminInfo b = list.get(0);
					switch (b.getAdminType()) {
					case 0:
						typename = "系统管理员";
						break;
					case 2:
						typename="供应单位发布人员";
						break;
					case 3:
						typename="社区管理员";
						break;
					case 4:
						typename="人社局管理员";
						break;
					default:
						break;
					}
					//data.put("type", typename);
					data.put("type", b.getAdminName());
					data.put("success", true);
			}
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