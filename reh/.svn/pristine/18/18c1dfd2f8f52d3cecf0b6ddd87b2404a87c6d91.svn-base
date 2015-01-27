package com.reh.Regist;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;
import com.reh.Regist.UserDao;
import com.reh.user.LoginDao;

public class PersonRegist2 extends ActionSupport{
	/*
	 *输入
	 *身份类型, 用户名： *  密       码： *  确认密码： *  姓       名： *  性       别： * 男：女： 邮       箱
	 */
      private int  u_type;
	  private String  USER_NAME;
	  private  String USER_PWD;
	  private String USER_UID;
	  private String USER_SEX;
	  private String USER_EMAIL;
	  
	/*
	   * 输出 
	   */
	  private String mes;
	  private Boolean status;
	
	  
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		RepUserInfo userbean = new RepUserInfo();
		UserDao uDao = new UserDao();
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		LinkedHashMap<String, Object> data ;
		LoginDao lDao = new LoginDao();
		// userbean.setUserNo(dao1.GetTotalCount()+1);
		USER_PWD=DBHelper.MD5(getUSER_PWD());
 		userbean.setUserName(getUSER_NAME());
		userbean.setUserUid(getUSER_UID());
		userbean.setUserPwd(USER_PWD);
		userbean.setUserEmail(getUSER_EMAIL());
		userbean.setUserSex(getUSER_SEX());
		String message = uDao.AddUser_by_Bean(userbean);
		if (message != null) {
			this.setMes(message);
			status=false;
			return "success";
			
		} else {
			data= (LinkedHashMap<String, Object>) lDao.checkLogin(USER_UID, USER_PWD, u_type);
			RepUserInfoViewId entview = (RepUserInfoViewId) data.get("view");
			RepUserInfo e = (RepUserInfo) data.get("bean");
			session.put("userbean", e);
			session.put("view", entview);
			session.put("u_type", u_type);
			session.put("lastTime", e.getReserved01());
			this.setMes("注册成功！");
			status=true;
		  
			
			return "success";
		}	
	}



	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}



	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}



	public String getUSER_PWD() {
		return USER_PWD;
	}



	public void setUSER_PWD(String uSER_PWD) {
		USER_PWD = uSER_PWD;
	}



	public String getUSER_SEX() {
		return USER_SEX;
	}



	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}



	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}



	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	  public String getUSER_UID() {
			return USER_UID;
		}
		public void setUSER_UID(String uID) {
			USER_UID = uID;
		}
		
	
		  public int getU_type() {
				return u_type;
			}

			public void setU_type(int u_type) {
				this.u_type = u_type;
			}

}
