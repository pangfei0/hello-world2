/** 
 * Project Name:rep 
 * File Name:TrainDao.java 
 * Package Name:com.rep.train.dao 
 * Date:2014年7月24日下午5:14:56 
 * 
 */  
package com.ree.train;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainNewsViewId;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.hibernate.RepUserInfo;
import com.ree.hibernate.RepUserInfoViewId;

import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;


/**
 * <p>Title: TrainDao<／p>
 * <p>Description: <／p> 
 * @author 李丁
 * @date 2014年7月24日
 */
public class TrainDao {
	private RepEntTrainUser tBean =null;
	private List<RepEntTrainUser> list = null;
	private String query_statement = null;
	private SimpleDateFormat dateformat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private SessionHelper s = new SessionHelper();

	
	public TrainDao() {
		super();
	}
	
	
	/**
	 * 
	* <p>Title: GetTrainBeans_By_All<／p>
	* <p>Description:获得完整的TrainBeans <／p>
	* <p>Return:List<TrainBean></p>
	* @param pageNum
	* @param numPerPage
	* @param orderField
	* @param orderDirection
	* @return
	 */
	public List<RepEntTrainUser> GetTrainBeans_By_All(int pageNum,
			int numPerPage, String orderField, String orderDirection,String keyword){
		List<RepEntTrainUser> data = new ArrayList<RepEntTrainUser>();
		String[] params = new String[] { orderField,orderDirection};
		query_statement = "from com.ree.hibernate.RepEntTrainUser order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
/*			query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
			query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');*/
			query.setFirstResult((pageNum - 1) * numPerPage);
			query.setMaxResults(numPerPage);
			data = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return data;
	}
	
	
	
	/*public String Del_Train_By_id(int tid){
		String rs = null;
		String[] params = new String[] { String.valueOf(tid) };
		query_statement = "delete from train where id = %s";
		try {
			rs=r.runSql(query_statement, params);

		} catch (SQLException e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			query_statement = null;
			r.connStop();
		}
		return rs;
	}


	


	public String GetSubTime_By_news_id(int news_id) {
		String time=null;
		query_statement = "select submittime from news where id=%s";
		result = r.getResult(query_statement, new String[]{String.valueOf(news_id)});
		try {
			 if(result.next()){
			
				time=String.valueOf(result.getTimestamp("submittime"));
			 }

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			result = null;
			query_statement = null;
			r.connStop();
		}
		return time;
	}


	public int Find_train_By_Bean(int user_id,int news_id) {
		int nid=0;
		query_statement = "select id from train where user_id=%s and news_id=%s";
		result = r.getResult(query_statement, new String[]{String.valueOf(user_id),String.valueOf(news_id)});
		try {
			 if(result.next()){
			
				nid=result.getInt("id");
			 }

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		} finally {
			result = null;
			query_statement = null;
			r.connStop();
		}
		return nid;
	}
*/
		public String Add_train_By_Bean(RepEntTrainUser tBean){
			String rs = null;
			try {
				s.Save(tBean);
			} catch (Exception e) {
				rs += e.getMessage();
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			} 
			finally{
				s.closeSession();
			}
			return rs;
		}
		public Object getBean(Class c,Serializable p){
			return s.getBean(c, p);
		}


		public List<RepTrainUserViewId> GetTrainBeans_By_User(int user_id) {
			List<RepTrainUserViewId> list = null;
			/*query_statement = "from com.ree.hibernate.RepTrainUserViewId where id.userNo =:userNo";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.userNo =?";
			try{
				Query query = s.getQuery(query_statement);			
				query.setParameter(0,user_id);
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
		public List<RepTrainUserViewId> GetTrainBeans_By_User(int user_id,int pageNum,
				int numPerPage, String orderField, String orderDirection , String keyword) {
			List<RepTrainUserViewId> list = new ArrayList<RepTrainUserViewId>();
			/*query_statement = "from com.ree.hibernate.RepTrainUserViewId where id.userNo =:userNo";*/
//			where newsListNo = ? and (newsTitle like ? or newsContent like ?) order by %s %s"
			//String[] params = new String[] { orderField,orderDirection};
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.userNo =?";
			try{
				Query query = s.getQuery(query_statement);		
				query.setParameter(0,user_id);
				//query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
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


		public void Del_train_By_id(int train_id) {
			try {
				s.Delete(s.getBean(RepEntTrainUser.class, train_id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			} 
			finally{
				s.closeSession();
			}
		}
		public List<RepTrainUserViewId>Get_train_user_By_id(int news_id, int user_id) {
			List<RepTrainUserViewId> list = null;
			/*query_statement = "from com.ree.hibernate.RepEntTrainUser where repUserInfo.userNo = ? and repAdminNews.newsNo= ? ";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.userNo =? and id.newsNo=?";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, user_id);
				query.setParameter(1, news_id);
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



		public boolean Check_train_by_Id(int news_id, int user_id) {
			/*query_statement = "from com.ree.hibernate.RepEntTrainUser where repUserInfo.userNo = ? and repAdminNews.newsNo= ? ";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.userNo =? and id.newsNo=?";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, user_id);
				query.setParameter(1, news_id);
				list = query.list();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
			if(list.isEmpty()){
				return false;
			}
			else{
				return true;
			}
			
		}


		public List<RepTrainUserViewId> GetUsersItems_By_News_Id(int news_id,int pageNum, int numPerPage, String orderField,String orderDirection, String keyword) {
			List<RepTrainUserViewId> list = null;
			String[] params = new String[] { orderField,orderDirection};
			/*query_statement = "from com.ree.hibernate.RepEntTrainUser where repAdminNews.newsNo = ? and repUserInfo.userName like ?  order by %s %s";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.newsNo = ? and id.userName like ? order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, news_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setFirstResult((pageNum - 1) * numPerPage);
				query.setMaxResults(numPerPage);
				list = query.list();
				for(RepTrainUserViewId r :list){
					r.setReserved01(GetUserBean_By_No(r.getUserNo()));				   
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


		private String GetUserBean_By_No(int userNo) {
			List<RepUserInfoViewId> list = null;
			RepUserInfoViewId rBean =null;
			query_statement =HQLScripts.GetScript("RepUserInfoView")+" where id.userNo = ?";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, userNo);				
				list = query.list();
				rBean = list.get(0);
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
			return rBean.getUserAddrName();
		}


		public List<RepTrainNewsViewId> GetTrainBeans_By_All(int list_id,String orderField, String orderDirection) {
			String[] params = new String[] { orderField,orderDirection};
			List<RepTrainNewsViewId> list = null;
			/*query_statement = "from com.ree.hibernate.RepTrainNewsView where id.newsListNo = ? and (id.newsTitle like ? or id.newsContent like ?) order by %s %s";*/
			query_statement = HQLScripts.GetScript("RepTrainNewsView")
				+" where id.newsListNo = ?  order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, list_id);
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


		public List<RepTrainUserViewId> GetUserBeans_By_All(int news_id,String orderField, String orderDirection) {
			String[] params = new String[] { orderField,orderDirection};
			List<RepTrainUserViewId> list = null;
			/*query_statement = "from com.ree.hibernate.RepEntTrainUser where repAdminNews.newsNo = ?  order by %s %s";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.newsNo = ?  order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, news_id);
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
		public RepAdminNews Get_TrainEndTime_By_News_Id(int news_id) {
			List<RepAdminNews> list = null;
			RepAdminNews rBean = new RepAdminNews();
			/*query_statement = "from com.ree.hibernate.RepEntTrainUser where repAdminNews.newsNo = ?  order by %s %s";*/
			query_statement = "from com.ree.hibernate.RepAdminNews where newsNo = ?";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, news_id);
				list = query.list();
				rBean = list.get(0);
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
			return rBean;
		}


		public int GetTotalCount_By_News_Id(int news_id) {
			// TODO Auto-generated method stub
			int count=0;
			/*query_statement="from com.ree.hibernate.RepEntTrainUser where repAdminNews.newsNo = ?";*/
			query_statement = HQLScripts.GetScript("RepTrainUserView")+" where id.newsNo = ?";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, news_id);
				list = query.list();
				count = list.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
			return count;
		}	
}
