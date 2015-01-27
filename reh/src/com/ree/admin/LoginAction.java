/**
 * LoginAction
 * 李丁
 */
package com.ree.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ree.admin.LoginDao;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	private String type = null;
	private String message = null;
	private int statusCode = 0;
	private String sc = null;
	private List<String> SList = new ArrayList<String>();
	/**
	 * Dao
	 */
	private LoginDao lDao = new LoginDao();

	public String execute() throws Exception {
		String uname = getUsername();
		String pwd = getPassword();
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
		if(session.get("admin_uid")!=null)
		{
			this.setUsername((String)session.get("admin_uid"));
	        if(type!=null&&type.equals("dialog"))
	        {
	        	message = "已登陆";
	        	statusCode = 200;
	        	return "DIALOG";
	        } 
	        else
	        	return SUCCESS;
		}	
		else if(uname==null||pwd==null)
			return ERROR;
		LinkedHashMap<String, Object> data = lDao.checkLogin(uname, pwd);
		if (data.isEmpty()||!(Boolean)data.get("success")) {
			sc = "用户名或密码错误";
	        if(type!=null&&type.equals("dialog"))
	        {
	        	message = sc;
	        	statusCode = 300;
	        	return "DIALOG";
	        } 
	        else
	        	return ERROR;
		}
		else if(data.get("type").equals("-2")||data.get("type").equals("-3")){
			sc = "此用户未审核！";
			return ERROR;
		}
		else {
			session.put("admin_uid", data.get("admin_uid"));
	        session.put("admin_type",data.get("type"));
	        session.put("admin_name", data.get("admin_name"));
	        session.put("admin_list", data.get("admin_list"));
	        session.put("admin_range", data.get("admin_range"));
	        if(type!=null&&type.equals("dialog"))
	        {
	        	message = "登陆成功";
	        	statusCode = 200;
	        	return "DIALOG";
	        } 	
	        else
	        	return SUCCESS;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the sc
	 */
	public String getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}

	/**
	 * @return the sList
	 */
	public List<String> getSList() {
		return SList;
	}

	/**
	 * @param sList the sList to set
	 */
	public void setSList(List<String> sList) {
		SList = sList;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
