/**   
* @Title: RefreshRoleAction.java 
* @Package com.ree.login 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月30日 下午5:50:14 
* @version  
*/
package com.ree.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: RefreshRoleAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月30日 下午5:50:14 
 *  
 */
public class RefreshRoleAction extends ActionSupport{
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	private HashMap<String, Object> store;
			
	public HashMap<String, Object> getStore() {
		return store;
	}
	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	
	/**
	 * Dao
	 */
	private LoginDao lDao = new LoginDao();
	
	public String execute() throws IOException, ClassNotFoundException, SQLException
	{  			
		String uid = this.getUsername();
		setStore(lDao.checkAdminRole(uid));
		return SUCCESS;
	}
	
}
