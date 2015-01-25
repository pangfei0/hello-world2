/**   
* @Title: DictJsonAction.java 
* @Package com.ree.dict 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月29日 下午8:04:25 
* @version  
*/
package com.ree.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminJobTypePriDict;

/** 
 * @ClassName: DictJsonAction 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月29日 下午8:04:25 
 *  
 */
public class DictJsonAction extends ActionSupport {
	private DictDao dDao = new DictDao();
	
	/**
	 * 输入
	 */
	private String typeName = null;
	
	/**
	 * 输出
	 */
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();
	/**
	 * 
	* @Title: GetIntentionDict_By_Type 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param type
	* @param @return    设定文件 
	* @return List<RepAdminJobIntentionDict>    返回类型 
	* @throws
	 */
	private List<RepAdminJobIntentionDict> GetIntentionDict_By_Type(String type){
		DictAdapter da = new DictAdapter();
		List<RepAdminJobIntentionDict> res = da.GetIntentionDict();
		//List<RepAdminJobIntentionDict> res = dDao.GetIntentionDict();
		List<RepAdminJobIntentionDict> result = new ArrayList<RepAdminJobIntentionDict>();
		//intentlist=this.GetIntentionDict();
		if(res!=null){
			Iterator<RepAdminJobIntentionDict> it = res.iterator();
			while(it.hasNext()){
				RepAdminJobIntentionDict i = (RepAdminJobIntentionDict)it.next();
				if(type.equals(i.getJobIntentionDictType()))
				{
					result.add(i);
					//break;
				}
			}
		}
		return result;
	}
	/**
	 * 
	* @Title: GetJobTypeDict_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String GetJobTypeDict_By_All(){
	    DictDao dd = new DictDao();
	    store.put("data", dd.GetTypePriDict());
	    return SUCCESS;
	}
	/**
	 * 
	* @Title: GetIntentionDict_By_Type 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String GetIntentionDict_By_Type(){
		if(typeName!=null){
			store.put("data", this.GetIntentionDict_By_Type(typeName));
		}
		return SUCCESS;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}


}
