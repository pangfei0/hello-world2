/** 
 * Project Name:rep 
 * File Name:UserDao.java 
 * Package Name:com.rep.user.dao 
 * Date:2014年7月22日下午4:48:39 
 * 
 */  
package com.reh.Regist;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.StringType;

import com.opensymphony.xwork2.ActionContext;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntJobInfoView;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUserView;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainNewsViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;
import com.ree.common.DBHelper;
import com.ree.common.HQLScripts;
import com.ree.common.ResultHelper;
import com.ree.common.SessionHelper;
import com.ree.dict.DictAdapter;
import com.ree.enterprise.EntJobDao;
import com.ree.user.LoginDao;
/**
 * <p>Title: UserDao<／p>
 * <p>Description: <／p> 
 * @author 李丁
 * @date 2014年7月22日
 */
public class UserDao extends SessionHelper {
    private DictAdapter da = new DictAdapter();
	private RepUserInfo uBean = null;
	private String query_statement = null;
	private SimpleDateFormat dateformat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private ResultSet result = null;
	private SessionHelper s = new SessionHelper();
	Query query=null;
	private List<RepUserInfo> list = null;
	public UserDao() {
		super();
	
	}
	/**
	 * 
	* @Title: GetBoxBean_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @return    设定文件 
	* @return UserMsgBoxBean    返回类型 
	* @throws
	 */
	public UserMsgBoxBean GetBoxBean_By_UserNo(int userNo){
		UserMsgBoxBean bean = new UserMsgBoxBean();
		EntJobDao jDao = new EntJobDao();
		Long recruitNum,recruitHasStateNum;
		try{
			recruitNum = jDao.CountEntJobUserList_By_UserNo(userNo);
			recruitHasStateNum = jDao.CountEntJobUserListWithState_By_UserNo(userNo);
			bean.setRecruitHasStateNum(recruitHasStateNum);
			bean.setRecruitNum(recruitNum);
			
		}
		catch(Exception e){
			throw  e;
		}
		finally{
			s.closeSession();
		}
		return bean;
	}
	/**
	 * 
	* @Title: GetUserView_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @return    设定文件 
	* @return RepUserInfoViewId    返回类型 
	* @throws
	 */
	public RepUserInfoViewId GetUserView_By_UserNo(int userNo){
		RepUserInfoViewId b = null;
		List<RepUserInfoViewId> list;
		query_statement = HQLScripts.GetScript("RepUserInfoView") + " where id.userNo = ?";
		try{
			
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			list = query.list();
			if(list.size()>0)
				b = (RepUserInfoViewId)list.get(0);
			}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return b;
	}
	/**
	 * 
	* @Title: GetUserViewList_By_Keyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @param c
	* @param @param p
	* @param @param sortBy
	* @param @param sortMethod
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<RepUserInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepUserInfoViewId> GetUserViewList_By_Keyword(String keyword,int c,int p ,String sortBy,String
			sortMethod) throws Exception{
		List<RepUserInfoViewId> list;
		query_statement = HQLScripts.GetScript("RepUserInfoView") + " where id.userName like ?  order by %s %s";
		try{
			
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			query.setFirstResult((c-1)*p);
			query.setMaxResults(p);
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
	/**
	 * 
	* @Title: GetUserViewList_By_userBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userBean
	* @param @param c
	* @param @param p
	* @param @param sortBy
	* @param @param sortMethod
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<RepUserInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepUserInfoViewId> GetUserViewList_By_userBean(RepUserInfoViewId userBean,String jobIntentionDictType,int c,int p ,String sortBy,String
			sortMethod) throws Exception{
		List<RepUserInfoViewId> list;
		query_statement = HQLScripts.GetScript("RepUserInfoView") 
				+" where id.userName like ? "
				+ "and (id.userAddrName like ? or id.userAddrName is null) and (id.userSex like ? or id.userSex is null) "
				+ "and (id.userEducationNo like ? or id.userEducationNo is null) and (id.userExpNo like ? or id.userExpNo is null)"
				+ "and (id.userIntention in(select jobIntentionDictNo from com.ree.hibernate.RepAdminJobIntentionDict "
				+ "where jobIntentionDictType like ?) or id.userIntention is null ) and (id.userIntention like ? )"//"where jobIntentionDictType like ?) or id.userIntention is null) and (id.userIntention like ? or id.userIntention is null)"
				+ " order by %s %s";
		try{
			
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			
			
			query.setParameter(0, '%' + (userBean.getUserName()==null?"":userBean.getUserName()) + '%',	StringType.INSTANCE);
			query.setParameter(1, '%' + (userBean.getUserAddrName()==null?"":userBean.getUserAddrName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (userBean.getUserSex()==null?"":userBean.getUserSex()) + '%',	StringType.INSTANCE);
			query.setParameter(3, "%" + String.valueOf((userBean.getUserEducationNo()==0?"":userBean.getUserEducationNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((userBean.getUserExpNo()==0?"":userBean.getUserExpNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, "%" + (jobIntentionDictType==null?"":jobIntentionDictType) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + ((userBean.getUserIntention()==null||userBean.getUserIntention().equals("0"))?"":userBean.getUserIntention()) + '%',	StringType.INSTANCE);
			
			query.setFirstResult((c-1)*p);
			query.setMaxResults(p);
			list = query.list();
			//加入职业意向
			for(RepUserInfoViewId r :list){
			    r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
			}
			}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}
	/**
	 * 
	* @Title: CountUserViewList_By_Keyword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param keyword
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountUserViewList_By_Keyword(String keyword){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepUserInfoView where id.userName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			result = (Long) query.uniqueResult();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return result;
	}
	public Long CountUserViewList_By_userBean(RepUserInfoViewId userBean,String jobIntentionDictType){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepUserInfoView "
				+" where id.userName like ? "
				+ "and (id.userAddrName like ? or id.userAddrName is null) and (id.userSex like ? or id.userSex is null) "
				+ "and (id.userEducationNo like ? or id.userEducationNo is null) and (id.userExpNo like ? or id.userExpNo is null)"
				+ "and (id.userIntention in(select jobIntentionDictNo from com.ree.hibernate.RepAdminJobIntentionDict "
				+ "where jobIntentionDictType like ?) or id.userIntention is null ) and (id.userIntention like ? )";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (userBean.getUserName()==null?"":userBean.getUserName()) + '%',	StringType.INSTANCE);
			query.setParameter(1, '%' + (userBean.getUserAddrName()==null?"":userBean.getUserAddrName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (userBean.getUserSex()==null?"":userBean.getUserSex()) + '%',	StringType.INSTANCE);
			query.setParameter(3, "%" + String.valueOf((userBean.getUserEducationNo()==0?"":userBean.getUserEducationNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((userBean.getUserExpNo()==0?"":userBean.getUserExpNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, "%" + (jobIntentionDictType==null?"":jobIntentionDictType) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + ((userBean.getUserIntention()==null||userBean.getUserIntention().equals("0"))?"":userBean.getUserIntention()) + '%',	StringType.INSTANCE);
			result = (Long) query.uniqueResult();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return result;
	}
	/**
	 * 
	* <p>Title: GetUserBeans_By_All<／p>
	* <p>Description:返回完整的UserBeans <／p>
	* <p>Return:List<UserBean></p>
	* @param pageNum
	* @param numPerPage
	* @param orderField
	* @param orderDirection
	* @return
	 */
	public List<RepUserInfo> GetUserBeans_By_All(int pageNum,
			int numPerPage, String orderField, String orderDirection){
		List<RepUserInfo> data = new ArrayList<RepUserInfo>();
		
		query_statement = "from com.ree.hibernate.RepUserInfo order by '%s' '%s' limit '%s','%s'";
		
		 query = s.getQuery(String.format(query_statement,  new String[]{orderField,orderDirection,String.valueOf((pageNum - 1) * numPerPage),String.valueOf(numPerPage)}));
		
			list = query.list();
	
	
		try {
			
			for(int i=0;i<list.size();i++)
			{
				uBean=list.get(i);
				data.add(uBean);
			}

		} catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
	
	
	/**
	 * 
	* <p>Title: GetUserBeans_By_type<／p>
	* <p>Description:通过type返回UserBeans <／p>
	* <p>Return:List<UserBean></p>
	* @param type
	* @param pageNum
	* @param numPerPage
	* @param orderField
	* @param orderDirection
	* @param keywords
	* @return
	 */
//	public List<UserBean> GetUserBeans_By_type(int type,int pageNum,
//			int numPerPage, String orderField, String orderDirection,String keywords){
//		List<UserBean> data = new ArrayList<UserBean>();
//		query_statement = "select * from users where type = %s and (uid like '%%%s%%' or name like '%%%s%%') order by %s %s limit %s,%s";
//		result = r.getResult(query_statement, new String[]{String.valueOf(type),keywords,keywords,
//				orderField,orderDirection,String.valueOf((pageNum - 1) * numPerPage),
//				String.valueOf(numPerPage)});
//		try {
//			while (result.next()) {
//				uBean = new UserBean();
//				uBean.setGid(UUID.fromString(result.getString("gid")));
//				uBean.setUid(result.getString("uid"));
//				uBean.setName(result.getString("name"));
//				uBean.setSex(result.getString("sex"));
//				uBean.setAge(result.getInt("age"));
//				uBean.setAddr(result.getString("addr"));
//				uBean.setEmail(result.getString("email"));
//				uBean.setPhone(result.getString("phone"));
//				uBean.setPcode(result.getInt("pcode"));
//				uBean.setAbility(result.getString("ability"));
//				uBean.setBirth(result.getTimestamp("birth"));
//				uBean.setCid(result.getInt("cid"));
//				data.add(uBean);
//			}
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return null;
//		} finally {
//			result = null;
//			query_statement = null;
//			r.connStop();
//		}
//		return data;
//	}
	
	/**
	 * 
	* <p>Title: GetUserBeans_By_type<／p>
	* <p>Description:通过type&tid返回UserBeans <／p>
	* <p>Return:List<UserBean></p>
	* @param type
	* @param tid
	* @param pageNum
	* @param numPerPage
	* @param orderField
	* @param orderDirection
	* @return
	 */
//	public List<UserBean> GetUserBeans_By_type(int type,int tid,int pageNum,
//			int numPerPage, String orderField, String orderDirection,String keywords){
//		if(tid==0){
//			return GetUserBeans_By_type(type, pageNum, numPerPage, orderField, orderDirection,keywords);
//		}
//		List<UserBean> data = new ArrayList<UserBean>();
//		query_statement = "select users.*,users_train.tid from users,users_train where "
//				+ "users_train.uid = users.gid and tid = %s and type = %s and (users.uid like '%%%s%%' or name like '%%%s%%') order by %s %s limit %s,%s";
//		result = r.getResult(query_statement, new String[]{String.valueOf(tid),String.valueOf(type),keywords,keywords,
//				orderField,orderDirection,String.valueOf((pageNum - 1) * numPerPage),
//				String.valueOf(numPerPage)});
//		try {
//			while (result.next()) {
//				uBean = new UserBean();
//				uBean.setGid(UUID.fromString(result.getString("gid")));
//				uBean.setUid(result.getString("uid"));
//				uBean.setName(result.getString("name"));
//				uBean.setSex(result.getString("sex"));
//				uBean.setAge(result.getInt("age"));
//				uBean.setAddr(result.getString("addr"));
//				uBean.setEmail(result.getString("email"));
//				uBean.setPhone(result.getString("phone"));
//				uBean.setPcode(result.getInt("pcode"));
//				uBean.setAbility(result.getString("ability"));
//				uBean.setBirth(result.getTimestamp("birth"));
//				uBean.setCid(result.getInt("cid"));
//				data.add(uBean);
//			}
//
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return null;
//		} finally {
//			result = null;
//			query_statement = null;
//			r.connStop();
//		}
//		return data;
//	}
	/**
	 * 
	* <p>Title: GetUserBean_By_UID<／p>
	* <p>Description:通过USER_UID获得UserBean <／p>
	* <p>Return:UserBean</p>
	* @param UID
	* @return
	 */
	public RepUserInfo GetUserBean_By_UID(String UID)
	{
		
		this.setuBean(new RepUserInfo());
		query_statement = "from com.ree.hibernate.RepUserInfo where USER_UID=? ";
		 query=s.getQuery(query_statement);
		query.setParameter(0, UID);
		list=query.list();
        uBean=list.get(0);
        s.closeSession();
         return uBean;
	}
	/**
	 * 
	* <p>Title: GetUserBean_By_USER_NO<／p>
	* <p>Description:通过USER_NO获得UserBean <／p>
	* <p>Return:UserBean</p>
	* @param gid
	* @return
	 */
	public RepUserInfo GetUserBean_By_USER_NO(int USER_NO)
	{
	
		this.setuBean(new RepUserInfo());
		query_statement = "from com.ree.hibernate.RepUserInfo where USER_NO = ? ";
	   query=s.getQuery(query_statement);
		query.setParameter(0, USER_NO);
	    list=query.list();
	    uBean=list.get(0);
	    s.closeSession();
		return uBean;
	}

	
	/**
	 * 
	* <p>Title: GetTotalCount_By_type<／p>
	* <p>Description:通过type返回总行数 <／p>
	* <p>Return:int</p>
	* @param type
	* @return
//	 */
//	public int GetTotalCount_By_type(int type,String keywords){
//		String[] params = new String[] { String.valueOf(type),keywords,keywords };
//		int count = 0;
//		query_statement = "select count(*) from users where type = %s and (uid like '%%%s%%' or name like '%%%s%%')";
//		result = r.getResult(query_statement, params);
//		try {
//			if (result.next())
//				count = result.getInt(1);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			result = null;
//			query_statement = null;
//			r.connStop();
//		}
//		return count;
//	}
	
	/**
	 * 
	* <p>Title: GetTotalCount<／p>
	* <p>Description:返回总行数 <／p>
	* <p>Return:int</p>
	* @param type
	* @param cid
	* @return
	 */
	public int GetTotalCount(){
		int count;
		this.setuBean(new RepUserInfo());
		query_statement = "from com.ree.hibernate.RepUserInfo";
	    query=s.getQuery(query_statement);
	    list=query.list();
	    count=list.size();
	    s.closeSession();
	    return count;
	}
	
	/**
	 * 
	* <p>Title: GetTotalCount_By_type<／p>
	* <p>Description:返回总行数 <／p>
	* <p>Return:int</p>
	* @param type
	* @param cid
	* @return
	 */
//	public int GetLastUserNo{
//		int no;
//		this.setuBean(new RepUserInfo());
//		query_statement = "from com.ree.hibernate.RepUserInfo";
//	    query=s.getQuery(query_statement);
//	    list=query.list();
//	    count=list.size();
//	    return count;
//	}
	/**
	 * 
	* <p>Title: Update_User_By_Bean<／p>
	* <p>Description:通过bean更新user <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 */
	public String Update_User_By_Bean(RepUserInfo b){
		
	
//		String[] params = new String[] {b.getUserUid(),b.getUserPwd(),b.getUserEmail(),b.getUserName(),
//				b.getUserSex(),b.getUserCert(),b.getUserResidence(),String.valueOf(b.getRepAdminCommunityInfo().getCommunityNo()),b.getUserAddrPos(),
//		String.valueOf(b.getRepAdminEducationDict().getEducationDictNo()),	String.valueOf(b.getRepAdminJobIntentionDict().getJobIntentionDictNo()),	b.getUserPhone(),b.getUserSkill(),b.getReserved01(),b.getReserved02(),String.valueOf(b.getUserNo())};
//		query_statement = "from com.ree.hibernate.RepUserInfo set USER_UID='%s', USER_PWD = %s,USER_EMAIL = '%s',USER_NAME = '%s',USER_SEX = '%s',USER_CERT = '%s',USER_RESIDENCE = '%s',USER_ADDR_DIS_NO = '%s'"
//				+ ",USER_ADDR_POS = '%s',USER_EDUCATION_NO = '%s' ,USER_INTENTION = '%s', USER_PHONE = '%s',USER_SKILL='%s',RESERVED01='%s' ,RESERVED02='%s' where USER_NO = '%s' ";
//		 query=s.getQuery(String.format(query_statement, params));
//		
		String rs = null;
		try {
			s.Update(b);
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
	
	
	/**
	 * 
	* <p>Title: AddUser_by_Bean<／p>
	* <p>Description:通过bean增加用户 <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 * @throws SQLException 
	 */
	public String AddUser_by_Bean(RepUserInfo b) throws SQLException{
		String rs = null;
		LoginDao lDao = new LoginDao();
		if((Boolean)lDao.checkRole(b.getUserUid()).get("success")){
			return "已有用户:" + b.getUserUid();
		}
		query_statement = "from com.ree.hibernate.RepUserInfo where userEmail=?";
		query=s.getQuery(query_statement);
		query.setParameter(0, b.getUserEmail());
	    if(query.list().size()==1)
	    	return "邮箱已被注册！";
		try {
			s.Save(b);
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
	
	
	/**
	 * 
	* <p>Title: Del_Users_By_gid<／p>
	* <p>Description:通过gid删除user <／p>
	* <p>Return:String</p>
	* @param gid
	* @return
	 */
	public String Del_Users_By_gid(String gid){
		String rs = null;
		try {
			s.Delete(s.getBean(RepUserInfo.class, gid));
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
	
	
	/**
	 * @return the query_statement
	 */
	public String getQuery_statement() {
		return query_statement;
	}

	/**
	 * @param query_statement the query_statement to set
	 */
	public void setQuery_statement(String query_statement) {
		this.query_statement = query_statement;
	}

	public RepUserInfo getuBean() {
		return uBean;
	}

	public void setuBean(RepUserInfo uBean) {
		this.uBean = uBean;
	}
	public Object getBean(Class c,Serializable p){
		return s.getBean(c, p);
	}

	public RepUserInfoViewId GetUserInfo_By_User_Id(int user_id) {
		List<RepUserInfoViewId> list = null;
		RepUserInfoViewId uBean = null;
		/*query_statement = "from com.ree.hibernate.RepUserInfo where userNo=?";*/
		query_statement = HQLScripts.GetScript("RepUserInfoView") + " where id.userNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, user_id);
			list = query.list();
			if(list.size()>0)
				uBean = list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return uBean;
	}
	public List<RepEntJobUserViewId> GetUserJobInfo_By_User_Id(int user_id) {
		List<RepEntJobUserViewId> list = null;
		RepEntJobUserViewId uBean = null;
		query_statement = HQLScripts.GetScript("RepEntJobUserView") + " where id.userNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, user_id);
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

	/*public List<RepUserInfo> GetUserInfo_By_All(int pageNum, int numPerPage,
			String orderField, String orderDirection, String keyword) {
		// TODO Auto-generated method stub
		List<RepUserInfo> data = new ArrayList<RepUserInfo>();
		String[] params = new String[] { orderField,orderDirection};
		query_statement = "from com.ree.hibernate.RepUserInfo where userName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			query.setFirstResult((pageNum - 1) * numPerPage);
			query.setMaxResults(numPerPage);
			data = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}*/
	public List<RepUserInfoViewId> GetUserInfo_By_All(int pageNum, int numPerPage,String orderField, String orderDirection, String keyword) {
		// TODO Auto-generated method stub
		String addrname = null;
		addrname = (String) ActionContext.getContext().getSession().get("admin_range");
		List<RepUserInfoViewId> data = new ArrayList<RepUserInfoViewId>();
		String[] params = new String[] { orderField,orderDirection};
		query_statement = HQLScripts.GetScript("RepUserInfoView") + " where id.userName like ? and id.userEducationNo!=null and id.userIntention!=null "
				+ "and id.userAddrName!=null and id.userAddrName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			query.setParameter(1, '%' + (addrname==null?"":addrname) + '%');
			query.setFirstResult((pageNum - 1) * numPerPage);
			query.setMaxResults(numPerPage);
			data = query.list();
			for(RepUserInfoViewId r :data){
				if(r.getUserIntention()!=null){
					 r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
				}				   
			}
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
	public List<RepUserInfoViewId> GetUserInfo_By_Select_All(int pageNum, int numPerPage,String orderField, String orderDirection, 
			String userName,String userSex,int educationDictNo,String userIntention,String jobIntentionDictType,String userSkill,String userAddrName,int option) {
		// TODO Auto-generated method stub
		List<RepUserInfoViewId> data = new ArrayList<RepUserInfoViewId>();
		int admin_type =  (int) ActionContext.getContext().getSession().get("admin_type");
		String addrname = null;
		addrname = (String) ActionContext.getContext().getSession().get("admin_range");
		if(addrname==null){
			addrname="";
		}
		if(option==0&admin_type==0){
			String[] params = new String[] {orderField,orderDirection};
			/*query_statement =HQLScripts.GetScript("RepUserInfoView") + " where id.userAddrName like ? order by %s %s";	*/
			query_statement =HQLScripts.GetScript("RepUserInfoView") + " order by %s %s";	
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				/*query.setParameter(0, '%' + (addrname==null?"":addrname) + '%');*/
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
				data = query.list();
				for(RepUserInfoViewId r :data){
					if(r.getUserIntention()!=null){
						 r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
					}				   
				}
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}else if(option==2&admin_type==0){
			String[] params = new String[] {orderField,orderDirection};
			query_statement =HQLScripts.GetScript("RepUserInfoView") + " where id.userAddrName is null order by %s %s";	
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
				data = query.list();
				for(RepUserInfoViewId r :data){
					if(r.getUserIntention()!=null){
						 r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
					}				   
				}
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}else{
			String[] params = new String[] {orderField,orderDirection};
			query_statement =HQLScripts.GetScript("RepUserInfoView") + " where id.userName like ? and id.userSex !=null and id.userSex like ? and id.userEducationNo!=null and id.userEducationNo > ?"
					+ "and id.userIntention!=null and (id.userIntention in(select jobIntentionDictNo from com.ree.hibernate.RepAdminJobIntentionDict "
					+ "where jobIntentionDictType like ?)) and (id.userIntention like ? )"					
					+ "and(id.userSkill like ? or id.userSkill is null) and id.userAddrName !=null and id.userAddrName like ? and id.userAddrName like ? order by %s %s";	
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, '%' + (userName==null?"":userName) + '%');
				query.setParameter(1, '%' + (userSex==null?"":userSex) + '%');
				query.setParameter(2, educationDictNo-1);
				query.setParameter(3, '%' + (jobIntentionDictType==null?"":jobIntentionDictType) + '%',	StringType.INSTANCE);
				query.setParameter(4, '%' + ((userIntention==null||userIntention.equals("0"))?"":userIntention) + '%',	StringType.INSTANCE);
				query.setParameter(5, "%" + (userSkill==null?"":userSkill) + '%');
				query.setParameter(6, "%" + (userAddrName==null?"":userAddrName) + '%');
				query.setParameter(7, '%' + (addrname==null?"":addrname) + '%');
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
				data = query.list();
				for(RepUserInfoViewId r :data){
					if(r.getUserIntention()!=null){
						 r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
					}				   
				}
				/*HttpServletRequest request=null;
				session.put("userName", userName);
				session.put("userSex", userSex);
				session.put("educationDictNo", educationDictNo);
				session.put("userIntention", userIntention);
				session.put("jobIntentionDictType", jobIntentionDictType);
				session.put("userSkill", userSkill);
				session.put("userAddrName", userAddrName);
				session.put("option", option);*/
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}
		return data;
	}
	public List<RepUserInfo> Get_All_User_By_All() {
		List<RepUserInfo> list = null;
		query_statement = "from com.ree.hibernate.RepUserInfo";
		try{
			Query query = s.getQuery(query_statement);
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

	public void Del_User_By_id(int user_id) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepUserInfo.class, user_id));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}

	public int GetTotalCount_By_All(String keyword) {
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		String addrname = (String) session.get("admin_range");
		if(addrname==null){
			addrname="";
		}
		// TODO Auto-generated method stub
		int count=0;
		query_statement =HQLScripts.GetScript("RepUserInfoView")+" where id.userName like ? and id.userAddrName like ? and id.userIntention!=null";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			query.setParameter(1, '%' + (addrname==null?"":addrname) + '%');
			list = query.list();
			count=list.size();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return count;
	}

	public int GetTotalCount_By_Select_All(String userName,String userSex,int educationDictNo,String userIntention,String jobIntentionDictType,String userSkill,String userAddrName,int option) {
		// TODO Auto-generated method stub
		List<RepUserInfoViewId> data = new ArrayList<RepUserInfoViewId>();
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        int admin_type = (int) session.get("admin_type");
		String addrname = (String) session.get("admin_range");
		if(addrname==null){
			addrname="";
		}
		int count=0;
		if(option==0&&admin_type==0){
			/*query_statement =HQLScripts.GetScript("RepUserInfoView")+" where id.userAddrName like ?";*/	
			query_statement =HQLScripts.GetScript("RepUserInfoView");	
			try{
				Query query = s.getQuery(query_statement);	
				/*query.setParameter(0, "%" + (addrname==null?"":addrname) + '%');*/
				data = query.list();
				count=data.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}else if(option==2&admin_type==0){
			query_statement =HQLScripts.GetScript("RepUserInfoView") + " where id.userAddrName is null";	
			try{
				Query query = s.getQuery(query_statement);
				data = query.list();
				count=data.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}else{
			query_statement =HQLScripts.GetScript("RepUserInfoView") + " where id.userName like ? and id.userSex !=null and id.userSex like ? and id.userEducationNo!=null and id.userEducationNo > ?"
					+ "and id.userIntention!=null and (id.userIntention in(select jobIntentionDictNo from com.ree.hibernate.RepAdminJobIntentionDict "
					+ "where jobIntentionDictType like ?)) and (id.userIntention like ? )"					
					+ "and(id.userSkill like ? or id.userSkill is null) and id.userAddrName !=null and id.userAddrName like ? and id.userAddrName like ?";	
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, '%' + (userName==null?"":userName) + '%');
				query.setParameter(1, '%' + (userSex==null?"":userSex) + '%');
				query.setParameter(2, educationDictNo-1);
				query.setParameter(3, '%' + (jobIntentionDictType==null?"":jobIntentionDictType) + '%',	StringType.INSTANCE);
				query.setParameter(4, '%' + ((userIntention==null||userIntention.equals("0"))?"":userIntention) + '%',	StringType.INSTANCE);
				query.setParameter(5, "%" + (userSkill==null?"":userSkill) + '%');
				query.setParameter(6, "%" + (addrname==null?"":addrname) + '%');
				query.setParameter(7, "%" + (userAddrName==null?"":userAddrName) + '%');
				data = query.list();
				count=data.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}
		return count;
	}
}


