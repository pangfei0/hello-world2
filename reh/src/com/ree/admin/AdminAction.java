/**   
 * @Title: AdminAction.java 
 * @Package com.ree.admin 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator - 李丁
 * @date 2014年11月3日 下午2:19:47 
 * @version  
 */
package com.ree.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.hibernate.RepAdminInfo;

/**
 * @ClassName: AdminAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2014年11月3日 下午2:19:47
 * 
 */
public class AdminAction extends ActionSupport {
	/**
	 * 输入
	 */
	private RepAdminInfo adminbean = null;

	/**
	 * 输出
	 */
	private String message;
	private int statusCode;
	private String navTabId;

	private AdminDao aDao = new AdminDao();

	/**
	 * 
	 * @Title: AlterAdmin
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String AlterAdmin() {
		// 修改
		try {
			RepAdminInfo oldbean = (RepAdminInfo)aDao.getBean(RepAdminInfo.class, adminbean.getAdminNo());
			adminbean.setAdminPwd((adminbean.getAdminPwd()==null||"".equals(adminbean.getAdminPwd()))
					?oldbean.getAdminPwd()
					:DBHelper.MD5(adminbean.getAdminPwd()));
			adminbean.setAdminType(oldbean.getAdminType());
			aDao.Update(adminbean);
			this.setMessage("修改成功");
			this.setStatusCode(200);
			this.setNavTabId("nav10");//刷新
		} catch (Exception e) {
			this.setMessage("错误的操作\n" + DBHelper.GetMsg(e));
			this.setStatusCode(300);
		}
		return SUCCESS;
	}
	/**
	 * 
	* @Title: DelAdmin 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String DelAdmin(){
		// 删除
		try {
			RepAdminInfo oldbean = (RepAdminInfo)aDao.getBean(RepAdminInfo.class, adminbean.getAdminNo());
			if(oldbean.getAdminType()==0||oldbean.getAdminNo()==null||oldbean.getAdminNo()==0)
				throw new Exception("非法操作");
			aDao.Delete(adminbean);
			this.setMessage("修改成功");
			this.setStatusCode(200);
			this.setNavTabId("nav10");//刷新
		} catch (Exception e) {
			this.setMessage("错误的操作\n" + DBHelper.GetMsg(e));
			this.setStatusCode(300);
		}
		return SUCCESS;
	}

	/**
	 * 
	* @Title: AddAdmin 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String AddAdmin() {
		// 添加
		try {
			adminbean.setAdminPwd(DBHelper.MD5(adminbean.getAdminPwd()));
			adminbean.setAdminType(1);
			aDao.Save(adminbean);
			this.setMessage("添加成功");
			this.setStatusCode(200);
			this.setNavTabId("nav10");//刷新
		} catch (Exception e) {
			this.setMessage("错误的操作\n" + DBHelper.GetMsg(e));
			this.setStatusCode(300);
		}
		return SUCCESS;
	}

	public RepAdminInfo getAdminbean() {
		return adminbean;
	}

	public void setAdminbean(RepAdminInfo adminbean) {
		this.adminbean = adminbean;
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

}
