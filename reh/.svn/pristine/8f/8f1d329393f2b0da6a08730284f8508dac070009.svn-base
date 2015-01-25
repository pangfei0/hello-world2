package com.ree.findpass.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepUserInfo;
import com.ree.findpass.action.SimpleMailSender;
public class EntFindpassAction implements Action,SessionAware{
	private Map<String, Object> session;
	private String codename=null;
	private String email=null;
	private String username=null;
	private String sc = null;
	private String pass=null;
	private CheckDao cDao = new CheckDao();
	@Override
	public String execute() throws Exception {
	 String serverCode = (String)session.get("SESSION_SECURITY_CODE");
      if(!serverCode.equals(codename)){
    	  sc="验证码有误";
    	  return ERROR; 
       }else{
	        
		 String mail=getEmail();
		 String uname=getUsername();
		 List<RepEntInfo> data = cDao.entfindPass(uname,mail);
			if (data.size()==0) {
				sc = "用户名或邮箱不正确";	
				return ERROR;
			}else{				
				 Random rand= new Random();						
				 String randompass=String.valueOf(Math.abs(rand.nextInt(899999))+100000);
				 String rs= cDao.entresetPass(uname,randompass);						
			     MailSenderInfo mailInfo = new MailSenderInfo();    			      
			     mailInfo.setToAddress(mail);    
			     mailInfo.setSubject("找回密码");    
			     mailInfo.setContent("系统为你随机分配一个密码"+randompass+"，请登录后修改密码");    
			        //这个类主要来发送邮件   
			     SimpleMailSender.sendTextMail(mailInfo);//发送文体格式    
			        // sms.sendHtmlMail(mailInfo);//发送html格式   
			     sc = "请查看邮箱";
				return SUCCESS;
	            }
       }
	}
	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Map<String, Object> getSession() {
		return session;
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
