package com.ree.user;

import java.util.ArrayList;
import java.util.List;

import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntJobInfoView;
import com.ree.hibernate.RepEntJobUserId;
import com.ree.hibernate.RepEntJobUserView;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;
import com.ree.user.UserDao;
import com.ree.userrecruit.RecruitJobDao;

public class UserAdapter {
	private UserDao uDao = new UserDao();
	private RepUserInfo uBean = new RepUserInfo();
	private List<RepUserInfo> list = new ArrayList<RepUserInfo>();
	
	
	public UserMsgBoxBean GetBoxBean_By_UserNo(int userNo){
		return uDao.GetBoxBean_By_UserNo(userNo);
	}
	public RepEntJobUserViewId GetEntJobView_By_userNo_jobNo(int userNo ,int job_no){
		RecruitJobDao rDao = new RecruitJobDao();
		return rDao.GetEntJobView_By_userNo_jobNo(userNo,job_no);
	}
	public RepEntJobUserViewId GetEntJobUserView_By_Job_No(int job_no){
		RecruitJobDao rDao = new RecruitJobDao();
		return rDao.GetEntJobView_By_Job_No(job_no);
	}
	public RepUserInfoViewId GetUserInfo_By_User_Id(int user_id)
	{
		RepUserInfoViewId uBean=null; 
		uBean = (uDao.GetUserInfo_By_User_Id(user_id));
		return uBean;
	}
	public List<RepEntJobUserViewId> GetUserJobInfo_By_User_Id(int user_id)
	{
		List<RepEntJobUserViewId> list=new ArrayList<RepEntJobUserViewId>(); 
		list = uDao.GetUserJobInfo_By_User_Id(user_id);
		return list;
	}
	public List<RepUserInfoViewId> GetUserInfo_By_All(int pageNum,int numPerPage,String orderField,String orderDirection , String keyword)
	{
		List<RepUserInfoViewId> list = new ArrayList<RepUserInfoViewId>();
		list = uDao.GetUserInfo_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
		return list;
	}
	public List<RepUserInfoViewId> GetUserInfo_By_Select_All(int pageNum,int numPerPage,String orderField,String orderDirection ,
			String userName,String userSex,int educationDictNo,String userIntention,String jobIntentionDictType,String userSkill,String userAddrName,int option)
	{
		List<RepUserInfoViewId> list = new ArrayList<RepUserInfoViewId>();
		list = uDao.GetUserInfo_By_Select_All(pageNum, numPerPage, orderField, orderDirection , userName,userSex,educationDictNo,userIntention,jobIntentionDictType,userSkill,userAddrName,option);
		return list;
	}
	
	public RepUserInfoViewId GetUserView_By_UserNo(int userNo){
		return uDao.GetUserView_By_UserNo(userNo);
	}
	public List<RepUserInfo> Get_All_User_By_All() {
		List<RepUserInfo> list = null;
		list = uDao.Get_All_User_By_All();
		return list;
	}
	
	public int GetTotalCount_By_All(String keyword) {
		int count=0;
		count = uDao.GetTotalCount_By_All(keyword);
		return count;
	}
	public int GetTotalCount_By_Select_All(String userName,String userSex,int educationDictNo,String userIntention,String jobIntentionDictType,String userSkill,String userAddrName,int option) {
		int count=0;
		count = uDao.GetTotalCount_By_Select_All(userName,userSex,educationDictNo,userIntention,jobIntentionDictType,userSkill,userAddrName,option);
		return count;
	}
	public RepUserInfo getuBean() {
		return uBean;
	}

	public void setuBean(RepUserInfo uBean) {
		this.uBean = uBean;
	}
	public List<RepUserInfo> getList() {
		return list;
	}
	public void setList(List<RepUserInfo> list) {
		this.list = list;
	}
	
}
