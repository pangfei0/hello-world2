/**   
* @Title: AuditionDao.java 
* @Package com.ree.favourite 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月22日 上午2:09:47 
* @version  
*/
package com.ree.favourite;

import java.util.List;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepEntAuditionUser;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUserViewId;

/** 
 * @ClassName: AuditionDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月22日 上午2:09:47 
 *  
 */
public class AuditionDao extends SessionHelper {
	private RepEntAuditionUser bean;
	private String query_statement=null;
	private SessionHelper s = new SessionHelper();
	private List<RepEntAuditionUser> list;
}
