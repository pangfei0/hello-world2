/**   
* @Title: ListDao.java 
* @Package com.ree.list 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月23日 上午8:07:25 
* @version  
*/
package com.ree.list;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminScoreDict;

/** 
 * @ClassName: ListDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月23日 上午8:07:25 
 *  
 */
public class ListDao {
	private RepAdminList lBean;
	private SessionHelper s = new SessionHelper();
	private String query_statement=null;
	private List<RepAdminList> list;
	
	/**
	 * 
	* @Title: GetList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminList>    返回类型 
	* @throws
	 */
	public List<RepAdminList> GetList_By_All(){
		query_statement = "from com.ree.hibernate.RepAdminList";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}
	/**
	 * 
	* @Title: GetList_By_FatherNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param listFatherNo
	* @param @return    设定文件 
	* @return List<RepAdminList>    返回类型 
	* @throws
	 */
	public List<RepAdminList> GetList_By_FatherNo(int listFatherNo){
		query_statement = "from com.ree.hibernate.RepAdminList where listFatherNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, listFatherNo);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}
}
