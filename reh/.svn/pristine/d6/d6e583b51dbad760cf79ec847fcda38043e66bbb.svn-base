/**   
* @Title: DictAdapter.java 
* @Package com.ree.dict 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月22日 下午9:29:19 
* @version  
*/
package com.ree.dict;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepAdminJobExpDict;

import org.apache.commons.lang3.StringEscapeUtils;

import com.ree.hibernate.RepAdminEntEconomyDict;
import com.ree.hibernate.RepAdminEntScaleDict;
import com.ree.hibernate.RepAdminEntTradeDict;
import com.ree.hibernate.RepAdminJobAgeDict;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminJobSalaryDict;
import com.ree.hibernate.RepAdminJobTypePriDict;
import com.ree.hibernate.RepAdminList;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepAdminEntScaleDict;
import com.ree.hibernate.RepAdminScoreDict;
import com.ree.hibernate.RepAdminSys;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepTrainNewsView;
import com.ree.hibernate.RepTrainNewsViewId;

/** 
 * @ClassName: DictAdapter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月22日 下午9:29:19 
 *  
 */
public class DictAdapter {
	private static DictDao dDao;
	private static List<RepAdminJobIntentionDict> intentlist = null;
	public DictAdapter(){
		super();
		if(dDao ==null)
			dDao = new DictDao();
		if(intentlist == null)
		    intentlist = GetIntentionDictDistinct();
	}
	// 删除ArrayList中重复元素，保持顺序   
	 public static List<RepAdminJobIntentionDict> removeDuplicateWithOrder(List list) {  
	    Set set = new HashSet();  
	    List<RepAdminJobIntentionDict> newList = new ArrayList<RepAdminJobIntentionDict>();
	   for (Iterator iter = list.iterator(); iter.hasNext();) {  
		   RepAdminJobIntentionDict element = (RepAdminJobIntentionDict)iter.next();  
	         if (set.add(element.getJobIntentionDictType()))  
	            newList.add(element);  
	      }   
	   // System.out.println( " remove duplicate " + list);  
	 return newList;
	 
	 }  
	/**
	 * 
	* @Title: GetntentionDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminJobIntentionDict>    返回类型 
	* @throws
	 */
	public List<RepAdminEntTradeDict> GetTradeDict(){
		return dDao.GetTradeDict();
	}
	public List<RepAdminEntEconomyDict> GetEconomyDict(){
		return dDao.GetEconomyDict();
	}
	public List<RepAdminJobAgeDict> GetAgeDict(){
		return dDao.GetAgeDict();
	}
	
	public String GetIntentionDictType_By_No(int No){
		String result = "";
		for(RepAdminJobIntentionDict r :intentlist){
			if(r.getJobIntentionDictNo()==No)
				result = r.getJobIntentionDictType();
		}
		return result;
	}
	
	public String GetIntentionDictName_By_No(int No){
		String result = "";
		for(RepAdminJobIntentionDict r :intentlist){
			if(r.getJobIntentionDictNo()==No)
				result = r.getJobIntentionDictName();
		}
		return result;
	}
	
	public RepAdminJobIntentionDict GetIntentionItem_By_No(int No){
		return (RepAdminJobIntentionDict)dDao.getBean(RepAdminJobIntentionDict.class, No);
	}
	
	public String GetIntentionStr_By_Str(String str){
	    String result = "";
	    if(str.contains(","))
	    {
		for(String s :str.split(",")){
		    result += this.GetIntentionStr_By_No(Integer.parseInt(s))+"  ";
		}
	    }
	    return result;
	}
	
	private String GetIntentionStr_By_No(int No){
	    return this.GetIntentionDictType_By_No(No)+"-" +this.GetIntentionDictName_By_No(No);
	}
	
	public List<RepAdminJobIntentionDict> GetIntentionDictDistinct(){
		intentlist = this.GetIntentionDict();
		return this.removeDuplicateWithOrder(intentlist);
	}
	public List<RepAdminJobIntentionDict> GetIntentionDict(){
		if(intentlist == null || intentlist.size()<50)
			intentlist = dDao.GetIntentionDict();
		return intentlist;
	}
	public static void RefrushIntentlist(){
		intentlist = dDao.GetIntentionDict();
	}
	public List<RepAdminEntScaleDict> GetScaleDict(){
		return dDao.GetScaleDict();
	}
	public List<RepAdminJobSalaryDict> GetSalaryDict(){
		return dDao.GetSalaryDict();
	}
	public List<RepAdminJobTypePriDict> RepAdminJobTypePriDict(){
		return dDao.GetTypePriDict();
	}
	public List<RepAdminUserEducationDict> GetEducationDict(){
		return dDao.GetEducationDict();
	}
	public List<RepAdminJobTypePriDict> GetTypePriDict(){
		return dDao.GetTypePriDict();
	}
	public List<RepAdminJobExpDict> GetExpDict(){
		return dDao.GetExpDict();
	}
	public List<RepAdminScoreDict> GetScoreDict_By_All()
	{
		List<RepAdminScoreDict> list=new ArrayList<RepAdminScoreDict>();
		list = dDao.GetScoreDict();
		return list;
	}	
	public List<RepAdminJobIntentionDict> GetIntentionDict_By_All()
	{
		List<RepAdminJobIntentionDict> list=new ArrayList<RepAdminJobIntentionDict>();
		list = dDao.GetIntentionDict();
		return list;
	}
	public List<RepAdminUserEducationDict> GeteduDict_By_All()
	{
		List<RepAdminUserEducationDict> list=new ArrayList<RepAdminUserEducationDict>();
		list = dDao.GeteduDict();
		return list;
	}
	public RepAdminSys GetSensitive_By_All()
	{
		RepAdminSys bean;
		bean = dDao.GetSensitive_By_All();
		return bean;
	}
	public int GetBanword_By_All()
	{
		int b;
		b = dDao.GetBanword_By_All();
		return b;
	}
	public int GetEntcheck_state_By_All()
	{
		int b;
		b = dDao.GetEntcheck_state_By_All();
		return b;
	}
	public int GetJobcheck_state_By_All()
	{
		int b;
		b = dDao.GetJobcheck_state_By_All();
		return b;
	}
}
