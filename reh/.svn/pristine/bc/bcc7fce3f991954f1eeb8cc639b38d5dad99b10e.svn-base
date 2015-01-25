package com.reh.user;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

public class UserShow extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userNo;
	private int u_type = 0;
	private HashMap<String, Object> store = new HashMap<String, Object>();
	private Boolean suc;
	private String msg ;
	
	public String User_Show(){
		UserAdapter u = new UserAdapter();
		if(u_type == 0){
			UserMsgBoxBean bean = u.GetBoxBean_By_UserNo(userNo);
			store.put("recruitNum", bean.getRecruitNum());
			store.put("recruitHasStateNum", bean.getRecruitHasStateNum());
		}
		return SUCCESS;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public HashMap<String, Object> getStore() {
		return store;
	}
	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
	public Boolean getSuc() {
		return suc;
	}
	public void setSuc(Boolean suc) {
		this.suc = suc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
