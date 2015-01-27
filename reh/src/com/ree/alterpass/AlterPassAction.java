package com.ree.alterpass;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.ree.common.DBHelper;
import com.ree.common.FileHelper;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;

public class AlterPassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oldpassword = null;
	private String newpassword = null;
	private String renewpassword = null;
	AlterPassDao aDao=new AlterPassDao();	
	private String sc = null;
	
	public String execute() throws Exception {
		String oldpass = DBHelper.MD5(getOldpassword());
		String newpass = DBHelper.MD5(getNewpassword());
		String renewpass = DBHelper.MD5(getRenewpassword());
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();	
		RepUserInfo uBean = (RepUserInfo) session.get("userbean");
		RepEntInfo eBean = (RepEntInfo) session.get("entbean");
		if(uBean!=null)
		{
			if(oldpass==null || newpass==null || renewpass==null){
				setSc("加  *字段不能为空");
				return SUCCESS;			
			}else if(aDao.Check_Users(uBean.getUserNo(),oldpass)){
				if(newpassword.equals(renewpassword)){
					uBean.setUserPwd(renewpass);
					aDao.Update_Bean(uBean);
					setSc("密码修改成功");
					return SUCCESS;
					
				}else{
					setSc("两次输入密码不一致");
					return SUCCESS;
				}
			}else{
				setSc("您输入的初始密码不正确");
				return SUCCESS;
			}
		}else{
			if(oldpass==null || newpass==null || renewpass==null){
				setSc("加  *字段不能为空");
				return SUCCESS;			
			}else if(aDao.Check_Ent(eBean.getEntNo(),oldpass)){
				if(newpassword.equals(renewpassword)){
					eBean.setEntPwd(renewpass);
					aDao.Update_ent_Bean(eBean);
					setSc("密码修改成功");
					return SUCCESS;
					
				}else{
					setSc("两次输入密码不一致");
					return SUCCESS;
				}
			}else{
				setSc("您输入的初始密码不正确");
				return SUCCESS;
			}
		}
		
		/*LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) lDao.checkLogin(uname, pwd, u_type);
		if (data.isEmpty() || data.get("success")=="false") {// 登录不成功
			setSc("用户名或密码错误");
			return ERROR;
		}else if(data.get("success")=="notpass"){
			setSc("请等待审核通过!");
			return ERROR;
		}		
		return ERROR;*/
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRenewpassword() {
		return renewpassword;
	}

	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}
	
}
