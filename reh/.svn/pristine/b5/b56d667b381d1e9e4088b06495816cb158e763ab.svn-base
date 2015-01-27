package com.reh.securitycode.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	//接收客户端传来的验证码
	private String codename;

	public String execute() throws Exception {	 
		      
		     try{
		          String serverCode = (String)session.get("SESSION_SECURITY_CODE");

		          if(!serverCode.equals(codename)){
		              return ERROR;
		          }
		          }catch(Exception e){
		        	  e.printStackTrace();
		          }
		          //继续判断用户名和密码，这个简单的例子就省略了
		          
		          return SUCCESS;
		      }
		  
		      public void setSession(Map<String, Object> session) {
		          this.session = session;
		      }
		      
		      public String getCodename() {
		          return codename;
		      }
		  
		      public void setCodename(String codename) {
		          this.codename = codename;
		     }
	}


