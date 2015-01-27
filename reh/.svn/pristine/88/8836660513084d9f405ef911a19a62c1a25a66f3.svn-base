package com.ree.userrecruit;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepEntBlacklistUser;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUserView;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepUserInfo;

public class RecruitJobAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 输入
	 */
	RepEntJobUserViewId recruitBean = new RepEntJobUserViewId();
	int boxtype;//1-收件箱 2-拒绝箱
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

	List<RepEntJobUserViewId> list;
	RecruitJobDao rDao = new RecruitJobDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	* @Title: GetBlackList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String GetBlackList_By_EntNo(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepEntBlacklistUser> list;
		try{
			RepEntInfo entbean = (RepEntInfo)session.get("entbean");
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1||entbean.getEntNo()==null){
				status = 1;
				throw new Exception("未登录");
			}
			list = rDao.GetEntBlackList_By_EntNo(entbean.getEntNo(),recruitBean.getUserName(),c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", rDao.CountEntBlacklist_By_EntNo(entbean.getEntNo()));
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
			list = rDao.GetEntJobViewList_By_EntNoAndUserName_isNotSelf(entbean.getEntNo(),recruitBean.getUserName(),boxtype==1?false:true,c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", rDao.CountJobViewList_By_EntNoAndUserName_isNotSelf(entbean.getEntNo(), recruitBean.getUserName(),boxtype==1?false:true));
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
	* @Title: Get_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Get_By_UserNo(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		try{
			RepUserInfo userbean = (RepUserInfo)session.get("userbean");
			if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=0||userbean.getUserNo()==null){
				status = 1;
				throw new Exception("未登录");
			}
			list = rDao.GetEntJobViewList_By_UserNo(userbean.getUserNo(),recruitBean.getJobName(),c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", rDao.CountEntJobViewList_By_UserNo(userbean.getUserNo(),recruitBean.getJobName()));
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


	public RepEntJobUserViewId getRecruitBean() {
		return recruitBean;
	}


	public void setRecruitBean(RepEntJobUserViewId recruitBean) {
		this.recruitBean = recruitBean;
	}
	public int getBoxtype() {
	    return boxtype;
	}
	public void setBoxtype(int boxtype) {
	    this.boxtype = boxtype;
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
	
}
