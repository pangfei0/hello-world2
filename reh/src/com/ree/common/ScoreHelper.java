/**   
* @Title: MatchHelper.java 
* @Package com.ree.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月21日 下午3:37:43 
* @version  
*/
package com.ree.common;

import java.util.List;

import com.ree.dict.DictDao;
import com.ree.hibernate.RepAdminIntentAddrDict;
import com.ree.hibernate.RepAdminJobAgeDict;
import com.ree.hibernate.RepAdminScoreDict;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepUserInfo;

/** 
 * @ClassName: MatchHelper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月21日 下午3:37:43 
 *  
 */
public class ScoreHelper {
	private static DictDao sDao = new DictDao();
	public static List<RepAdminScoreDict> sDicts;
	public static List<RepAdminUserEducationDict> eduDicts;
	public static List<RepAdminJobAgeDict> ageDicts;
	public ScoreHelper(){
		super();
		sDicts = sDao.GetScoreDict();
		eduDicts = sDao.GetEducationDict();
		ageDicts = sDao.GetAgeDict();
	}
	/**
	 * 
	* @Title: GetEducationLevel_By_EducationNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param educationNo
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	private static Integer GetEducationLevel_By_EducationNo(Integer educationNo){
		Integer result = 0;
		if(eduDicts!=null&&educationNo!=0){
			for(RepAdminUserEducationDict r : eduDicts){
				if(r.getEducationDictNo()==educationNo){
					//result = r.getEducationDictLevel();
					result = r.getEducationDictNo();
					break;
				}	
			}
		}
		return result;
	}
	/**
	 * 
	* @Title: GetAge_By_AgeNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ageNo
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	private static Integer GetAge_By_AgeNo(Integer ageNo){
		Integer result = 0;
		if(ageDicts!=null&&ageNo!=0){
			for(RepAdminJobAgeDict r : ageDicts){
				if(r.getAgeNo()==ageNo)
				{
					result = Integer.parseInt(r.getAgeName());
					break;
				}
			}
		}
		return result;
	}
	/**
	 * 
	* @Title: GetJobScore_By_UserBean_And_JobInfoList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uBean
	* @param @param r
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public static int GetJobScore_By_UserBean_And_JobInfoList(RepUserInfo uBean,RepEntJobInfoViewId r){
		if(null==sDicts)
			sDicts = sDao.GetScoreDict();
		if(null==eduDicts)
			eduDicts = sDao.GetEducationDict();
		if(null==ageDicts)
			ageDicts = sDao.GetAgeDict();
		Integer score = 0,total = 0;
		for(RepAdminScoreDict sDict:sDicts){
			total +=sDict.getRuleScore();
			switch(sDict.getRuleName()){
			case "USER_INTENTION"://意向匹配-首要,如果意向不满足直接过滤
				if(uBean.getUserIntention().contains(String.valueOf(r.getJobIntentionDictNo())))
					score+=sDict.getRuleScore();
				break;
			case "USER_EDUCATION_LEVEL"://教育程度-次要,权重匹配(从小到大)
				if((uBean.getUserEducationNo())>=
						(r.getEducationDictNo()))
					score+=sDict.getRuleScore();
				break;
			case "USER_EXP_LEVLE"://工作经验-次要,权重匹配(从小到大)
				if(uBean.getUserExpNo()>=(r.getJobExpDictNo()))
					score+=sDict.getRuleScore();
				break;
			case "USER_AGE_LEVEL"://年龄要求-次要,权重匹配(从小到大)
				if(uBean.getUserAge()>=GetAge_By_AgeNo(r.getJobAgeNo()))
					score+=sDict.getRuleScore();
				break;
			case "USER_SEX"://性别-次要,不限-得分,其他-全匹配
				if(r.getJobSex().contains(uBean.getUserSex()))
					score+=sDict.getRuleScore();
				break;
			case "USER_INTENTION_ADDR"://用户意向求职地址-次要,全匹配
				if(uBean.getUserIntentDisNo().contains(r.getJobAddrPosNo()))
					score+=sDict.getRuleScore();
				break;
			default:break;
			}
		}
		return (int)((score.doubleValue()/total.doubleValue())*100);
	}
}
