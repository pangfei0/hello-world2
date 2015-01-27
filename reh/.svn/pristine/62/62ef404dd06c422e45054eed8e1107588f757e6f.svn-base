/**   
 * @Title: BlackListAction.java 
 * @Package com.ree.entblacklist 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator - 李丁
 * @date 2014年11月19日 下午8:05:44 
 * @version  
 */
package com.ree.entblacklist;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepEntAuditionUser;
import com.ree.hibernate.RepEntBlacklistUser;
import com.ree.hibernate.RepEntBlacklistUserId;
import com.ree.hibernate.RepEntFavourite;
import com.ree.hibernate.RepEntFavouriteId;
import com.ree.hibernate.RepEntFavouriteViewId;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserId;
import com.ree.hibernate.RepUserInfo;
import com.ree.userrecruit.RecruitJobDao;

/**
 * @ClassName: BlackListAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2014年11月19日 下午8:05:44
 * 
 */
public class BlackListAction extends ActionSupport {
    /**
     * * 输入
     * */
    private String userCert;
    private String newuserCert;
    RepEntInfo entBean = new RepEntInfo();
    /**
     * * 输出 *
     */
    private String sc = "";
    private int status;
    private HashMap<String, Object> store = new LinkedHashMap<String, Object>();

    List<RepEntFavouriteViewId> list;

    /**
     * dao
     */
    private BlackListDao bDao = new BlackListDao();
    /**
     * 
    * @Title: Alter 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public String Alter() {
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	try {
	    if (session.get("u_type") == null
		    || Integer.parseInt(session.get("u_type").toString()) != 1) {
		status = 1;
		throw new Exception("未登录");
	    }
	    entBean = (RepEntInfo)session.get("entbean");
	    
	    RepEntBlacklistUserId Id = new RepEntBlacklistUserId();
	    Id.setEntNo(entBean.getEntNo());
	    Id.setUserCert(userCert);
	    RepEntBlacklistUser bBean = (RepEntBlacklistUser) bDao.getBean(RepEntBlacklistUser.class, Id);
	    if(bBean==null)
		throw new Exception("失败：没有找到该信息。");
	    //修改主键
	    //先删除旧数据
	    bDao.Delete(bBean);
	    //再添加新数据
	    Id.setUserCert(newuserCert);
	    bBean.setId(Id);
	    bDao.Save(bBean);
	    status = 3;
	} catch (Exception e) {
	    sc += DBHelper.GetMsg(e);
	    status = (status == 1 ? status : 2);
	} finally {
	    store.put("msg", sc);
	    store.put("status", status);
	}
	return SUCCESS;
    }
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
	try{
		if(session.get("u_type")==null||Integer.parseInt(session.get("u_type").toString())!=1){
			status = 1;
			throw new Exception("未登录");
		}
		entBean = (RepEntInfo)session.get("entbean");
		RepEntBlacklistUserId Id = new RepEntBlacklistUserId();
		Id.setEntNo(entBean.getEntNo());
		Id.setUserCert(newuserCert);
		RepEntBlacklistUser bBean = (RepEntBlacklistUser) bDao.getBean(RepEntBlacklistUser.class, Id);
		if(bBean==null){
			//新添加，而非已加入
		    bBean = new RepEntBlacklistUser();
		    bBean.setId(Id);
		    bDao.Save(bBean);
		}
		else
		    throw new Exception("已添加同样内容");
		status = 3;
	}
	catch(Exception e){
		sc+= DBHelper.GetMsg(e);
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
    * @Title: Del 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public String Del() {
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	try {
		if (session.get("u_type") == null
				|| Integer.parseInt(session.get("u_type").toString()) != 1) {
			status = 1;
			throw new Exception("未登录");
		}
		entBean = (RepEntInfo)session.get("entbean");
		RepEntBlacklistUserId Id = new RepEntBlacklistUserId();
		Id.setEntNo(entBean.getEntNo());
		Id.setUserCert(userCert);
		RepEntBlacklistUser bBean = (RepEntBlacklistUser) bDao.getBean(RepEntBlacklistUser.class, Id);
		if(bBean==null)
		    throw new Exception("失败：没有找到该信息。");
		bDao.Delete(bBean);
		status = 3;
	} catch (Exception e) {
		sc += DBHelper.GetMsg(e);
		status = (status == 1 ? status : 2);
	} finally {
		store.put("msg", sc);
		store.put("status", status);
	}
	return SUCCESS;
}
    public String getUserCert() {
	return userCert;
    }

    public void setUserCert(String userCert) {
	this.userCert = userCert;
    }

    public String getNewuserCert() {
	return newuserCert;
    }

    public void setNewuserCert(String newuserCert) {
	this.newuserCert = newuserCert;
    }
    public HashMap<String, Object> getStore() {
        return store;
    }
    public void setStore(HashMap<String, Object> store) {
        this.store = store;
    }

}
