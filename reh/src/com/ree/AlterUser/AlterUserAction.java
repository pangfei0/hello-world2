package com.ree.AlterUser;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminJobExpDict;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepUserInfo;



public class AlterUserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int userNo;
	private String userEmail;
	private String userName;
	private String userSex;
	private String userCert;
	private Integer userAddrDisNo;
	private String userAddrName;
	private String userAddrPos;
	private String userIntentDisNo;
	private Integer userEducationNo;
	private String educationDictName;
	private String userIntention;
	private String userPhone;
	private Integer userAge;
	private String userSkill;
	
	
	AlterDao aDao = new AlterDao();
	
	public String execute() throws IOException, ParseException
	{
		RepUserInfo uBean = aDao.GetUserBean(userNo);
		RepAdminCommunityInfo cBean = aDao.GetCommunityBean(userAddrDisNo);
		RepAdminUserEducationDict eBean = aDao.GetEduBean(userEducationNo);
		
		
		return SUCCESS;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserCert() {
		return userCert;
	}

	public void setUserCert(String userCert) {
		this.userCert = userCert;
	}

	public Integer getUserAddrDisNo() {
		return userAddrDisNo;
	}

	public void setUserAddrDisNo(Integer userAddrDisNo) {
		this.userAddrDisNo = userAddrDisNo;
	}

	public String getUserAddrName() {
		return userAddrName;
	}

	public void setUserAddrName(String userAddrName) {
		this.userAddrName = userAddrName;
	}

	public String getUserAddrPos() {
		return userAddrPos;
	}

	public void setUserAddrPos(String userAddrPos) {
		this.userAddrPos = userAddrPos;
	}

	public String getUserIntentDisNo() {
		return userIntentDisNo;
	}

	public void setUserIntentDisNo(String userIntentDisNo) {
		this.userIntentDisNo = userIntentDisNo;
	}

	public Integer getUserEducationNo() {
		return userEducationNo;
	}

	public void setUserEducationNo(Integer userEducationNo) {
		this.userEducationNo = userEducationNo;
	}

	public String getEducationDictName() {
		return educationDictName;
	}

	public void setEducationDictName(String educationDictName) {
		this.educationDictName = educationDictName;
	}

	public String getUserIntention() {
		return userIntention;
	}

	public void setUserIntention(String userIntention) {
		this.userIntention = userIntention;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}
	
}

