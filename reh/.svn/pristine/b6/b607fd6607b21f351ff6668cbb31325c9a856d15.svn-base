/** 
 * Project Name:rep 
 * File Name:ListAdapter.java 
 * Package Name:com.rep.common 
 * Date:2014年7月16日下午1:44:44 
 * 
 */  
package com.ree.news;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

import com.ree.enterprise.EntJobDao;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepTrainNewsView;
import com.ree.hibernate.RepTrainNewsViewId;
/**
 * <p>Title: ListAdapter<／p>
 * <p>Description:List适配器 <／p> 
 * @author 李丁
 * @date 2014年7月16日
 */
public class NewsAdapter {
	/**
	 * bean
	 */
	private RepAdminNews nBean = new RepAdminNews();
	public RepAdminNews getnBean() {
		return nBean;
	}


	public void setnBean(RepAdminNews nBean) {
		this.nBean = nBean;
	}


	/**
	 * list组
	 */
	private List<RepAdminNews> list = new ArrayList<RepAdminNews>();
	public List<RepAdminNews> getList() {
		return list;
	}


	public void setList(List<RepAdminNews> list) {
		this.list = list;
	}


	/**
	 * Dao
	 */
	private NewsDao nDao = new NewsDao();
	
	/**
	 * 构造
	 */
    public NewsAdapter(){
    	
    }
    
    /**
     * 
    * @Title: GetEntJobInfoList_By_All_jobBean_Allowed 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param jobBean
    * @param @param c
    * @param @param p
    * @param @param sortBy
    * @param @param sortMethod
    * @param @return    设定文件 
    * @return List<RepEntJobInfoViewId>    返回类型 
    * @throws
     */
    public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All (String jobName,String entName,String jobAddrPosName,int c,int p ,String sortBy,String sortMethod){
    	EntJobDao eDao = new EntJobDao();
    	
		return eDao.GetEntJobInfoList_By_All(jobName,entName,jobAddrPosName, c, p, sortBy, sortMethod);
    	
    }
    public List<RepEntJobInfoViewId> GetEntJobInfoList_By_All_Allowed (String jobName,String entName,String jobAddrPosName,int c,int p ,String sortBy,String sortMethod){
    	EntJobDao eDao = new EntJobDao();
    	
		return eDao.GetEntJobInfoList_By_All_Allowed(jobName,entName,jobAddrPosName, c, p, sortBy, sortMethod);
    	
    }
	/**
	 * 
	* <p>Title: GetNewsItems_By_List_id<／p>
	* <p>Description:  <／p>
	* <p>Return:List<LinkedHashMap<String,Object>></p>
	* @param list_id list_id
	* @param pageNum 页号
	* @param numPerPage 每页条目数
	* @param orderField 排序列
	* @param orderDirection 排序规则
	* @param keywords 关键字
	* @return
	 */
	public List<RepAdminNews> GetNewsItems_By_List_id(int list_id,int pageNum,int numPerPage,
			String orderField,String orderDirection , String keyword,Boolean a,Boolean b)
	{
		list = nDao.GetNewsItems_By_List_id(list_id,pageNum,numPerPage,orderField,orderDirection ,keyword,a,b);
		return list;
	}
	public List<RepAdminNews> GetNewsItems_By_List_id(int list_id,int pageNum,int numPerPage,
			String orderField,String orderDirection , String keyword)
	{
		list = nDao.GetNewsItems_By_List_id(list_id,pageNum,numPerPage,orderField,orderDirection ,keyword);
		return list;
	}
	
	/**
	 * 
	 * @param list_id
	 * @param pageNum
	 * @param numPerPage
	 * @param orderField
	 * @param orderDirection
	 * @param keyword
	 * @param b
	 * @return
	 */
	public List<RepTrainNewsViewId> GetNewsItems_By_List_id(int list_id,int pageNum,int numPerPage,
			String orderField,String orderDirection , String keyword,Boolean b)
	{
		List<RepTrainNewsViewId> list = nDao.GetNewsItems_By_List_id(list_id,pageNum,numPerPage,orderField,orderDirection ,keyword,b);
		return list;
	}
	
	/**
	 * 
	* <p>Title: GetNewsItem_By_NewsId<／p>
	* <p>Description:通过nid获得一条新闻 <／p>
	* <p>Return:NewsBean</p>
	* @param nid
	* @return
	 */
	public RepAdminNews GetNewsItem_By_NewsId(int nid){
		nBean = (nDao.GetNewsItem_By_NewsId(nid));
		nBean.setNewsContent(StringEscapeUtils.unescapeHtml4(nBean.getNewsContent()));
		nBean.setNewsImgurl(StringEscapeUtils.unescapeHtml4(nBean.getNewsImgurl()));
		return nBean;
	}
	
	/**
	 * 
	* <p>Title: GetTotalCount_By_List_id<／p>
	* <p>Description:通过List_id返回新闻总条目数 <／p>
	* <p>Return:int</p>
	* @param list_id
	* @return
	 */
	public int GetTotalCount_By_List_id(int list_id,String keyword,Boolean a)
	{
		return  nDao.GetTotalCount_By_List_id(list_id,keyword,a);
	}
	public int GetTotalCount_By_List_id(int list_id,String keyword)
	{
		return  nDao.GetTotalCount_By_List_id(list_id,keyword);
	}
	public int GetCount_By_List_id(int list_id)
	{
		return  nDao.GetCount_By_List_id(list_id);
	}
	
	
	public int GetUserCount_By_news_id(int news_id)
	{		
		return  nDao.GetUserCount_By_news_id(news_id);
	}
}
