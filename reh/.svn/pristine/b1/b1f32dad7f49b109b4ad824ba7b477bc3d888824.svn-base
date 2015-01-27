/**   
* @Title: AdminAdapter.java 
* @Package com.ree.login 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年11月3日 下午1:17:13 
* @version  
*/
package com.ree.admin;

import java.util.List;

import com.ree.hibernate.RepAdminInfo;

/** 
 * @ClassName: AdminAdapter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年11月3日 下午1:17:13 
 *  
 */
public class AdminAdapter {
	private LoginDao lDao = new LoginDao();
	/**
	 * 
	* @Title: GetAdminList_by_AdminType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param adminType
	* @param @return    设定文件 
	* @return List<RepAdminInfo>    返回类型 
	* @throws
	 */
	public List<RepAdminInfo> GetAdminList_by_AdminType(int adminType){
		return lDao.GetAdminList_by_AdminType(adminType);
	}
	/**
	 * 
	* @Title: GetAdminBean_by_AdminNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param adminNo
	* @param @return    设定文件 
	* @return RepAdminInfo    返回类型 
	* @throws
	 */
	public RepAdminInfo GetAdminBean_by_AdminNo(int adminNo){
		return lDao.GetAdminBean_by_AdminNo(adminNo);
	}
	public RepAdminInfo GetAdminBean_by_AdminUid(String adminUid){
		return lDao.GetAdminBean_by_AdminUid(adminUid);
	}
}
