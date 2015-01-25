/**   
* @Title: NewsJsonAction.java 
* @Package com.ree.news 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月23日 上午8:52:38 
* @version  
*/
package com.ree.news;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: NewsJsonAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月23日 上午8:52:38 
 *  
 */
public class NewsJsonAction extends ActionSupport {
	/**
	 * 输入
	 */
	private int listNo;
	
	/**
	 * 输出
	 */
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();
	
	private NewsDao nDao;
	
	/**
	 * 
	* @Title: Count_By_ListNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Count_By_ListNo(){
		nDao = new NewsDao();
		store.put("totalNum", nDao.Count_By_ListNo(listNo));
		return SUCCESS;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}
}
