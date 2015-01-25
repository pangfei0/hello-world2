/**   
* @Title: LibAction.java 
* @Package com.ree.user 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月22日 上午3:43:14 
* @version  
*/
package com.reh.user;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.favourite.FavouriteDao;
import com.ree.hibernate.RepEntAuditionUser;
import com.ree.hibernate.RepEntFavouriteViewId;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoView;
import com.ree.hibernate.RepUserInfoViewId;

/** 
 * @ClassName: LibAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月22日 上午3:43:14 
 *  
 */
public class LibAction extends ActionSupport {
	FavouriteDao fDao = new FavouriteDao();
	/**
	 * 输入
	 */
	RepUserInfoViewId userBean = new RepUserInfoViewId();
	RepEntJobInfo jobBean = new RepEntJobInfo();
	RepEntAuditionUser auditionBean = new RepEntAuditionUser();
	
	private String jobIntentionDictType;
	
	private int c;
	private int p;
	private String sortBy = "";
	private String sortMethod = "";
	private String keyword = "";
	/**
	 * 输出
	 */
	private String sc = "";
	private int status;
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();
	
	List<RepUserInfoViewId> list;
	UserDao uDao;
	/**
	 * (非 Javadoc) 
	* <p>Title: execute</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		uDao = new UserDao();
		try {
			if (session.get("u_type") == null) {
				status = 1;
				throw new Exception("未登录");
			}
			list = uDao.GetUserViewList_By_userBean(userBean,jobIntentionDictType,c,p,sortBy,sortMethod);
			//list = uDao.GetUserViewList_By_Keyword(keyword,c,p,sortBy,sortMethod);
			store.put("data", list);
			//store.put("totalNum", uDao.CountUserViewList_By_Keyword(keyword));
			store.put("totalNum", uDao.CountUserViewList_By_userBean(userBean,jobIntentionDictType));
			status = 3;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
			
		}
		finally {
			store.put("msg", sc);
			store.put("status", status);
		}

		return SUCCESS;
	}
	public FavouriteDao getfDao() {
		return fDao;
	}
	public void setfDao(FavouriteDao fDao) {
		this.fDao = fDao;
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
	public HashMap<String, Object> getStore() {
		return store;
	}
	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	public UserDao getuDao() {
		return uDao;
	}
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public RepUserInfoViewId getUserBean() {
		return userBean;
	}
	public void setUserBean(RepUserInfoViewId userBean) {
		this.userBean = userBean;
	}
	public String getJobIntentionDictType() {
		return jobIntentionDictType;
	}
	public void setJobIntentionDictType(String jobIntentionDictType) {
		this.jobIntentionDictType = jobIntentionDictType;
	}
}
