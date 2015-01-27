/**   
* @Title: FavouriteAction.java 
* @Package com.ree.favourite 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月20日 下午11:41:13 
* @version  
*/
package com.ree.favourite;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.enterprise.EntJobDao;
import com.ree.hibernate.RepEntAuditionUser;
import com.ree.hibernate.RepEntAuditionUserId;
import com.ree.hibernate.RepEntFavourite;
import com.ree.hibernate.RepEntFavouriteId;
import com.ree.hibernate.RepEntFavouriteViewId;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserId;
import com.ree.hibernate.RepEntJobUserView;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.userrecruit.RecruitJobDao;

/** 
 * @ClassName: FavouriteAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月20日 下午11:41:13 
 *  
 */
public class FavouriteAction extends ActionSupport {
	FavouriteDao fDao = new FavouriteDao();
	/**
	 * 输入
	 */
	private int selectedjobNo;
	
	RepUserInfo userBean = new RepUserInfo();
	RepEntJobInfo jobBean = new RepEntJobInfo();
	RepEntInfo entBean = new RepEntInfo();
	RepEntAuditionUser auditionBean = new RepEntAuditionUser();
	private int c;
	private int p;
	private String sortBy = "";
	private String sortMethod = "";
	/**
	 * 输出
	 */
	private String sc = "";
	private int status;
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();
	
	List<RepEntFavouriteViewId> list;
	
	/**
	 * 
	* @Title: Add 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Add(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        RepEntFavourite b;
        RepEntFavouriteId id = new RepEntFavouriteId();
		try{
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1){
				status = 1;
				throw new Exception("未登录");
			}
			
			RepEntInfo entbean = (RepEntInfo)session.get("entbean");
			id.setEntNo(entbean.getEntNo());
			id.setUserNo(userBean.getUserNo());
			b = (RepEntFavourite)fDao.getBean(RepEntFavourite.class,id);
			if(b==null){
				//新添加，而非已加入
				b = new RepEntFavourite();
				//取消收藏夹和职位的关联-关联到人
				//if(jobBean.getJobNo()!=0)
				//	b.setJobNo(jobBean.getJobNo());
				b.setId(id);
				b.setSubmittime(new Date());
				fDao.Add_Favourite_By_Bean(b);
			}
			else
			    throw new Exception("已添加");
			   
			//取消收藏夹和职位的关联-关联到人
//			//改变EJU状态
//			RecruitJobDao rDao = new RecruitJobDao();
//			RepEntJobUserId EJUId = new RepEntJobUserId();
//			EJUId.setUserNo(userBean.getUserNo());
//			EJUId.setJobNo(jobBean.getJobNo());
//			RepEntJobUser rBean = (RepEntJobUser)fDao.getBean(RepEntJobUser.class,EJUId);
//			if(rBean == null){
//			}
//			else if(rBean.getState()==0){
//				rBean.setState(1);
//				rDao.UpdateRecruit_By_Bean(rBean);
//			}
			
			status = 3;
		}
		catch(Exception e){
			sc+= e.getMessage()==null?e.getClass():e.getMessage();
			status = (status == 1?status : 2);
		}
		finally{
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	public String Del() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		try {
			if (session.get("u_type") == null
					|| Integer.parseInt(session.get("u_type").toString()) != 1) {
				status = 1;
				throw new Exception("未登录");
			}
			RepEntInfo entbean = (RepEntInfo)session.get("entbean");
			RepEntFavouriteId FId = new RepEntFavouriteId();
			FId.setUserNo(userBean.getUserNo());
			FId.setEntNo(entbean.getEntNo());
			
			fDao.Delete(fDao.getBean(RepEntFavourite.class, FId));
			//取消收藏夹和职位的关联-关联到人
//			if(jobBean.getJobNo()!=0){//不是公司主动招聘
//				//改变EJU状态
//				RecruitJobDao rDao = new RecruitJobDao();
//				RepEntJobUserId EJUId = new RepEntJobUserId();
//				EJUId.setUserNo(userBean.getUserNo());
//				EJUId.setJobNo(jobBean.getJobNo());
//				RepEntJobUser rBean = (RepEntJobUser)fDao.getBean(RepEntJobUser.class,EJUId);
//				rBean.setState(0);
////				if(rBean.getReserved01()!=null&&rBean.getReserved01().equals("1"))
////					rDao.Delete(rBean);
////				else
//					rDao.UpdateRecruit_By_Bean(rBean);
//			}
			status = 3;
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	/**
	 * 
	* @Title: Refuse 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Refuse(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		try{
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1){
				status = 1;
				throw new Exception("未登录");
			}
			//改变EJU状态
			RecruitJobDao rDao = new RecruitJobDao();
			RepEntJobUserId EJUId = new RepEntJobUserId();
			EJUId.setUserNo(userBean.getUserNo());
			EJUId.setJobNo(jobBean.getJobNo());
			RepEntJobUser rBean = (RepEntJobUser)fDao.getBean(RepEntJobUser.class,EJUId);
			rBean.setState(-1);
			rDao.UpdateRecruit_By_Bean(rBean);
			status = 3;
		}
		catch(Exception e){
			sc+= e.getMessage()==null?e.getClass():e.getMessage();
			status = (status == 1?status : 2);
		}
		finally{
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	/**
	 * 
	* @Title: AuditionView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String AuditionView(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		try{
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=0){
				status = 1;
				throw new Exception("未登录");
			}
			AuditionDao aDao = new AuditionDao();
			RepEntAuditionUserId id = new RepEntAuditionUserId();
			id.setUserNo(userBean.getUserNo());
			id.setJobNo(jobBean.getJobNo());
			RepEntAuditionUser bean = (RepEntAuditionUser) aDao.getBean(RepEntAuditionUser.class, id);
			if(bean!=null)
			{
				sc = "面试地点:"+bean.getAuditionAddr()+",面试时间:"+bean.getAuditionTime();
				status = 3;
			}
			else{
				status = 2;
			}
			
		}
		catch(Exception e){
			sc+= e.getMessage()==null?e.getClass():e.getMessage();
			status = (status == 1?status : 2);
		}
		finally{
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	/**
	 * 
	* @Title: Audition 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@SuppressWarnings("unused")
	public String Audition(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		try{
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1){
				status = 1;
				throw new Exception("未登录");
			}
			if(auditionBean.getAuditionTime()==null||auditionBean.getAuditionAddr()==null ||"".equals(auditionBean.getAuditionAddr()))
				throw new Exception("信息不完整");
			AuditionDao aDao = new AuditionDao();
			RepEntAuditionUserId id = new RepEntAuditionUserId();
			id.setUserNo(userBean.getUserNo());
			id.setJobNo(jobBean.getJobNo()==0?selectedjobNo:jobBean.getJobNo());
			RepEntAuditionUser bean = (RepEntAuditionUser) aDao.getBean(RepEntAuditionUser.class, id);
			if(bean==null){
				//空 需要添加
				bean = new RepEntAuditionUser();
				bean.setId(id);
				bean.setAuditionAddr(auditionBean.getAuditionAddr());
				bean.setAuditionTime(auditionBean.getAuditionTime());
				bean.setSubmittime(new Date());
				aDao.Save(bean);
			}
			else{
				//非空 需要修改
				
				bean.setAuditionAddr(auditionBean.getAuditionAddr());
				bean.setAuditionTime(auditionBean.getAuditionTime());
				bean.setSubmittime(new Date());
				aDao.Update(bean);
			}
			//改变EJU状态
			RecruitJobDao rDao = new RecruitJobDao();
			RepEntJobUserId EJUId = new RepEntJobUserId();
			EJUId.setUserNo(userBean.getUserNo());
			EJUId.setJobNo(jobBean.getJobNo()==0?selectedjobNo:jobBean.getJobNo());
			RepEntJobUser rBean = (RepEntJobUser)fDao.getBean(RepEntJobUser.class,EJUId);
			if(rBean==null){
				//空 需要添加
				rBean = new RepEntJobUser();
				rBean.setId(EJUId);
				rBean.setState(2);//通知面试
				rBean.setSubmittime(new Date());
				rBean.setAuditiontime(new Date());
				rBean.setReserved01(jobBean.getJobNo()==0&&selectedjobNo!=0?"1":null);
				rDao.Save(rBean);
				//取消收藏夹和职位的关联-关联到人
//				//更新收藏夹
//				RepEntInfo entbean = (RepEntInfo)session.get("entbean");
//				RepEntFavouriteId FId = new RepEntFavouriteId();
//				FId.setUserNo(userBean.getUserNo());
//				FId.setEntNo(entbean.getEntNo());
//				RepEntFavourite fbean = (RepEntFavourite)fDao.getBean(RepEntFavourite.class, FId);
//				if(fbean!=null){
//					//不进入收藏夹
//					fbean.setJobNo(jobBean.getJobNo()==0?selectedjobNo:jobBean.getJobNo());
//					fDao.Update(fbean);
//				}
				
			}
			else{
				//非空 需要修改
				rBean.setState(2);//通知面试
				rBean.setAuditiontime(bean.getAuditionTime());
				rBean.setReserved01(jobBean.getJobNo()==0&&selectedjobNo!=0?"1":null);
				rDao.UpdateRecruit_By_Bean(rBean);
			}
			status = 3;
		}
		catch(Exception e){
			sc+= e.getMessage()==null?e.getClass():e.getMessage();
			status = (status == 1?status : 2);
		}
		finally{
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	/**
	 * 
	* @Title: Get_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Get_By_EntNo(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		try{
			RepEntInfo entbean = (RepEntInfo)session.get("entbean");
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1||entbean.getEntNo()==null){
				status = 1;
				throw new Exception("未登录");
			}
			list = fDao.GetFavouriteViewList_By_EntNo(entbean.getEntNo(),userBean.getUserName(),c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", fDao.CountEntJobInfoList_By_All(entbean.getEntNo(),userBean.getUserName()));
			status = 3;
		}
		catch(Exception e){
			sc+= e.getMessage()==null?e.getClass():e.getMessage();
			status = (status == 1?status : 2);
		}
		finally{
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}


	public RepUserInfo getUserBean() {
		return userBean;
	}


	public void setUserBean(RepUserInfo userBean) {
		this.userBean = userBean;
	}


	public RepEntJobInfo getJobBean() {
		return jobBean;
	}


	public void setJobBean(RepEntJobInfo jobBean) {
		this.jobBean = jobBean;
	}
	public RepEntAuditionUser getAuditionBean() {
		return auditionBean;
	}
	public void setAuditionBean(RepEntAuditionUser auditionBean) {
		this.auditionBean = auditionBean;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortMethod() {
		return sortMethod;
	}
	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public RepEntInfo getEntBean() {
		return entBean;
	}
	public void setEntBean(RepEntInfo entBean) {
		this.entBean = entBean;
	}
	public int getSelectedjobNo() {
		return selectedjobNo;
	}
	public void setSelectedjobNo(int selectedjobNo) {
		this.selectedjobNo = selectedjobNo;
	}
}
