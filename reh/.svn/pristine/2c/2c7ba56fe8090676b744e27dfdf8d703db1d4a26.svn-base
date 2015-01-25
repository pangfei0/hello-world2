package com.ree.community;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminCommunityInfo;
import com.ree.hibernate.RepAdminIntentAddrDict;





public class communityDao extends SessionHelper{

	private String query_statement = null;
	private List<RepAdminCommunityInfo> list = null;
	private SessionHelper s = new SessionHelper();
	private RepAdminCommunityInfo cbean;

	public communityDao() {
		// TODO Auto-generated constructor stub
		super();
	}
	public List<RepAdminIntentAddrDict> GetIntentAddr_By_All(){
		List<RepAdminIntentAddrDict> list = new ArrayList<RepAdminIntentAddrDict>();
		String query_statement = "from com.ree.hibernate.RepAdminIntentAddrDict where intentAddrNo!=0";
			Query query = s.getQuery(query_statement);
			list = query.list();
			s.closeSession();
		return list;
	}
	/**
	 * 
	* <p>Title: GetCommunities_By_father_id<／p>
	* <p>Description:通过father_id获得Communities <／p>
	* <p>Return:List<RepAdminCommunityInfo></p>
	* @param father_id
	* @return
	 */
	public List<RepAdminCommunityInfo> GetCommunities_By_father_id(int communityFatherNo){
		List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
		query_statement = "from com.ree.hibernate.RepAdminCommunityInfo where communityFatherNo =? and communityNo !=0";
		
		try {
			Query query = s.getQuery(query_statement);
			query.setParameter(0,communityFatherNo);
			list = query.list();
			
		}
		catch (HibernateException e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			
			
			s.closeSession();
		}
		return list;
	}
	/**
	 * 
	* <p>Title: GetCommunityBean_By_ALL<／p>
	* <p>Description:通过id获得CommunityBean <／p>
	* <p>Return:RepAdminCommunityInfo</p>
	* @param id
	* @return
	 */
	public int GetCommunities_By_father_All(){
		List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
		query_statement = "from com.ree.hibernate.RepAdminCommunityInfo ";
		int count = 0;
		try {
			Query query = s.getQuery(query_statement);
			list = query.list();
			count=list.size();
		}
		catch (HibernateException e) {
			System.err.println(e.getMessage());
			
		} finally {
			
			
			s.closeSession();
		}
		return count;
	}
	/**
	 * 
	* <p>Title: GetCommunityBean_By_id<／p>
	* <p>Description:通过id获得CommunityBean <／p>
	* <p>Return:RepAdminCommunityInfo</p>
	* @param id
	* @return
	 */
	public RepAdminCommunityInfo GetCommunityBean_By_id(int communityNo) throws SQLException{
		query_statement = "from com.ree.hibernate.RepAdminCommunityInfo where communityNo = ?";
	
		
		try {
			
			Query query = s.getQuery(query_statement);
			query.setParameter(0,communityNo);
			list = query.list();
			if(list.size()==1)
			{
				cbean=list.get(0);
			}
		
		} finally {
		
			s.closeSession();
		}
		return cbean;
	}
	/**
	 * 
	* <p>Title: UpdateCommunity_By_Bean<／p>
	* <p>Description:通过bean更新community <／p>
	* <p>Return:LinkedHashMap<String,Object></p>
	* @param b
	* @return
	 */
	public String  UpdateCommunity_By_Bean( RepAdminCommunityInfo b){
		
			String rs=null;
			try {
				s.Update(b);
				s.runProc_one_int_parma("{call update_community_range(?)}", b.getCommunityNo());
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
	
	
	/**
	 * 
	* <p>Title: AddCommunity_By_Bean<／p>
	* <p>Description:通过bean添加Community <／p>
	* <p>Return:LinkedHashMap<String,Object></p>
	* @param b
	* @return
	 */
	public String AddCommunity_By_Bean(RepAdminCommunityInfo b){

		String rs=null;
		try {
			s.Save(b);
			s.runProc_one_int_parma("{call update_community_range(?)}", b.getCommunityNo());
			//b.setCommunityRange(b.getCommunityRange()+b.getCommunityNo());
			//s.Update(b);
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
	
	
	/**
	 * 
	* <p>Title: DelCommunity_By_Bean<／p>
	* <p>Description:通过id删除community节点 <／p>
	* <p>Return:LinkedHashMap<String,Object></p>
	* @param father_id
	* @return
	 */
	public String DelCommunity_By_Bean(int id){
	
		String rs = null;
		try {
			s.Delete(s.getBean(RepAdminCommunityInfo.class, id));
			s.runProc_one_int_parma("{call delete_news_by_fatherid(?)}", id);
			
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
	/**
	 * 
	* <p>Title: GetCommunityBean_By_ALL<／p>
	* <p>Description:获得所有CommunityBean <／p>
	* <p>Return:List<RepAdminCommunityInfo></p>
	* @param id
	* @return
	 */
	public List<RepAdminCommunityInfo> GetCommunities_By_All(){
		List<RepAdminCommunityInfo> list = new ArrayList<RepAdminCommunityInfo>();
		query_statement = "from com.ree.hibernate.RepAdminCommunityInfo ";
		
		try {
			Query query = s.getQuery(query_statement);
			list = query.list();
			
		}
		catch (HibernateException e) {
			System.err.println(e.getMessage());
			
		} finally {
			
			
			s.closeSession();
		}
		return list;
	}
}
