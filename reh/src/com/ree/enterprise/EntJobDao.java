/**   
* @Title: EntJobDao.java 
* @Package com.ree.enterprise 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月17日 上午12:03:59 
* @version  
*/
package com.ree.enterprise;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.StringType;

import com.opensymphony.xwork2.ActionContext;
import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserViewId;

/** 
 * @ClassName: EntJobDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月17日 上午12:03:59 
 *  
 */
public class EntJobDao extends SessionHelper {
	private RepEntJobInfoViewId jBean;
	private SessionHelper s = new SessionHelper();
	private String query_statement=null;
	private List<RepEntJobInfoViewId> list;	
	public EntJobDao(){
		super();
	}
	
	/**
	 * 
	* @Title: GetEntJobInfo_By_entNo_r 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return RepEntJobInfo    返回类型 
	* @throws
	 */
	public Integer GetEntJobInfo_By_entNo_r(int entNo){
		query_statement = "select jobNo from com.ree.hibernate.RepEntJobInfo where id.jobEntNo = ? and id.reserved01 = '1'";
		Integer result = 0;
		List<Integer> list;
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
			list = query.list();
			if(list.size()>0)
				result = (Integer)list.get(0);
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
	* @Title: GetEntJobInfo_By_jobNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobNo
	* @param @return    设定文件 
	* @return RepEntJobInfoViewId    返回类型 
	* @throws
	 */
	public RepEntJobInfoViewId GetEntJobInfo_By_jobNo(int jobNo){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, jobNo);
			list = query.list();
			if(list.size()>0)
				jBean = (RepEntJobInfoViewId)list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return jBean;
	}
	/**
	 * @throws Exception 
	 * 
	* @Title: GetEntJobInfoList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @return    设定文件 
	* @return List<RepEntJobInfo>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_EntNo_jobName(int EntNo,String jobName,String jobAddrPosName,int c,int p ,String sortBy,String
			sortMethod) throws Exception{
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where id.entNo = ? and id.jobName like ? and id.jobAddrPosName like ?  order by %s %s";
		try{
			
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (jobName==null?"":jobName) + '%');
			query.setParameter(2, '%' + (jobAddrPosName==null?"":jobAddrPosName) + '%');
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
	* @Title: GetEntJobInfoList_By_EntNo_jobBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param jobBean
	* @param @param c
	* @param @param p
	* @param @param sortBy
	* @param @param sortMethod
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_EntNo_jobBean(int EntNo,RepEntJobInfoViewId jobBean,int c,int p ,String sortBy,String
			sortMethod) throws Exception{
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where id.entNo = ? and id.jobName like ? and id.jobAddrPosName like ? "
				+ "and id.educationDictNo like ? and id.jobExpDictNo like ? and id.jobSex like ? and id.jobSalaryNo like ? "
				+ "and id.jobTypePos like ? and id.jobIntentionDictType like ? and id.jobIntentionDictNo like ? order by %s %s";
		try{
			
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (jobBean.getJobName()==null?"":jobBean.getJobName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (jobBean.getJobAddrPosName()==null?"":jobBean.getJobAddrPosName()) + '%',	StringType.INSTANCE);
			query.setParameter(3, "%" + String.valueOf((jobBean.getEducationDictNo()==0?"":jobBean.getEducationDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((jobBean.getJobExpDictNo()==0?"":jobBean.getJobExpDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, '%' + (jobBean.getJobSex()==null?"":jobBean.getJobSex()) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + String.valueOf((jobBean.getJobSalaryNo()==0?"":jobBean.getJobSalaryNo())) + "%",	StringType.INSTANCE);
			query.setParameter(7, "%" + String.valueOf((jobBean.getJobTypePos()==0?"":jobBean.getJobTypePos())) + "%",	StringType.INSTANCE);
			query.setParameter(8, '%' + (jobBean.getJobIntentionDictType()==null?"":jobBean.getJobIntentionDictType()) + '%',	StringType.INSTANCE);
			query.setParameter(9, '%' + String.valueOf((jobBean.getJobIntentionDictNo()==0?"":jobBean.getJobIntentionDictNo())) + '%',	StringType.INSTANCE);
			
			query.setFirstResult((c-1)*p);
			query.setMaxResults(p);
			list = query.list();
			}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		catch(Exception e){
			throw new Exception(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}
	/**
	 * 
	* @Title: GetEntJobInfoList_By_EntNo_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_EntNo_All(int EntNo) throws Exception{
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where id.entNo = ?";
		try{
			
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
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
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_EntNo_All_Allowed(int EntNo) throws Exception{
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where id.entNo = ?"
			+" and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime)";
		try{
			
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, new Date());
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
	* @Title: CountEntJobInfoList_By_All_Allowed 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @param entName
	* @param @param jobAddrPosName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobInfoList_By_All_Allowed(String jobName,String entName,String jobAddrPosName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobInfoView where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ? "
				+ "and id.educationDictNo like ? and id.jobExpDictNo like ? and id.jobSex like ? and id.jobSalaryNo like ? and id.jobTypePriDictNo like ?"
				+ "and id.jobTypePos like ? and id.jobIntentionDictType like ? and id.jobIntentionDictNo like ?"
				+ "and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime)";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (jobName==null?"":jobName) + '%');
			query.setParameter(1, '%' + (entName==null?"":entName) + '%');
			query.setParameter(2, '%' + (jobAddrPosName==null?"":jobAddrPosName) + '%');
			query.setParameter(3, new Date());
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
	* @Title: CountEntJobInfoList_By_All_jobBean_Allowed 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @param entName
	* @param @param jobAddrPosName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobInfoList_By_All_jobBean_Allowed(RepEntJobInfoViewId jobBean){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobInfoView where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ? "
				+ "and id.educationDictNo like ? and id.jobExpDictNo like ? and id.jobSex like ? and id.jobSalaryNo like ? "
				+ "and id.jobTypePos like ? and id.jobIntentionDictType like ? and id.jobIntentionDictNo like ?"
				+ "and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime)";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (jobBean.getJobName()==null?"":jobBean.getJobName()) + '%',	StringType.INSTANCE);
			query.setParameter(1, '%' + (jobBean.getEntName()==null?"":jobBean.getEntName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (jobBean.getJobAddrPosName()==null?"":jobBean.getJobAddrPosName()) + '%',	StringType.INSTANCE);
			query.setParameter(3, "%" + String.valueOf((jobBean.getEducationDictNo()==0?"":jobBean.getEducationDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((jobBean.getJobExpDictNo()==0?"":jobBean.getJobExpDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, '%' + (jobBean.getJobSex()==null?"":jobBean.getJobSex()) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + String.valueOf((jobBean.getJobSalaryNo()==0?"":jobBean.getJobSalaryNo())) + "%",	StringType.INSTANCE);
			query.setParameter(7, "%" + String.valueOf((jobBean.getJobTypePos()==0?"":jobBean.getJobTypePos())) + "%",	StringType.INSTANCE);
			query.setParameter(8, '%' + (jobBean.getJobIntentionDictType()==null?"":jobBean.getJobIntentionDictType()) + '%',	StringType.INSTANCE);
			query.setParameter(9, '%' + String.valueOf((jobBean.getJobIntentionDictNo()==0?"":jobBean.getJobIntentionDictNo())) + '%',	StringType.INSTANCE);
			query.setParameter(10, new Date());
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
	* @Title: CountEntJobInfoList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public Long CountEntJobInfoList_By_All(String jobName,String entName,String jobAddrPosName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobInfoView where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (jobName==null?"":jobName) + '%');
			query.setParameter(1, '%' + (entName==null?"":entName) + '%');
			query.setParameter(2, '%' + (jobAddrPosName==null?"":jobAddrPosName) + '%');
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
	* @Title: CountEntJobInfoList_By_jobBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @param entName
	* @param @param jobAddrPosName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobInfoList_By_entNo_jobBean(int EntNo ,RepEntJobInfoViewId jobBean){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobInfoView where id.entNo = ? and id.jobName like ? and id.jobAddrPosName like ? "
				+ "and id.educationDictNo like ? and id.jobExpDictNo like ? and id.jobSex like ? and id.jobSalaryNo like ? "
				+ "and id.jobTypePos like ? and id.jobIntentionDictType like ? and id.jobIntentionDictNo like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (jobBean.getJobName()==null?"":jobBean.getJobName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (jobBean.getJobAddrPosName()==null?"":jobBean.getJobAddrPosName()) + '%',	StringType.INSTANCE);
			query.setParameter(3, "%" + String.valueOf((jobBean.getEducationDictNo()==0?"":jobBean.getEducationDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((jobBean.getJobExpDictNo()==0?"":jobBean.getJobExpDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, '%' + (jobBean.getJobSex()==null?"":jobBean.getJobSex()) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + String.valueOf((jobBean.getJobSalaryNo()==0?"":jobBean.getJobSalaryNo())) + "%",	StringType.INSTANCE);
			query.setParameter(7, "%" + String.valueOf((jobBean.getJobTypePos()==0?"":jobBean.getJobTypePos())) + "%",	StringType.INSTANCE);
			query.setParameter(8, '%' + (jobBean.getJobIntentionDictType()==null?"":jobBean.getJobIntentionDictType()) + '%',	StringType.INSTANCE);
			query.setParameter(9, '%' + String.valueOf((jobBean.getJobIntentionDictNo()==0?"":jobBean.getJobIntentionDictNo())) + '%',	StringType.INSTANCE);
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
	* @Title: CountEntJobUserList_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobUserList_By_UserNo(int userNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.userNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
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
	public Long CountEntJobUserListWithState_By_UserNo(int userNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.userNo = ? and id.stateName != '未回复'";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
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
	* @Title: CountEntJobUserList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobUserList_By_EntNo(int entNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
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
	* @Title: CountEntJobUserList_By_EntNo_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobUserList_By_EntNo_isNotSelf(int entNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? "
			+ "and id.reserved01 is null";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
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
	* @Title: CountEntJobUserList_By_EntNo_isNotSelf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @param isR
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobUserList_By_EntNo_isNotSelf(int entNo,Boolean isR){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? "
			+ "and id.reserved01 is null"
			+(isR?" and id.state = -1":" and id.state = 0");
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
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
	* @Title: GetEntJobInfoList_By_All_Allowed 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param intentionNo
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All_Allowed(String intentionNo){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where "
				+ "CONCAT(CONCAT(',',?),',') LIKE CONCAT(CONCAT('%,',id.jobIntentionDictNo),',%') "
				+ "and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime)";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, intentionNo);
			query.setParameter(1, new Date());
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
	* @Title: GetEntJobInfoList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param intentionNo
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All(String intentionNo){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView") +" where "
				+ "CONCAT(CONCAT(',',?),',') LIKE CONCAT(CONCAT('%,',id.jobIntentionDictNo),',%')";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, intentionNo);
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
	* @Title: GetEntJobInfoList_By_All_Allowed 
	* @Description: TODO(这里用一句话描述这个方法的作用)  允许范围内的（开始-结束时间，状态-通过[0 未审核 1 通过 2 未通过]）
	* @param @param jobName
	* @param @param entName
	* @param @param jobAddrPosName
	* @param @param c
	* @param @param p
	* @param @param sortBy
	* @param @param sortMethod
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All_Allowed(String jobName,String entName,String jobAddrPosName,int c,int p ,String sortBy,String
			sortMethod){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ? "
				+ "and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime) order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, '%' + (jobName==null?"":jobName) + '%');
			query.setParameter(1, '%' + (entName==null?"":entName) + '%');
			query.setParameter(2, '%' + (jobAddrPosName==null?"":jobAddrPosName) + '%');
			query.setParameter(3, new Date());
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
	
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All_jobBean_Allowed(RepEntJobInfoViewId jobBean,int c,int p ,String sortBy,String
			sortMethod){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ? "
				+ "and id.educationDictNo like ? and id.jobExpDictNo like ? and id.jobSex like ? and id.jobSalaryNo like ? "
				+ "and id.jobTypePos like ? and id.jobIntentionDictType like ? and id.jobIntentionDictNo like ?"
				+ "and id.jobState = 1 and (? between id.jobStartTime and id.jobEndTime) order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, '%' + (jobBean.getJobName()==null?"":jobBean.getJobName()) + '%',	StringType.INSTANCE);
			query.setParameter(1, '%' + (jobBean.getEntName()==null?"":jobBean.getEntName()) + '%',	StringType.INSTANCE);
			query.setParameter(2, '%' + (jobBean.getJobAddrPosName()==null?"":jobBean.getJobAddrPosName()) + '%',	StringType.INSTANCE);

			query.setParameter(3, "%" + String.valueOf((jobBean.getEducationDictNo()==0?"":jobBean.getEducationDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(4, "%" + String.valueOf((jobBean.getJobExpDictNo()==0?"":jobBean.getJobExpDictNo())) + "%",	StringType.INSTANCE);
			query.setParameter(5, '%' + (jobBean.getJobSex()==null?"":jobBean.getJobSex()) + '%',	StringType.INSTANCE);
			query.setParameter(6, "%" + String.valueOf((jobBean.getJobSalaryNo()==0?"":jobBean.getJobSalaryNo())) + "%",	StringType.INSTANCE);
			query.setParameter(7, "%" + String.valueOf((jobBean.getJobTypePos()==0?"":jobBean.getJobTypePos())) + "%",	StringType.INSTANCE);
			query.setParameter(8, '%' + (jobBean.getJobIntentionDictType()==null?"":jobBean.getJobIntentionDictType()) + '%',	StringType.INSTANCE);
			query.setParameter(9, '%' + String.valueOf((jobBean.getJobIntentionDictNo()==0?"":jobBean.getJobIntentionDictNo())) + '%',	StringType.INSTANCE);
			
			query.setParameter(10, new Date());
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
	* @Title: GetEntJobInfoList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param jobName
	* @param @return    设定文件 
	* @return List<RepEntJobInfoViewId>    返回类型 
	* @throws
	 */
	public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All(String jobName,String entName,String jobAddrPosName,int c,int p ,String sortBy,String
			sortMethod){
		query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entName like ? and id.jobAddrPosName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, '%' + (jobName==null?"":jobName) + '%');
			query.setParameter(1, '%' + (entName==null?"":entName) + '%');
			query.setParameter(2, '%' + (jobAddrPosName==null?"":jobAddrPosName) + '%');
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
	* @Title: GetEntJobUserBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @param jobNo
	* @param @return    设定文件 
	* @return RepEntJobUserViewId    返回类型 
	* @throws
	 */
	public RepEntJobUser GetEntJobUserBean(int userNo,int jobNo) {
		List<RepEntJobUser> list;
		RepEntJobUser b = null;
		query_statement = "from RepEntJobUser where id.userNo = ? and id.jobNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			query.setParameter(1, jobNo);
			list = query.list();
			if(list.size()>0)
				b = (RepEntJobUser)list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return b;
	}
	public List<RepEntJobUserViewId> GetEntJobUserList_By_All(String entName,String jobName,int c,int p ,String sortBy,String
			sortMethod) {
		List<RepEntJobUserViewId> list;
		query_statement = HQLScripts.GetScript("RepEntJobUserView")+" where id.entName = ? and id.jobName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, entName);
			query.setParameter(1, '%' + (jobName==null?"":jobName) + '%');
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
	public Long CountEntJobUserList_By_All(String entName,String jobName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entName like ? and id.jobName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (entName==null?"":entName) + '%');
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
	public List<RepEntJobUserViewId> GetEntJobUserList_By_All_myLib(int entNo,String jobName,int c,int p ,String sortBy,String
			sortMethod) {
		List<RepEntJobUserViewId> list;
		query_statement = HQLScripts.GetScript("RepEntJobUserView")+" where id.entNo = ? and id.jobName like ? and id.state>=2 order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, entNo);
			query.setParameter(1, '%' + (jobName==null?"":jobName) + '%');
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
	public Long CountEntJobUserList_By_All_myLib(int entNo,String jobName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntJobUserView where id.entNo = ? and id.jobName like ? and id.state>=2";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
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
	public List<RepEntJobInfoViewId> GetEntJobItems_By_All(int pageNum, int numPerPage,String orderField, String orderDirection, String keyword) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepEntJobInfoViewId> list = null;
		String addrname = (String) session.get("admin_range");
		int admin_type = (int) session.get("admin_type");
		if(addrname==null){
			addrname="";
		}
		if(admin_type==0){
			List<RepEntJobInfoViewId> list1 = new ArrayList<RepEntJobInfoViewId>();
			/*String[] params = new String[] {addrname, orderField,orderDirection};
			query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entNo in "
					+ "(select id.entNo from com.ree.hibernate.RepEntInfoView where (id.communityAddr like '%s%%' or id.communityAddr is null)) order by %s %s";*/
			String[] params = new String[] {orderField,orderDirection};
			query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entNo in "
					+ "(select id.entNo from com.ree.hibernate.RepEntInfoView where (id.communityAddr like ? or id.communityAddr is null)) order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(1, '%' + (addrname==null?"":addrname) + '%');
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
				list = query.list();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}			
			return list;
		}else{
			List<RepEntJobInfoViewId> list1 = new ArrayList<RepEntJobInfoViewId>();
			String[] params = new String[] {addrname, orderField,orderDirection};
			query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ? and id.entNo in "
					+ "(select id.entNo from com.ree.hibernate.RepEntInfoView where id.communityAddr like '%s%%') order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
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
	private String Get_Addr_By_Name(String entName) {
		List<RepEntInfoViewId> list = null;
		RepEntInfoViewId rBean;
		String addrname = null;
		query_statement = HQLScripts.GetScript("RepEntInfoView")+" where id.entName = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0,entName);
			list = query.list();
			rBean = list.get(0);
			addrname = rBean.getCommunityAddr();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return addrname;
	}

	public int GetEntJobTotalCount_By_All(int pageNum, int numPerPage,String orderField, String orderDirection, String keyword) {
		List<RepEntJobInfoViewId> list = null;
		List<RepEntJobInfoViewId> list1 = new ArrayList<RepEntJobInfoViewId>();
		int count=0;
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		query_statement = HQLScripts.GetScript("RepEntJobInfoView")+" where id.jobName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			list = query.list();
			for(RepEntJobInfoViewId r:list){
				
				String addrname = null;
				addrname = Get_Addr_By_Name(r.getEntName());
				if((addrname==null?"":addrname).contains(session.get("admin_range")==null?"":session.get("admin_range").toString())){
				list1.add(r);	
				}
			}
			count=list1.size();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return count;
	}
	
}
