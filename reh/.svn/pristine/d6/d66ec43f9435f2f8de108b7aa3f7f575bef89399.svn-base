package com.ree.enterprise;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfo;


/**
 * 
 * <p>Title: NewsAction<／p>
 * <p>Description:处理新闻的增加，修改 <／p> 
 * @author 李丁
 * @date 2014年7月15日
 */
public class EntdelAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 输入
	 */
	private int ent_no;
	private int job_no;
	private String message;
	private int statusCode;
	private String navTabId;
	
	List<RepEntInfo> list=null;
    EntDao eDao=new EntDao();
	
	public String delent() throws IOException, ParseException
	{
			eDao.Del_ent_By_id(ent_no);
			this.setMessage("删除成功");
			this.setNavTabId("nav01");
			this.setStatusCode(200);
			return SUCCESS;
	
    }
	public String deljob() throws IOException, ParseException
	{
			eDao.Del_Job_By_id(job_no);
			this.setMessage("删除成功");
			this.setNavTabId("nav02");
			this.setStatusCode(200);
			return SUCCESS;
	
    }
	public String state(){
		
			RepEntInfo rBean=new RepEntInfo();
			rBean=eDao.GetEntItem_By_EntId(ent_no);
			/*rBean.setReserved01("1");*/
			rBean.setReserved02(1);
			message = eDao.Update_EntInfo_By_Bean(rBean);
			if(null==message)
			{
				this.setMessage("修改审核状态成功");
				this.setNavTabId("nav01");
				this.setStatusCode(200);
			}
			else
			{
				this.setMessage("修改审核状态失败\n"+message);
				this.setStatusCode(300);
			}
			return SUCCESS;
		}	
	public String restate(){
		
		RepEntInfo rBean=new RepEntInfo();
		rBean=eDao.GetEntItem_By_EntId(ent_no);
		/*rBean.setReserved01("0");*/
		rBean.setReserved02(0);
		message = eDao.Update_EntInfo_By_Bean(rBean);
		if(null==message)
		{
			this.setMessage("修改审核状态成功");
			this.setNavTabId("nav01");
			this.setStatusCode(200);
		}
		else
		{
			this.setMessage("修改审核状态失败\n"+message);
			this.setStatusCode(300);
		}
		return SUCCESS;
	}	
	public String jobstate(){
		
		RepEntJobInfo rBean=new RepEntJobInfo();
		rBean=eDao.GetJobItem_By_JobId(job_no);
		rBean.setJobState(1);
		message = eDao.Update_JobInfo_By_Bean(rBean);
		if(null==message)
		{
			this.setMessage("修改审核状态成功");
			this.setNavTabId("nav02");
			this.setStatusCode(200);
		}
		else
		{
			this.setMessage("修改审核状态失败\n"+message);
			this.setStatusCode(300);
		}
		return SUCCESS;
	}	
   public String rejobstate(){
		
		RepEntJobInfo rBean=new RepEntJobInfo();
		rBean=eDao.GetJobItem_By_JobId(job_no);
		rBean.setJobState(0);
		message = eDao.Update_JobInfo_By_Bean(rBean);
		if(null==message)
		{
			this.setMessage("修改审核状态成功");
			this.setNavTabId("nav02");
			this.setStatusCode(200);
		}
		else
		{
			this.setMessage("修改审核状态失败\n"+message);
			this.setStatusCode(300);
		}
		return SUCCESS;
	}	

	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}


	public int getEnt_no() {
		return ent_no;
	}


	public void setEnt_no(int ent_no) {
		this.ent_no = ent_no;
	}
	public int getJob_no() {
		return job_no;
	}
	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}

	
}
