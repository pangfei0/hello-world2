/**   
 * @Title: EntJobAction.java 
 * @Package com.ree.enterprise 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Administrator - 李丁
 * @date 2014年10月16日 下午11:56:43 
 * @version  
 */
package com.ree.enterprise;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ree.common.DBHelper;
import com.ree.common.FileHelper;
import com.ree.common.ScoreHelper;
import com.ree.common.SessionHelper;
import com.ree.dict.DictDao;
import com.ree.hibernate.RepEntBlacklistUser;
import com.ree.hibernate.RepEntBlacklistUserId;
import com.ree.hibernate.RepEntInfo;
import com.ree.hibernate.RepEntJobInfo;
import com.ree.hibernate.RepEntJobInfoViewId;
import com.ree.hibernate.RepEntJobUser;
import com.ree.hibernate.RepEntJobUserId;
import com.ree.hibernate.RepEntJobUserViewId;
import com.ree.hibernate.RepUserInfo;

/**
 * @ClassName: EntJobAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator - 李丁
 * @date 2014年10月16日 下午11:56:43
 * 
 */
public class EntJobAction extends ActionSupport {
	private EntJobDao jDao = new EntJobDao();

	/**
	 * 输入
	 */
	private RepEntJobInfoViewId jobBean = new RepEntJobInfoViewId();
	private RepEntJobUser recruitBean = new RepEntJobUser();
	private int c;
	private int p;
	private String sortBy = "";
	private String sortMethod = "";
	RepEntInfo eBean;
	/**
	 * 输出
	 */
	private String sc = "";
	private int status;
	private HashMap<String, Object> store = new LinkedHashMap<String, Object>();

	private List<RepEntJobInfoViewId> list;
	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @Title: Get
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws 0-缺省，1-未登录，2-错误，3-成功
	 */
	public String Get_By_EntNo() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		try {
			if (session.get("u_type") == null) {
				status = 1;
				throw new Exception("未登录");
			}
			eBean = (RepEntInfo) session.get("entbean");
			list = jDao.GetEntJobInfoList_By_EntNo_jobBean(eBean.getEntNo(), jobBean, c, p, sortBy, sortMethod);// test_ld
			//list = jDao.GetEntJobInfoList_By_EntNo_jobName(eBean.getEntNo(), jobBean.getJobName(),jobBean.getJobAddrPosName(), c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", jDao.CountEntJobInfoList_By_entNo_jobBean(eBean.getEntNo(),jobBean));
			//store.put("totalNum", jDao.CountEntJobInfoList_By_All(jobBean.getJobName(),eBean.getEntName(),jobBean.getJobAddrPosName()));
			status = 3;
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: Get_By_All
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String Get_By_All() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		int size = 0;
		try {
//			if (session.get("u_type") == null) {
//				status = 1;
//				throw new Exception("未登录");
//			}
			//no-session
			if (session.get("u_type") == null) {
				status = 4;
				this.setSc("招聘信息-未登录,只能使用部分功能");
			}
			RepUserInfo uBean = (RepUserInfo) session.get("userbean");
			if (session.get("u_type") != null&&(uBean.getUserIntention() == null ||
					uBean.getUserName() == null ||
					uBean.getUserPhone() == null ||
					uBean.getUserAge() == null ||
					uBean.getUserEducationNo() == null ||
					uBean.getUserExpNo() == null)) {
				status = 2;
				throw new Exception("个人信息不完整，请填写");
			}
			if (sortBy.equals("id.reserved01"))
			{
				//list = jDao.GetEntJobInfoList_By_All(uBean.getUserIntention());
				list = jDao.GetEntJobInfoList_By_All_Allowed(uBean.getUserIntention());
				size = list.size();
				//new ScoreHelper();
				// 加入匹配度
				for (RepEntJobInfoViewId r : list) {
					int score = ScoreHelper
							.GetJobScore_By_UserBean_And_JobInfoList(uBean, r);
					r.setReserved01(String.valueOf(score));
				}
				//智能排序
				if (sortMethod.equals("desc")) {
					// 倒叙
					Collections.sort(list, new Comparator<RepEntJobInfoViewId>() {

						@Override
						public int compare(RepEntJobInfoViewId o1,
								RepEntJobInfoViewId o2) {
							int hits0 = Integer.parseInt(o1.getReserved01());
							int hits1 = Integer.parseInt(o2.getReserved01());
							if (hits1 > hits0) {
								return 1;
							} else if (hits1 == hits0) {
								return 0;
							} else {
								return -1;
							}
							// TODO Auto-generated method stub
						}
					});
				}
				else if(sortMethod.equals("asc"))
				{
					// 正叙
					Collections.sort(list, new Comparator<RepEntJobInfoViewId>() {

						@Override
						public int compare(RepEntJobInfoViewId o1,
								RepEntJobInfoViewId o2) {
							int hits0 = Integer.parseInt(o1.getReserved01());
							int hits1 = Integer.parseInt(o2.getReserved01());
							if (hits1 < hits0) {
								return 1;
							} else if (hits1 == hits0) {
								return 0;
							} else {
								return -1;
							}
							// TODO Auto-generated method stub
						}
					});
				}
				//分页
				list=list.subList((c-1)*p, c*p>list.size()?list.size():c*p);
			}
			else
			{
				//
//				list = jDao.GetEntJobInfoList_By_All_Allowed(jobBean.getJobName(),jobBean.getEntName(),jobBean.getJobAddrPosName(), c, p,
//						sortBy, sortMethod);
				list = jDao.GetEntJobInfoList_By_All_jobBean_Allowed(jobBean, c, p,
						sortBy, sortMethod);
			}
			store.put("data", list);
			//store.put("totalNum", sortBy.equals("id.reserved01")?size:jDao.CountEntJobInfoList_By_All_Allowed(jobBean.getJobName(),jobBean.getEntName(),jobBean.getJobAddrPosName()));
			store.put("totalNum", sortBy.equals("id.reserved01")?size:jDao.CountEntJobInfoList_By_All_jobBean_Allowed(jobBean));
			status = status==4?status:3;
			
			
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}

	/**
	 * 
	* @Title: Resume_Get_By_All 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Resume_Get_By_All() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepEntJobUserViewId> list = null;
		eBean = (RepEntInfo) session.get("entbean");
		try {
			if (session.get("u_type") == null) {
				status = 1;
				throw new Exception("未登录");
			}
			// RepUserInfo uBean = (RepUserInfo)session.get("userbean");
			list = jDao.GetEntJobUserList_By_All(eBean.getEntName(),
					jobBean.getJobName(), c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", jDao.CountEntJobUserList_By_All(jobBean.getEntName(),jobBean.getJobName()));
			status = 3;
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	* @Title: Get_By_All_myLib 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Get_By_All_myLib() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		List<RepEntJobUserViewId> list = null;
		eBean = (RepEntInfo) session.get("entbean");
		try {
			if (session.get("u_type") == null) {
				status = 1;
				throw new Exception("未登录");
			}
			list = jDao.GetEntJobUserList_By_All_myLib(eBean.getEntNo(),
					jobBean.getJobName(), c, p, sortBy, sortMethod);
			store.put("data", list);
			store.put("totalNum", jDao.CountEntJobUserList_By_All_myLib(eBean.getEntNo(),jobBean.getJobName()));
			status = 3;
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		return SUCCESS;
	}

	/**
	 * 
	* @Title: ValicationJobForm 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param b
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String ValicationJobForm(RepEntJobInfoViewId b){
		if(b.getJobName()==null||b.getJobName().length()<1)
			return "职位名称为空";
		if(b.getJobPnum()==null||b.getJobPnum()==0)
			return "招聘人数为空";
		if(b.getJobAddrPosNo()==null||b.getJobAddrPosNo()=="0"||b.getJobAddrPosNo().length()<1)
			return "招聘地点不正确";
		else return null;
	}
	/**
	 * 
	 * @Title: Add
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String Add() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		RepEntJobInfo b = new RepEntJobInfo();
		DictDao dDao = new DictDao();
		try {
			if (session.get("u_type") == null
					|| Integer.parseInt(session.get("u_type").toString()) != 1) {
				status = 1;
				throw new Exception("未登录");
			}
			eBean = (RepEntInfo) session.get("entbean");
			
			//验证表单
			sc = this.ValicationJobForm(jobBean);
			if(sc!=null)
				throw new Exception("-表单错误");
			
			b.setJobName(jobBean.getJobName());
			b.setJobSalaryNo(jobBean.getJobSalaryNo());
			b.setJobTypePos(jobBean.getJobTypePos());
			b.setJobEducationNo(jobBean.getEducationDictNo());
			b.setJobExpNo(jobBean.getJobExpDictNo());
			int ej = dDao.GetState_By_No(3);
			if(ej==0){//职位发布审核开关
				b.setJobState(1);	
				b.setJobDecribe(jobBean.getJobDecribe());
				b.setJobAddrPos(jobBean.getJobAddrPosNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobSex(jobBean.getJobSex());
				b.setJobIntentionNo(jobBean.getJobIntentionDictNo());
				b.setJobEntNo(eBean.getEntNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobTypePriNo(jobBean.getJobTypePriDictNo());
				b.setJobSubmitTime(new Date());
				b.setJobStartTime(jobBean.getJobStartTime());
				b.setJobEndTime(jobBean.getJobEndTime());
				b.setJobAgeNo(jobBean.getJobAgeNo());
			}else{
				b.setJobState(0);	
				//敏感词
				String bandWord[] = DBHelper.GetSysValue_By_Name("banword", dDao.GetSysDict()).split(",");
				int n= dDao.GetState_By_No(1);
				if(n==1){//敏感词开关
					b.setJobState(0);			
						for (String w : bandWord) {
				            if (jobBean.getJobDecribe().indexOf(w)>=0){
				            	b.setJobState(2);//审核未通过
				            	status = 2;
				            	sc = jobBean.getJobDecribe().indexOf(w)+"处存在敏感词"+w;//入库
				            	break;
				            	//throw new Exception(jobBean.getJobDecribe().indexOf(w)+"处存在敏感词"+w);//不入库
				            }	
				        }
					}
				b.setJobDecribe(jobBean.getJobDecribe());
				b.setJobAddrPos(jobBean.getJobAddrPosNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobSex(jobBean.getJobSex());
				b.setJobIntentionNo(jobBean.getJobIntentionDictNo());
				b.setJobEntNo(eBean.getEntNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobTypePriNo(jobBean.getJobTypePriDictNo());
				b.setJobSubmitTime(new Date());
				b.setJobStartTime(jobBean.getJobStartTime());
				b.setJobEndTime(jobBean.getJobEndTime());
				b.setJobAgeNo(jobBean.getJobAgeNo());
			}
			//b.setJobStartTime(sdf.parse(jobBean.getJobStartTime()));
			jDao.Save(b);
			status = status==2?status:3;
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		
		FileHelper.writeLog("添加招聘信息_" + eBean.getEntName() + "," + jobBean.getJobName());
		return SUCCESS;
	}

	/**
	 * 
	* @Title: Modify 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String Modify(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		RepEntJobInfo b;
		DictDao dDao = new DictDao();
		try {
			if (session.get("u_type") == null
					|| Integer.parseInt(session.get("u_type").toString()) != 1) {
				status = 1;
				throw new Exception("未登录");
			}
			//验证表单
			sc = this.ValicationJobForm(jobBean);
			if(sc!=null)
				throw new Exception();
			
			eBean = (RepEntInfo) session.get("entbean");
			b = (RepEntJobInfo)jDao.getBean(RepEntJobInfo.class, jobBean.getJobNo());
			if(b!=null)
			{
				b.setJobName(jobBean.getJobName());
				b.setJobSalaryNo(jobBean.getJobSalaryNo());
				b.setJobTypePos(jobBean.getJobTypePos());
				b.setJobEducationNo(jobBean.getEducationDictNo());
				b.setJobExpNo(jobBean.getJobExpDictNo());
				/*b.setJobState(1);*/
				//敏感词
				String bandWord[] = DBHelper.GetSysValue_By_Name("banword", dDao.GetSysDict()).split(",");
				int n= dDao.GetState_By_No(1);
				if(n==1){//敏感词开关
				/*b.setJobState(0);*/				
					for (String w : bandWord) {
			            if (jobBean.getJobDecribe().indexOf(w)>=0){
			            	b.setJobState(2);//审核未通过
			            	status = 2;
			            	sc = jobBean.getJobDecribe().indexOf(w)+"处存在敏感词"+w;//入库
			            	break;
			            	//throw new Exception(jobBean.getJobDecribe().indexOf(w)+"处存在敏感词"+w);//不入库
			            }	
			            if(b.getJobState()==2&&jobBean.getJobDecribe().indexOf(w)==-1){
			            	b.setJobState(0);
			            	break;
			            }
			           /* else  	
			            	b.setJobState(1);*/
			        }
				}
				b.setJobDecribe(jobBean.getJobDecribe());
				b.setJobAddrPos(jobBean.getJobAddrPosNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobSex(jobBean.getJobSex());
				b.setJobIntentionNo(jobBean.getJobIntentionDictNo());
				b.setJobEntNo(eBean.getEntNo());
				b.setJobPnum(jobBean.getJobPnum());
				b.setJobTypePriNo(jobBean.getJobTypePriDictNo());
				b.setJobSubmitTime(new Date());
				b.setJobStartTime(jobBean.getJobStartTime());
				b.setJobEndTime(jobBean.getJobEndTime());
				b.setJobAgeNo(jobBean.getJobAgeNo());
				jDao.Update(b);
				status = status==2?status:3;
			}
			else{
				sc+="没有找到该职位";
				status = 2;
			}
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		
		FileHelper.writeLog("修改招聘信息_" + eBean.getEntName() + "," + jobBean.getJobName());
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: Del
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String Del() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		RepEntJobInfo tar = (RepEntJobInfo)jDao.getBean(RepEntJobInfo.class, jobBean.getJobNo());
		try {
		    eBean = (RepEntInfo) session.get("entbean");
			if (session.get("u_type") == null
					|| Integer.parseInt(session.get("u_type").toString()) != 1) {
				status = 1;
				throw new Exception("未登录");
			}
			jDao.Delete(tar);
			status = 3;
		} catch (Exception e) {
			sc += DBHelper.GetMsg(e);
			status = (status == 1 ? status : 2);
			e.printStackTrace();
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		
		FileHelper.writeLog("删除招聘信息_" + eBean.getEntName() + "," + tar.getJobName());
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: recruitJob
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String recruitJob() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		RepUserInfo userbean = null;
		try {
			RepEntJobInfoViewId jobBean = jDao.GetEntJobInfo_By_jobNo(recruitBean.getId().getJobNo());
			userbean = (RepUserInfo) session.get("userbean");
			if (session.get("u_type") == null
					|| Integer.parseInt(session.get("u_type").toString()) != 0
					|| userbean.getUserNo() == null) {
				status = 1;
				throw new Exception("未登录");
			}
			recruitBean.getId().setUserNo(userbean.getUserNo());
			recruitBean.setState(0);
			recruitBean.setSubmittime(new Date());
			//黑名单判断
			//找到职位对应的企业--jobBean
			RepEntBlacklistUserId blackid = new RepEntBlacklistUserId();
			blackid.setEntNo(jobBean.getEntNo());
			blackid.setUserCert(userbean.getUserCert());
			RepEntBlacklistUser bBean = (RepEntBlacklistUser)jDao.getBean(RepEntBlacklistUser.class, blackid);
			if(bBean !=null)
			    throw new Exception("您在该企业的黑名单内！");
			jDao.Save(recruitBean);
			status = 3;
			FileHelper.writeLog("应聘招聘信息_" + jobBean.getEntName() + "," + jobBean.getJobName() + "," + userbean!=null?userbean.getUserName():"null");
		} catch (Exception e) {
			sc += e.getMessage() == null ? e.getClass() : e.getMessage();
			if(sc.contains("Constraint"))
				sc = "已添加";
			status = (status == 1 ? status : 2);
		} finally {
			store.put("msg", sc);
			store.put("status", status);
		}
		
		return SUCCESS;
	}

	public HashMap<String, Object> getStore() {
		return store;
	}

	public void setStore(HashMap<String, Object> store) {
		this.store = store;
	}

	public RepEntJobInfoViewId getJobBean() {
		return jobBean;
	}

	public void setJobBean(RepEntJobInfoViewId jobBean) {
		this.jobBean = jobBean;
	}

	public RepEntJobUser getRecruitBean() {
		return recruitBean;
	}

	public void setRecruitBean(RepEntJobUser recruitBean) {
		this.recruitBean = recruitBean;
	}

	public EntJobDao getjDao() {
		return jDao;
	}

	public void setjDao(EntJobDao jDao) {
		this.jDao = jDao;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortMethod() {
		return sortMethod;
	}

	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}

	public RepEntInfo geteBean() {
		return eBean;
	}

	public void seteBean(RepEntInfo eBean) {
		this.eBean = eBean;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<RepEntJobInfoViewId> getList() {
		return list;
	}

	public void setList(List<RepEntJobInfoViewId> list) {
		this.list = list;
	}

}
