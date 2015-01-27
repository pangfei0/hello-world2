/**   
* @Title: ListAdapter.java 
* @Package com.ree.list 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月23日 上午8:10:55 
* @version  
*/
package com.ree.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminScoreDict;

/** 
 * @ClassName: ListAdapter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月23日 上午8:10:55 
 *  
 */
public class ListAdapter {
	private static ListDao lDao;
	private static List<RepAdminList> list;
	public ListAdapter(){
		if(lDao ==null)
			lDao = new ListDao();
		if(list==null)
			list = this.GetList_By_All();
	}
	private List<RepAdminList> GetList_By_All(){
		return lDao.GetList_By_All();
	}
	public List<RepAdminList> ReturnList(){
		return list;
	}
	public List<RepAdminList> GetList_By_FatherNo(int listFatherNo){
		
		return lDao.GetList_By_FatherNo(listFatherNo);
	}
	public String GetListName_By_ListNo(int listNo){
		String result = "";
		if(list!=null){
//			for(RepAdminList l :list){
//				list.listIterator()
//			}
			//toHashMap
			Iterator<RepAdminList> it = list.iterator();
			while(it.hasNext()){
				RepAdminList i = (RepAdminList)it.next();
				if(listNo == i.getListNo())
				{
					result = i.getListName();
					break;
				}
			}
		}
		return result;
	}
	/**
	 * 
	* @Title: ReturnList_By_FatherNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param listFatherNo
	* @param @return    设定文件 
	* @return List<RepAdminList>    返回类型 
	* @throws
	 */
	public List<RepAdminList> ReturnList_By_FatherNo(int listFatherNo){
		ArrayList<RepAdminList> result = new ArrayList<>();
		if(list!=null){
			for(RepAdminList l :list){
				if(l.getListFatherNo()==listFatherNo)
					result.add(l);
			}
		}
		return result;
	}
	/**
	 * 
	* @Title: ReturnList_By_ListType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param listType
	* @param @return    设定文件 
	* @return List<RepAdminList>    返回类型 
	* @throws
	 */
	public List<RepAdminList> ReturnList_By_ListType(int listType){
		ArrayList<RepAdminList> result = new ArrayList<>();
		if(list!=null){
			for(RepAdminList l :list){
				if(l.getListType()==listType)
					result.add(l);
			}
		}
		return result;
	}
}
