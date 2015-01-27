/**   
* @Title: HQLScripts.java 
* @Package com.ree.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月26日 下午8:07:37 
* @version  
*/
package com.ree.common;

import java.util.HashMap;
import java.util.LinkedHashMap;

/** 
 * @ClassName: HQLScripts 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月26日 下午8:07:37 
 *  
 */
public class HQLScripts {
	//private enum type{};
	private static HashMap<String,String> scripts = new LinkedHashMap<String, String>();
	static{
		HQLScripts.init();
	}
	/**
	 * 
	* @Title: GetScript 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param key
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String GetScript(String key){
		String result = "";
		if(scripts.containsKey(key))
			result = scripts.get(key);
		return result;
	}
	/**
	 * 
	* @Title: init 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private static void init(){
		if(scripts.size()<1){
			scripts.clear();
			scripts.put("RepTrainUserView", "select new com.ree.hibernate.RepTrainUserViewId(id.trainUserNo,id.userNo,id.newsNo,id.newsTitle,id.state"
				+ ",id.submittime,id.memo,id.reserved01,id.userName"
				+ ",id.userSex,id.userPhone,id.userEmail,id.newsTrainEndtime) from com.ree.hibernate.RepTrainUserView");
			scripts.put("RepTrainNewsView", "select new com.ree.hibernate.RepTrainNewsViewId(id.newsNo"
				+ ",id.newsTitle,id.newsContent,id.newsSubmittime,id.newsOrdertime,id.newsAuthor,id.newsListNo"
				+ ",id.newsImgurl,id.newsTrainEndtime,id.reserved01,id.reserved02,id.userCount) from com.ree.hibernate.RepTrainNewsView");
			scripts.put("RepEntFavouriteView", "select new com.ree.hibernate.RepEntFavouriteViewId(id.userNo,id.userUid,id.userEmail,id.userName"
				+ ",id.userSex,id.userCert,id.userResidence,id.userAddrName,id.userAddrPos,id.educationDictName,id.userIntention"
				+ ",id.userPhone,id.userAge,id.userSkill,id.reserved01,id.reserved02,id.entName,id.entNo"
				+ ",id.favouriteName,id.favouriteType"
				+ ") from com.ree.hibernate.RepEntFavouriteView");
			scripts.put("RepEntJobUserView", "select new com.ree.hibernate.RepEntJobUserViewId(id.jobNo,id.jobName,id.jobAddrPosName,id.state"
					+ ",id.stateName,id.submittime"
				+ ",id.auditiontime,id.hiretime,id.trytime,id.dismisstime,id.membertime,id.contracttime,id.memo,id.reserved01,id.userNo,id.userName,id.userSex,id.userAge"
				+ ",id.userPhone,id.userCert,id.userEmail,id.educationDictName,id.entNo,id.entName"
				+ ") from com.ree.hibernate.RepEntJobUserView");
			scripts.put("RepEntJobInfoView", "select new com.ree.hibernate.RepEntJobInfoViewId(id.jobNo, id.jobName, id.jobSex,"
			+"id.jobTypePriDictNo, id.jobTypePriName,id.jobIntentionDictNo, id.jobIntentionDictName,id.jobIntentionDictType,id.jobSalaryNo, id.jobAddrPosNo, id.jobAddrPosName,id.jobSalaryDictName, id.jobTypePos"
			+ ",id.jobTypePosName, id.educationDictNo,"
			+"id.educationDictName, id.jobPnum, id.jobExpDictNo,id.jobExpDictName, id.jobDecribe, id.jobContactPhone,"
			+"id.jobState, id.jobStateName, id.jobStartTime,id.jobEndTime, id.jobSubmitTime, id.reserved01, id.entNo,"
			+"id.entName, id.jobAgeNo, id.ageName) from com.ree.hibernate.RepEntJobInfoView");
			scripts.put("RepUserInfoView", "select new com.ree.hibernate.RepUserInfoViewId(id.userNo"
					+ ",id.userUid,id.userEmail,id.userName,id.userSex,id.userCert,id.userResidence,id.userAddrDisNo,id.userAddrName,id.userAddrPos,id.userIntentDisNo"
					+ ",id.userEducationNo,id.educationDictName,id.userExpNo,id.jobExpDictName"
					+ ",id.userIntention,id.userPhone,id.userBynow,id.userAge"
					+ ",id.userSkill,id.userContent,id.reserved01,id.reserved02) from com.ree.hibernate.RepUserInfoView");
			scripts.put("RepEntInfoView", "select new com.ree.hibernate.RepEntInfoViewId(id.entNo"
					+ ",id.entName,id.entUid,id.entType,id.entPcode,id.entEmail,id.entContactMan,id.entContactPhone,id.entContactAddr,id.entTypeEconomyNo"
					+ ",id.entTypeEconomyName,id.entTypeTradeNo,id.entTypeTradeName"
					+ ",id.entAddrDisNo,id.communityAddr,id.entSercurityNum,id.entScaleNo,id.scaleName"
					+ ",id.entOCode,id.entCertUrlSer,id.entCertUrlO,id.entCertUrlLicence,id.entContent,id.reserved01,id.reserved02) from com.ree.hibernate.RepEntInfoView");
			
		}
	}
}
