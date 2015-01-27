/**
 * 
 */
package com.ree.enterprise;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.ree.common.HQLScripts;
import com.ree.common.SessionHelper;
import com.ree.favourite.FavouriteDao;
import com.ree.hibernate.RepAdminNews;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntInfoViewId;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntTrainUser;
import com.ree.hibernate.RepTrainUserViewId;
import com.ree.user.UserMsgBoxBean;

/**
 * <p>
 * Title: EntApplyDao
 * </p>
 * Description: News数据访问层<／p>
 * 
 * @author 贾灿灿
 * @date 2014年10月7日
 *
 */
public class EntDao extends SessionHelper {

	private RepEntInfo eBean = null;
	private SessionHelper s = new SessionHelper();
	
	private String query_statement=null;
	private List<RepEntInfo> list = null;

	public EntDao() {
		super();
	}
	/**
	 * 
	* @Title: GetEntInfoView_By_entNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return RepEntInfoViewId    返回类型 
	* @throws
	 */
	public RepEntInfoViewId GetEntInfoView_By_entNo(int entNo){
		RepEntInfoViewId bean = null;
		List<RepEntInfoViewId> list = null ;
		query_statement = HQLScripts.GetScript("RepEntInfoView")+" where id.entNo = ?";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entNo);
			list = query.list();
			if(list.size()>0)
				bean = list.get(0);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return bean;
	}
	/**
	 * 
	* @Title: GetBoxBean_By_EntNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param entNo
	* @param @return    设定文件 
	* @return EntMsgBoxBean    返回类型 
	* @throws
	 */
	public EntMsgBoxBean GetBoxBean_By_EntNo(int entNo){
		EntMsgBoxBean bean = new EntMsgBoxBean();
		EntJobDao jDao = new EntJobDao();
		FavouriteDao fDao = new FavouriteDao();
		Long recruitNum,isFavourite;
		String lastTime = "";
		try{
			//recruitNum = jDao.CountEntJobUserList_By_EntNo(entNo);
		    	recruitNum = jDao.CountEntJobUserList_By_EntNo_isNotSelf(entNo,false);
			isFavourite = fDao.CountFavouriteList_By_EntNo(entNo);
			
			RepEntInfo eBean = (RepEntInfo)jDao.getBean(RepEntInfo.class, entNo);
			if(eBean!=null)
			    lastTime = eBean.getReserved01();
			bean.setIsFavourite(isFavourite);
			bean.setRecruitNum(recruitNum);
			bean.setLastTime(lastTime);
		}
		catch(Exception e){
			throw  e;
		}
		finally{
			s.closeSession();
		}
		return bean;
	}
	/**
	 * 
	* <p>Title: Add_EntInfo_By_Bean<／p>
	* <p>Description:通过bean增加企业信息 <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 */
	public String Add_EntInfo_By_Bean(RepEntInfo b){
		String rs = null;
		if(CheckName(b.getEntName())!=0){
			return "已存在企业名";
		}
		if(CheckMail(b.getEntEmail())!=0){
			return "该邮箱已被注册";
		}
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
		
	private int CheckMail(String entEmail) {
		// TODO Auto-generated method stub
		int count=0;
		query_statement = "from com.ree.hibernate.RepEntInfo where entEmail = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entEmail);
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
	private int CheckName(String entName) {
		int count = 0;
		query_statement = "from com.ree.hibernate.RepEntInfo where entName = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, entName);
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
	 * Title: GetEntItem_By_EntId<／p>
	 * <p>
	 * Description:通过eid获得企业信息 <／p>
	 * <p>
	 * Return:NewsBean
	 * </p>
	 * 
	 * @param eid
	 * @return
	 */
	public RepEntInfo GetEntItem_By_EntId(int eid) {
		query_statement = "from com.ree.hibernate.RepEntInfo where entNo = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, eid);
			list = query.list();
			if(list.size()>0)
				eBean = list.get(0);
			//eBean = org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);(eBean);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return eBean;
	}
	
	/**
	 * 
	* <p>Title:  Update_EntInfo_By_Bean<／p>
	* <p>Description:通过bean更新企业信息 <／p>
	* <p>Return:String</p>
	* @param b
	* @return
	 */
	public String Update_EntInfo_By_Bean(RepEntInfo b){
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
	
	public Object getBean(Class c,Serializable p){
		return s.getBean(c, p);
	}

	public List<RepEntInfoViewId> GetEntItems_By_All(int pageNum, int numPerPage,String orderField, String orderDirection, String keyword) {
		List<RepEntInfoViewId> list = null;
		String[] params = new String[] { orderField,orderDirection};
		query_statement = HQLScripts.GetScript("RepEntInfoView")+" where id.entName like ? order by %s %s";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
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
	public int GetEntTotalCount_By_All(int pageNum, int numPerPage,String orderField, String orderDirection, String keyword) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		int count=0;
		List<RepEntInfoViewId> list = null;
		List<RepEntInfoViewId> list1 = new ArrayList<RepEntInfoViewId>();
		String[] params = new String[] { orderField,orderDirection};
		query_statement = HQLScripts.GetScript("RepEntInfoView")+" where id.entName like ?";
		try{
			Query query = s.getQuery(String.format(query_statement, params));
			query.setParameter(0, '%' + (keyword==null?"":keyword) + '%');
			list = query.list();
			for(RepEntInfoViewId r:list){
				if((r.getCommunityAddr()==null?"":r.getCommunityAddr()).contains(session.get("admin_range")==null?"":session.get("admin_range").toString())){
				list1.add(r);	
				}
			}
			count=list1.size();
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return count;
	}

	public void Del_ent_By_id(int ent_no) {
		try {
			s.Delete(s.getBean(RepEntInfo.class, ent_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
		
	}
	public void Del_Job_By_id(int job_no) {
		try {
			s.Delete(s.getBean(RepEntJobInfo.class, job_no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		finally{
			s.closeSession();
		}
		
	}

	public List<RepEntInfoViewId> GetEntBeans_By_All() {
		List<RepEntInfoViewId> list = null;
		query_statement = "select new com.ree.hibernate.RepEntInfoViewId(id.entNo, "
				+ "id.entName,id.entUid,id.entPwd,id.entEmail,id.entContactMan,id.entContactPhone,"
				+ "id.entContactAddr,id.entTypeEconomy,id.entTypeTrade,id.communityAddr,id.entSercurityNum,"
				+ "id.entOCode,id.entCertUrlSer,id.entCertUrlO,id.entCertUrlLicence,id.reserved01) from com.ree.hibernate.RepEntInfoView";
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

	public RepEntJobInfo GetJobItem_By_JobId(int job_no) {
		RepEntJobInfo eBean=null;
		List<RepEntJobInfo> list = null;
		query_statement = "from com.ree.hibernate.RepEntJobInfo where jobNo = ? ";
		try{
			Query query = s.getQuery(query_statement);
			query.setParameter(0, job_no);
			list = query.list();
			if(list.size()>0)
				eBean = list.get(0);
			//eBean = org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);(eBean);
		}
		catch(HibernateException e){
			throw new RuntimeException(e);
		}
		finally{
			s.closeSession();
		}
		return eBean;
	}

	public String Update_JobInfo_By_Bean(RepEntJobInfo rBean) {
		String rs = null;
		try {
			s.Update(rBean);
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
}
