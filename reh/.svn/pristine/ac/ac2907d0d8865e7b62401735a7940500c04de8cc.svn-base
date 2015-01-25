package com.ree.userrecruit;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepEntBlacklistUser;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserView;
import com.ree.hibernate.RepEntJobUserViewId;

public class RecruitJobDao extends SessionHelper {

	private RepEntJobInfoViewId bean;
	private String query_statement=null;
	private SessionHelper s = new SessionHelper();
	private List<RepEntJobUserViewId> list;

	public RecruitJobDao() {
		super();
	}
	
	/**
	 * 
	* @Title: GetEntJobView_By_Job_No 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobNo
	* @param @return    设定文件 
	* @return RepEntJobUserViewId    返回类型 
	* @throws
	 */
	public RepEntJobUserViewId GetEntJobView_By_Job_No(int jobNo){
		RepEntJobUserViewId b = null;
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.jobNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, jobNo);
			list = query.list();
			if(list.size()>0)
				b=(RepEntJobUserViewId)list.get(0);
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
	* @Title: GetEntJobView_By_userNo_jobNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @param jobNo
	* @param @return    设定文件 
	* @return RepEntJobUserViewId    返回类型 
	* @throws
	 */
	public RepEntJobUserViewId GetEntJobView_By_userNo_jobNo(int userNo,int jobNo){
		RepEntJobUserViewId b = null;
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.userNo = ? and  id.jobNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			query.setParameter(1, jobNo);
			list = query.list();
			if(list.size()>0)
				b=(RepEntJobUserViewId)list.get(0);
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
	* @Title: GetEntJobInfoList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobUserViewId> GetEntJobViewList_By_UserNo(int userNo,String jobName,int c,int p ,String sortBy,String sortMethod){
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.userNo = ? and (id.jobName like ? or id.jobName is null) order by %s %s";
		try{
			/*Query query = s.getQuery(query_statement);*/
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, userNo);
			query.setParameter(1, '%' + (jobName==null?"":jobName) + '%');
			query.setFirstResult((c-1)*p);
			query.setMaxResults(p);
			list = query.list();
			//是否是企业主动招聘
			for(RepEntJobUserViewId r: list){
			    if(r.getReserved01()!=null&&"1".equals(r.getReserved01()))
				r.setReserved01("是");
			    else
				r.setReserved01("否");
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
	* @Title: CountEntJobViewList_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @param jobName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobViewList_By_UserNo(int userNo,String jobName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.userNo = ? and id.jobName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			query.setParameter(1, '%' + (jobName==null?"":jobName) + '%');
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
	* @Title: GetEntJobViewList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param jobName
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobViewList_By_EntNo(int EntNo,String userName){
		List<RepEntJobInfoViewId> list;
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.entNo = ? and id.userName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: GetEntJobViewList_By_EntNoAndUserName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobUserViewId> GetEntJobViewList_By_EntNoAndUserName(int EntNo,String userName){
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.entNo = ? and id.userName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: GetEntJobViewList_By_EntNoAndUserName_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @return    设定文件 
	* @return List<RepEntJobUserViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobUserViewId> GetEntJobViewList_By_EntNoAndUserName_isNotSelf(int EntNo,String userName){
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.entNo = ? and id.userName like ? and id.reserved01 is null";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: GetEntBlackList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @return    设定文件 
	* @return List<RepEntBlacklistUser>    返回类型 
	* @throws
	 */
	public List<RepEntBlacklistUser> GetEntBlackList_By_EntNo(int EntNo,String userName,int c,int p ,String sortBy,String sortMethod){
	    List<RepEntBlacklistUser> list;
	    	query_statement ="from com.ree.hibernate.RepEntBlacklistUser  where id.entNo = ? and id.userCert like ? order by %s %s";
		try{
			/*Query query = s.getQuery(query_statement);*/
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: GetEntJobViewList_By_EntNoAndUserName_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @param isR
	* @param @return    设定文件 
	* @return List<RepEntJobUserViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobUserViewId> GetEntJobViewList_By_EntNoAndUserName_isNotSelf(int EntNo,String userName,Boolean isR,int c,int p ,String sortBy,String sortMethod){
		query_statement = HQLScripts.GetScript("RepEntJobUserView") +" where id.entNo = ? and id.userName like ? and id.reserved01 is null"
			+(isR?" and id.state = -1":" and id.state = 0")+" order by %s %s";
		try{
			/*Query query = s.getQuery(query_statement);*/
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: CountJobViewList_By_EntNoAndUserName 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountJobViewList_By_EntNoAndUserName(int EntNo,String userName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? and id.userName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: CountJobViewList_By_EntNoAndUserName_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountJobViewList_By_EntNoAndUserName_isNotSelf(int EntNo,String userName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? and id.userName like ?"
			+ " and id.reserved01 is null";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: CountEntBlacklist_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntBlacklist_By_EntNo(int EntNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntBlacklistUser where id.entNo = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
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
	* @Title: CountJobViewList_By_EntNoAndUserName_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @param isR
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountJobViewList_By_EntNoAndUserName_isNotSelf(int EntNo,String userName,Boolean isR){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? and id.userName like ?"
			+ " and id.reserved01 is null"
			+(isR?" and id.state = -1":" and id.state = 0");
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
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
	* @Title: UpdateRecruit_By_Bean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rBean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String UpdateRecruit_By_Bean(RepEntJobUser rBean){
		String rs = null;
		try {
			s.Update(rBean);
		} catch (Exception e) {
			rs += e.getMessage();
			e.printStackTrace();
			throw e;
		} finally {
			s.closeSession();
		}
		return rs;
	}
	
	/**
	 * 
	* @Title: Add_Recruit_By_Bean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rBean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Add_Recruit_By_Bean(RepEntJobUserViewId rBean) {
		String rs = null;
		try {
			s.Save(rBean);
		} catch (Exception e) {
			rs += e.getMessage();
			e.printStackTrace();
			throw e;
		} finally {
			s.closeSession();
		}
		return rs;
	}
	/**
	 * 
	* @Title: Add_Recruit_By_Bean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rBean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Add_Recruit_By_Bean(RepEntJobUser rBean) {
		String rs = null;
		try {
			s.Save(rBean);
		} catch (Exception e) {
			rs += e.getMessage();
			e.printStackTrace();
			throw e;
		} finally {
			s.closeSession();
		}
		return rs;
	}
	/**
	 * 
	* @Title: getBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param c
	* @param @param p
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object getBean(Class c, Serializable p) {
		return s.getBean(c, p);
	}
	
}
