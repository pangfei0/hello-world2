/**   
* @Title: ScoreDao.java 
* @Package com.ree.dict 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Administrator - 李丁
* @date 2014年10月21日 下午3:39:00 
* @version  
*/
package com.ree.dict;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.ree.common.SessionHelper;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepAdminEntEconomyDict;
import com.ree.hibernate.RepAdminEntScaleDict;
import com.ree.hibernate.RepAdminEntTradeDict;
import com.ree.hibernate.RepAdminJobAgeDict;
import com.ree.hibernate.RepAdminJobExpDict;
import com.ree.hibernate.RepAdminJobIntentionDict;
import com.ree.hibernate.RepAdminJobSalaryDict;
import com.ree.hibernate.RepAdminJobTypePriDict;
import com.ree.hibernate.RepAdminEntScaleDict;
import com.ree.hibernate.RepAdminScoreDict;
import com.ree.hibernate.RepAdminSys;
import com.ree.hibernate.RepAdminUserEducationDict;
import com.ree.hibernate.RepEntJobInfoViewId;

/** 
 * @ClassName: ScoreDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator - 李丁
 * @date 2014年10月21日 下午3:39:00 
 *  
 */
public class DictDao extends SessionHelper {
	private RepAdminScoreDict sBean;
	private SessionHelper s = new SessionHelper();
	private String query_statement=null;
	private List<RepAdminScoreDict> list;
	
	/**
	 * 
	* @Title: GetSysDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminSys>    返回类型 
	* @throws
	 */
	public List<RepAdminSys> GetSysDict(){
		List<RepAdminSys> list;
		query_statement = "from com.ree.hibernate.RepAdminSys";
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: GetAgeDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminJobAgeDict>    返回类型 
	* @throws
	 */
	public List<RepAdminEntTradeDict> GetTradeDict(){
		List<RepAdminEntTradeDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntTradeDict";
		try{
			Query query = s.getQuery(query_statement);
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
	
	public List<RepAdminEntEconomyDict> GetEconomyDict(){
		List<RepAdminEntEconomyDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntEconomyDict";
		try{
			Query query = s.getQuery(query_statement);
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
	
	public List<RepAdminJobAgeDict> GetAgeDict(){
		List<RepAdminJobAgeDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobAgeDict";
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: GetScoreDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminScoreDict>    返回类型 
	* @throws
	 */
	public List<RepAdminScoreDict> GetScoreDict(){
		query_statement = "from com.ree.hibernate.RepAdminScoreDict";
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: AddScoreDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rbean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String AddScoreDict(RepAdminScoreDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	/**
	 * 
	* @Title: AddeduDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rbean
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String AddeduDict(RepAdminUserEducationDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String AddJobAgeDict(RepAdminJobAgeDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String AddJobExpDict(RepAdminJobExpDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String JobSalaryAddDict(RepAdminJobSalaryDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String JobTypePriAddDict(RepAdminJobTypePriDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String ScaleAddDict(RepAdminEntScaleDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String EntTradeAddDict(RepAdminEntTradeDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	public String EntEconomyAddDict(RepAdminEntEconomyDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}
	/**
	 * 
	* @Title: DelScoreDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ruleid    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void DelScoreDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminScoreDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	/**
	 * 
	* @Title: DeleduDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ruleid    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void DeleduDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminUserEducationDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	/**
	 * 
	* @Title: GetScoreDict_By_ruleNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param alterNo
	* @param @return    设定文件 
	* @return List<RepAdminScoreDict>    返回类型 
	* @throws
	 */
/*	public List<RepAdminScoreDict> GetScoreDict_By_ruleNo(int alterNo) {
		query_statement = "from com.ree.hibernate.RepAdminScoreDict where ruleNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return list;
	}*/
	public RepAdminScoreDict GetScoreDict_By_ruleNo(int alterNo) {
		RepAdminScoreDict sBean=null;
		query_statement = "from com.ree.hibernate.RepAdminScoreDict where ruleNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminJobAgeDict GetJobAgeDict_By_No(int alterNo) {
		RepAdminJobAgeDict sBean=null;
		List<RepAdminJobAgeDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobAgeDict where ageNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminJobSalaryDict GetJobSalaryDict_By_No(int alterNo) {
		RepAdminJobSalaryDict sBean=null;
		List<RepAdminJobSalaryDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobSalaryDict where jobSalaryDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminJobExpDict GetJobExpDict_By_No(int alterNo) {
		RepAdminJobExpDict sBean=null;
		List<RepAdminJobExpDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobExpDict where jobExpDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminJobTypePriDict GetJobTypePriDict_By_No(int alterNo) {
		RepAdminJobTypePriDict sBean=null;
		List<RepAdminJobTypePriDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobTypePriDict where jobTypePriDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminEntScaleDict GetScaleDict_By_No(int alterNo) {
		RepAdminEntScaleDict sBean=null;
		List<RepAdminEntScaleDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntScaleDict where scaleNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminEntTradeDict GetEntTradeDict_By_No(int alterNo) {
		RepAdminEntTradeDict sBean=null;
		List<RepAdminEntTradeDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntTradeDict where tradeNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}
	public RepAdminEntEconomyDict GetEntEconomyDict_By_No(int alterNo) {
		RepAdminEntEconomyDict sBean=null;
		List<RepAdminEntEconomyDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntEconomyDict where economyNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}


	/**
	 * 
	* @Title: UpdateScoreDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param rbean    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void UpdateScoreDict(RepAdminScoreDict rbean) {
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public List<RepAdminEntScaleDict> GetScaleDict() {
		List<RepAdminEntScaleDict> list;
		query_statement = "from com.ree.hibernate.RepAdminEntScaleDict";
		try{
			Query query = s.getQuery(query_statement);
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
	public List<RepAdminJobIntentionDict> GetIntentionDict() {
		List<RepAdminJobIntentionDict> list;
		query_statement = "from com.ree.hibernate.RepAdminJobIntentionDict";
		try{
			Query query = s.getQuery(query_statement);
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
	public String JobAddScoreDict(RepAdminJobIntentionDict rbean) {
		String rs = null;
		try {
			s.Save(rbean);
		} catch (Exception e) {
			rs += e.getMessage();
			// TODO Auto-generated catch block
		} 
		finally{
			s.closeSession();
		}
		return rs;
	}

	public void JobDelScoreDict(int jobintid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminJobIntentionDict.class, jobintid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void JobAgeDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminJobAgeDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void JobExpDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminJobExpDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void JobSalaryDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminJobSalaryDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void JobTypePriDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminJobTypePriDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void ScaleDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminEntScaleDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void EntTradeDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminEntTradeDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}
	public void EntEconomyDelDict(int ruleid) {
		// TODO Auto-generated method stub
		try {
			s.Delete(s.getBean(RepAdminEntEconomyDict.class, ruleid));
		} catch (Exception e) {
			e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
	}

	public RepAdminJobIntentionDict GetJobIntDict_By_No(int alterNo) {
		List<RepAdminJobIntentionDict> list;
		RepAdminJobIntentionDict jBean=null;
		query_statement = "from com.ree.hibernate.RepAdminJobIntentionDict where jobIntentionDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			jBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return jBean;
	}
	/**
	 * 
	* @Title: GetSalaryDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminJobSalaryDict>    返回类型 
	* @throws
	 */
	public List<RepAdminJobSalaryDict> GetSalaryDict(){
		query_statement = "from com.ree.hibernate.RepAdminJobSalaryDict";
		List<RepAdminJobSalaryDict> list;
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: GetTypePriDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminJobTypePriDict>    返回类型 
	* @throws
	 */
	public List<RepAdminJobTypePriDict> GetTypePriDict(){
		query_statement = "from com.ree.hibernate.RepAdminJobTypePriDict";
		List<RepAdminJobTypePriDict> list;
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: GetEducationDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminEducationDict>    返回类型 
	* @throws
	 */
	public List<RepAdminUserEducationDict> GetEducationDict(){
		query_statement = "from com.ree.hibernate.RepAdminUserEducationDict";
		List<RepAdminUserEducationDict> list;
		try{
			Query query = s.getQuery(query_statement);
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
	* @Title: GetExpDict 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<RepAdminJobExpDict>    返回类型 
	* @throws
	 */
	public List<RepAdminJobExpDict> GetExpDict(){
		query_statement = "from com.ree.hibernate.RepAdminJobExpDict";
		List<RepAdminJobExpDict> list;
		try{
			Query query = s.getQuery(query_statement);
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
	public List<RepAdminUserEducationDict> GeteduDict() {
		List<RepAdminUserEducationDict> list;
		query_statement = "from com.ree.hibernate.RepAdminUserEducationDict";
		try{
			Query query = s.getQuery(query_statement);
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
	public RepAdminUserEducationDict GeteduDict_By_ruleNo(int alterNo) {
		List<RepAdminUserEducationDict> list;
		RepAdminUserEducationDict eBean=null;
		query_statement = "from com.ree.hibernate.RepAdminUserEducationDict where educationDictNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, alterNo);
			list = query.list();
			eBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return eBean;
	}
	public RepAdminSys GetSensitive_By_All() {
		List<RepAdminSys> list;
		RepAdminSys eBean=null;
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo=1";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
			eBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return eBean;
	}
	public int GetBanword_By_All() {
		List<RepAdminSys> list;
		int b = 0;
		RepAdminSys eBean=null;
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo=1";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
			eBean=list.get(0);
			b=eBean.getSysState();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return b;
	}
	public int GetEntcheck_state_By_All() {
		List<RepAdminSys> list;
		int b = 0;
		RepAdminSys eBean=null;
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo=2";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
			eBean=list.get(0);
			b=eBean.getSysState();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return b;
	}
	public int GetJobcheck_state_By_All() {
		List<RepAdminSys> list;
		int b = 0;
		RepAdminSys eBean=null;
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo=3";
		try{
			Query query = s.getQuery(query_statement);
			list = query.list();
			eBean=list.get(0);
			b=eBean.getSysState();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return b;
	}
	public void UpdateJobIntDict(RepAdminJobIntentionDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateeduDict(RepAdminUserEducationDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateAgeJobDict(RepAdminJobAgeDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateAgeExpDict(RepAdminJobExpDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateJobSalaryDict(RepAdminJobSalaryDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateJobTypePriDict(RepAdminJobTypePriDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateScaleDict(RepAdminEntScaleDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateEntTradeDict(RepAdminEntTradeDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateEntEconomyDict(RepAdminEntEconomyDict rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}
	public void UpdateBanWord(RepAdminSys rbean) {
		// TODO Auto-generated method stub
		try {
			s.Update(rbean);
		} catch (Exception e) {
		} 
		finally{
			s.closeSession();
		}
	}

	public RepAdminSys GetBanwordCheck_By_Id(int i) {
		RepAdminSys sBean=null;
		List<RepAdminSys> list;
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo=?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, i);
			list = query.list();
			sBean=list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return sBean;
	}

	public int GetState_By_No(int num) {
		query_statement = "from com.ree.hibernate.RepAdminSys where sysNo = ?";
		Query query = s.getQuery(query_statement);
		query.setParameter(0, num);
		List<RepAdminSys> sysbean = (List<RepAdminSys>) query.list();
		int m=sysbean.get(0).getSysState();
		s.closeSession();
		return m;
	}
}
