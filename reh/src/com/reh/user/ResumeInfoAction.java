package com.reh.user;

import java.io.*;
import java.text.ParseException;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * <p>Title: NewsAction<／p>
 * <p>Description:处理新闻的增加，修改 <／p> 
 * @author 李丁
 * @date 2014年7月15日
 */
public class ResumeInfoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 输入
	 */

	private int user_id;
	
	public String execute() throws IOException, ParseException
	{		
	    	return SUCCESS;				
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
