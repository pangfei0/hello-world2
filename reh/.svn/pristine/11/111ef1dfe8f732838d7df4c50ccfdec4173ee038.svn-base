/**   
* @Title: FavouriteDao.java 
* @Package com.ree.favourite 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月20日 下午11:41:25 
* @version  
*/
package com.ree.favourite;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;
import com.ree.dict.DictAdapter;
import com.ree.hibernate.RepEntFavourite;
import com.ree.hibernate.RepEntFavouriteViewId;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepUserInfoViewId;

/** 
 * @ClassName: FavouriteDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月20日 下午11:41:25 
 *  
 */
public class FavouriteDao extends SessionHelper {
	private String query_statement=null;
	private SessionHelper s = new SessionHelper();
	private RepEntFavourite fBean = new RepEntFavourite();
	List<RepEntFavouriteViewId> list;
	public FavouriteDao(){
		super();
	}
	/**
	 * 
	* @Title: GetFavouriteViewList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param jobName
	* @param @return    设定文件 
	* @return List<RepEntFavouriteViewId>    返回类型 
	* @throws
	 */
	public List<RepEntFavouriteViewId> GetFavouriteViewList_By_EntNo(int EntNo,String userName,int c,int p ,String sortBy,String
			sortMethod){
	    DictAdapter da = new DictAdapter();
		query_statement = HQLScripts.GetScript("RepEntFavouriteView") + " where id.entNo = ? and id.userName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, new String[]{sortBy,sortMethod}));
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
			query.setFirstResult((c-1)*p);
			query.setMaxResults(p);
			list = query.list();
			//加入职业意向
			for(RepEntFavouriteViewId r :list){
			    r.setReserved01(da.GetIntentionStr_By_Str(r.getUserIntention()));
			}
			
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
	* @Title: CountEntJobInfoList_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param EntNo
	* @param @param userName
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountEntJobInfoList_By_All(int EntNo,String userName){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntFavouriteView where id.entNo = ? and id.userName like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, EntNo);
			query.setParameter(1, '%' + (userName==null?"":userName) + '%');
			list = query.list();
			result = (Long) query.uniqueResult();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return result;
	}
	/**
	 * 
	* @Title: CountFavouriteList_By_UserNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountFavouriteList_By_UserNo(int userNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntFavouriteView where id.userNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, userNo);
			result = (Long) query.uniqueResult();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return result;
	}
	/**
	 * 
	* @Title: CountFavouriteList_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long CountFavouriteList_By_EntNo(int entNo){
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepEntFavouriteView where id.entNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
			result = (Long) query.uniqueResult();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return result;
	}
	/**
	 * 
	* @Title: Add_Favourite_By_Bean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param fBean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Add_Favourite_By_Bean(RepEntFavourite fBean) {
		String rs = null;
		try {
			s.Save(fBean);
		} catch (Exception e) {
			rs += e.getMessage();
			e.printStackTrace();
			throw e;
		} finally {
			s.closeSession();
		}
		return rs;
	}
	public RepEntFavourite getfBean() {
		return fBean;
	}
	public void setfBean(RepEntFavourite fBean) {
		this.fBean = fBean;
	}
}
