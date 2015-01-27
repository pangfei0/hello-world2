/**   
* @Title: AuditionAction.java 
* @Package com.ree.favourite 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月29日 上午12:19:04 
* @version  
*/
package com.ree.favourite;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.enterprise.EntJobDao;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserId;
import com.ree.hibernate.RepEntJobUserViewId;

/** 
 * @ClassName: AuditionAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月29日 上午12:19:04 
 *  
 */
public class AuditionAction extends ActionSupport {
	/**
	 * 输入
	 */
	private RepEntJobUserViewId jobbean = new RepEntJobUserViewId();
	
	/**
	 * 输出
	 */
	private String sc;
	
	private EntJobDao eDao = new EntJobDao();
	/**
	 * 
	* @Title: stateChange 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String stateChange(){
		RepEntJobUser bean;
		if(jobbean.getUserNo()!=0&&jobbean.getJobNo()!=0){
			try{
				RepEntJobUserId id = new RepEntJobUserId();
				id.setJobNo(jobbean.getJobNo());
				id.setUserNo(jobbean.getUserNo());
				bean = (RepEntJobUser)eDao.getBean(RepEntJobUser.class, id);
				if(bean!=null&&jobbean.getHiretime()!=null){
					//试用，state -->4
					bean.setState(3);
					bean.setHiretime(jobbean.getHiretime());
				}
				if(bean!=null&&jobbean.getTrytime()!=null){
					//试用，state -->4
					bean.setState(4);
					bean.setTrytime(jobbean.getTrytime());
				}
				if(bean!=null&&jobbean.getMembertime()!=null){
					//转正，state -->5
					bean.setState(5);
					bean.setMembertime(jobbean.getMembertime());
				}
				if(bean!=null&&jobbean.getContracttime()!=null){
					//签订合同，state -->6
					bean.setState(6);
					bean.setContracttime(jobbean.getContracttime());
				}
				eDao.Update(bean);
				sc = "修改成功";
			}
			catch (Exception e){
				sc = "修改失败:" + e.getMessage()==null?e.getClass().getCanonicalName():e.getMessage();
			}
		}
		return SUCCESS;
	}

	public RepEntJobUserViewId getJobbean() {
		return jobbean;
	}

	public void setJobbean(RepEntJobUserViewId jobbean) {
		this.jobbean = jobbean;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

}
