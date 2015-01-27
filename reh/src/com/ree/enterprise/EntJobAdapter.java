/**   
* @Title: EntJobAdapter.java 
* @Package com.ree.enterprise 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月26日 下午2:44:07 
* @version  
*/
package com.ree.enterprise;

import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoView;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepEntJobInfoViewId;

/** 
 * @ClassName: EntJobAdapter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月26日 下午2:44:07 
 *  
 */
public class EntJobAdapter {
	private EntJobDao jDao = new EntJobDao();
	private EntDao entDao = new EntDao();
	private RepEntJobInfoViewId jobBean = new RepEntJobInfoViewId();
	public RepEntJobInfoViewId GetJobInfoView_By_jobNo(int jobNo){
		jobBean = jDao.GetEntJobInfo_By_jobNo(jobNo);
		return jobBean;
	}
	public RepEntInfoViewId GetEntInfo_By_entNo(int entNo){
		return (RepEntInfoViewId)entDao.GetEntInfoView_By_entNo(entNo);
	}
}
