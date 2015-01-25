/** 
 * Project Name:rep 
 * File AuthorizationAction.java 
 * Package Name:com.rep.common 
 * Date:2014年7月16日下午12:53:10 
 * 
 */  
package com.ree.admin;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: AuthorizationAction<／p>
 * <p>Description:检查权限 <／p> 
 * @author 李丁
 * @date 2014年7月16日
 */
public class AuthorizationAction extends ActionSupport {
	/**
	 * 
	 */
	private String username;
	private int onlinecounter;
	private int type;
	private static final long serialVersionUID = 1L;

	public String Check() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        //session.clear();
        if(type == -3){
	        session.put("admin_type","-3");
	        return SUCCESS;
        }
        else if(session.get("admin_type")==null||session.get("admin_uid")==null)
        	return ERROR;
        this.setUsername(session.get("admin_uid")!=null?session.get("admin_uid").toString():null);
        this.setOnlinecounter(com.ree.sessioncounter.SessionCounter.getActiveSessions());
		return SUCCESS;
	}
	public String Logout() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
        actionContext.getSession().clear();
        ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the onlinecounter
	 */
	public int getOnlinecounter() {
		return onlinecounter;
	}
	/**
	 * @param onlinecounter the onlinecounter to set
	 */
	public void setOnlinecounter(int onlinecounter) {
		this.onlinecounter = onlinecounter;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
}
