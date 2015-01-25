/**
 * 
 */
package com.reh.newsinfo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepTrainNewsView;
import com.ree.hibernate.RepTrainNewsViewId;

/**
 * 
 * <p>
 * Title: NewsDao<／p>
 * <p>
 * Description: News数据访问层<／p>
 * 
 * @author 李丁
 * @date 2014年7月17日
 */
public class NewsDao extends SessionHelper {
	private RepAdminNews nBean = null;
	private List<RepAdminNews> list = null;
	private String query_statement = null;
	private SimpleDateFormat dateformat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private SessionHelper s = new SessionHelper();

	public NewsDao() {
		super();
	}
	/**
	 * 
	 * <p>
	 * Title: GetNewsItems_By_List_id<／p>
	 * <p>
	 * Description:新闻翻页 <／p>
	 * <p>
	 * Return:List<LinkedHashMap<String,Object>>
	 * </p>
	 * 
	 * @param list_id
	 *            list_id
	 * @param pageNum
	 *            页号
	 * @param numPerPage
	 *            每页条目数
	 * @param orderField
	 *            排序列
	 * @param orderDirection
	 *            排序规则
	 * @return
	 */
	public List<RepAdminNews> GetNewsItems_By_List_id(int list_id, int pageNum,
			int numPerPage, String orderField, String orderDirection , String keyword,Boolean a,Boolean b) {
		int admin_type =  (int) ActionContext.getContext().getSession().get("admin_type");
		String author = null;
		author = (String) ActionContext.getContext().getSession().get("admin_uid");
		if(author==null){
			author="";
		}
		String[] params = new String[] { orderField,orderDirection};
		if(admin_type==0){
		query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?) order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, list_id);
			query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
			query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
	}else{
			query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?) and newsAuthor like ? order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, list_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
				/*query.setParameter(3, '%' + admin_type!=0?(author==null?"":author):"" + '%'); */
				query.setParameter(3, '%' + (author==null?"":author) + '%'); 
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
		}		
		return list;
	}
	public List<RepAdminNews> GetNewsItems_By_List_id(int list_id, int pageNum,
			int numPerPage, String orderField, String orderDirection , String keyword) {

			String[] params = new String[] { orderField,orderDirection};
			query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?) order by %s %s";
			try{
				Query query = s.getQuery(String.format(query_statement, params));
				query.setParameter(0, list_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
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
	/**
	 * 
	* @Title: Count_By_ListNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param list_id
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long Count_By_ListNo(int list_id) {
		Long result;
		query_statement = "select count(*) from com.ree.hibernate.RepAdminNews where newsListNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, list_id);
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
	public List<RepTrainNewsViewId> GetNewsItems_By_List_id(int list_id, int pageNum,
			int numPerPage, String orderField, String orderDirection , String keyword,Boolean b) {
		String[] params = new String[] { orderField,orderDirection};
		List<RepTrainNewsViewId> list = null;
		/*query_statement = "from com.ree.hibernate.RepTrainNewsView where id.newsListNo = ? and (id.newsTitle like ? or id.newsContent like ?) order by %s %s";*/
		query_statement = HQLScripts.GetScript("RepTrainNewsView")
				+" where id.newsListNo = ? and (id.newsTitle like ? or id.newsContent like ?) order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, list_id);
			query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
			query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
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
	
	/**
	 * 
	* <p>Title: GetNewsItems_By_Title_or_Content<／p>
	* <p>Description:通过title或者content查找新闻 <／p>
	* <p>Return:List<NewsBean></p>
	* @param title
	* @param content
	* @param pageNum
	* @param numPerPage
	* @param orderField
	* @param orderDirection
	* @return
	 */
	public List<RepAdminNews> GetNewsItems_By_Title_or_Content(String title,String content, int pageNum,
			int numPerPage, String orderField, String orderDirection) {
		String[] params = new String[] { orderField,orderDirection };
		query_statement = "from com.ree.hibernate.RepAdminNews where newsTitle like ? or newsContent like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, '%' + (title==null?"":title) + '%');
			query.setParameter(1, '%' + (content==null?"":content) + '%');
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
	
	

	/**
	 * 
	 * <p>
	 * Title: GetTotalCount_By_List_id<／p>
	 * <p>
	 * Description:通过List_id返回新闻总条目数 <／p>
	 * <p>
	 * Return:int
	 * </p>
	 * 
	 * @param list_id
	 * @return
	 * @throws SQLException
	 */
	public int GetTotalCount_By_List_id(int list_id,String keyword,Boolean a) {
		int count = 0;
		int admin_type =  (int) ActionContext.getContext().getSession().get("admin_type");
		String author = null;
		author = (String) ActionContext.getContext().getSession().get("admin_uid");
		if(author==null){
			author="";
		}
		if(admin_type==0){
			query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?)";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, list_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
				list = query.list();
				count = list.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}else{
			query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?) and newsAuthor like ? ";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, list_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
				/*query.setParameter(3, '%' + admin_type!=0?(author==null?"":author):"" + '%');*/
				query.setParameter(3, '%' + (author==null?"":author) + '%');
				list = query.list();
				count = list.size();
			}
			catch(HibernateException e){
				throw new RuntimeException(e);
			}
			finally{
				s.closeSession();
			}
		}		
		return count;
	}
	public int GetTotalCount_By_List_id(int list_id,String keyword) {
		int count = 0;
			query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ? and (newsTitle like ? or newsContent like ?)";
			try{
				Query query = s.getQuery(query_statement);
				query.setParameter(0, list_id);
				query.setParameter(1, '%' + (keyword==null?"":keyword) + '%');
				query.setParameter(2, '%' + (keyword==null?"":keyword) + '%');
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
	public int GetCount_By_List_id(int list_id) {
		int count = 0;
		query_statement = "from com.ree.hibernate.RepAdminNews where newsListNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, list_id);
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
	
	/**
	 * 
	* <p>Title: GetTotalCount_By_Title_or_Content<／p>
	* <p>Description:通过title或者content获得总行数 <／p>
	* <p>Return:int</p>
	* @param title
	* @param content
	* @return
	 */
	public int GetTotalCount_By_Title_or_Content(String title,String content) {
		String[] params = new String[] { title,content };
		int count = 0;
		query_statement = "from com.ree.hibernate.RepAdminNews where newsTitle like ? or newsContent like ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, '%' + (title==null?"":title) + '%');
			query.setParameter(1, '%' + (content==null?"":content) + '%');
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

	/**
	 * 
	 * <p>
	 * Title: GetNewsItem_By_NewsId<／p>
	 * <p>
	 * Description:通过nid获得一条新闻 <／p>
	 * <p>
	 * Return:NewsBean
	 * </p>
	 * 
	 * @param nid
	 * @return
	 */
	public List<RepAdminNews> GetNewsItem_By_NewsId(int nid) {
		query_statement = "from com.ree.hibernate.RepAdminNews where newsNo = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, nid);
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
	* <p>Title: Update_News_By_Bean<／p>
	* <p>Description:通过bean更新新闻 <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 */
	public String Update_News_By_Bean(RepAdminNews b){
		String rs = null;
		try {
			s.Update(b);
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
	* <p>Title: Add_News_By_Bean<／p>
	* <p>Description:通过bean增加新闻 <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 */
	public String Add_News_By_Bean(RepAdminNews b){
		String rs = null;
		try {
			s.Save(b);
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
	* <p>Title: Del_News_By_id<／p>
	* <p>Description:通过nid删除news <／p>
	* <p>Return:String</p>
	* @param nid
	* @return
	 */
	public String Del_News_By_id(int nid){
		String rs = null;
		try {
			s.Delete(s.getBean(RepAdminNews.class, nid));
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
	 * (非 Javadoc) 
	* <p>Title: getBean</p> 
	* <p>Description: </p> 
	* @param c
	* @param p
	* @return 
	* @see com.ree.common.SessionHelper#getBean(java.lang.Class, java.io.Serializable)
	 */
	public Object getBean(Class c,Serializable p){
		return s.getBean(c, p);
	}
	public int GetUserCount_By_news_id(int news_id) {
		// TODO Auto-generated method stub
		return 1;
	}
}
